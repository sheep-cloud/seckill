package cn.colg.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.colg.core.BaseController;
import cn.colg.dto.Exposer;
import cn.colg.dto.SeckillExecution;
import cn.colg.dto.SeckillResult;
import cn.colg.entity.Seckill;
import cn.colg.enums.SeckillStatEnum;
import cn.colg.exception.RepeatKillException;
import cn.colg.exception.SeckillCloseException;
import cn.colg.exception.SeckillException;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

@Controller
@RequestMapping("/seckill") // url：模块/资源/{id}/细分 /seckill/list
public class SeckillController extends BaseController {

	private static final Log log = LogFactory.get();

	/**
	 * 商品列表页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String list(Model model) {
		// 获取列表页
		List<Seckill> list = seckillService.querySeckill();
		model.addAttribute("list", list);
		// list.jsp + model = ModelAndView
		return "list";// WEB-INF/jsp/"list".jsp
	}

	/**
	 * 商品详情页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/{seckillId}/detail")
	public String detail(@PathVariable(required = false) String seckillId, Model model) {
		if (StrUtil.isBlank(seckillId)) {
			return "redirect:/seckill/list";// 重定向到 list
		}

		Seckill seckill = seckillService.findById(seckillId);
		if (seckill == null) {
			return "forward:/seckill/list";
		}
		model.addAttribute("seckill", seckill);
		return "detail";
	}

	/**
	 * 暴露秒杀地址
	 * 
	 * ajax json
	 * 
	 * @param seckillId
	 */
	@PostMapping("/{seckillId}/exposer")
	@ResponseBody
	public SeckillResult<Exposer> exposer(@PathVariable String seckillId) {
		SeckillResult<Exposer> result;
		try {
			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
			result = new SeckillResult<>(true, exposer);
		} catch (Exception e) {
			log.error(e);
			result = new SeckillResult<>(false, e.getMessage());
		}
		return result;
	}

	/**
	 * 执行秒杀
	 * 
	 * @param seckillId
	 * @param md5
	 * @param phone
	 * @return
	 */
	@PostMapping("/{seckillId}/{md5}/execution")
	@ResponseBody
	public SeckillResult<SeckillExecution> execute( @PathVariable("seckillId") String seckillId,
													@PathVariable("md5") String md5,
													@CookieValue(value = "killPhone", required = false) String phone) {
		// springmvc valid
		if (StrUtil.isBlank(phone)) {
			return new SeckillResult<>(false, "未注册");
		}
		
		SeckillResult<SeckillExecution> result;
		try {
			SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, phone, md5);
			result = new SeckillResult<SeckillExecution>(true, seckillExecution);
		} catch (RepeatKillException e) {
			SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
			result = new SeckillResult<>(true, seckillExecution);
		} catch (SeckillCloseException e) {
			SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStatEnum.END);
			result = new SeckillResult<>(true, seckillExecution);
		} catch (SeckillException e) {
			SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
			result = new SeckillResult<>(true, seckillExecution);
		}
		return result;
	}
	
	/**
	 * 获取系统时间
	 * 
	 * @return
	 */
	@GetMapping("/time/now")
	@ResponseBody
	public SeckillResult<Long> time() {
		long time = System.currentTimeMillis();
		return new SeckillResult<Long>(true, time);
	}
}
