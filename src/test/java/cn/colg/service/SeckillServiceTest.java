package cn.colg.service;

import java.util.List;

import org.junit.Test;

import cn.colg.core.BaseTester;
import cn.colg.dto.Exposer;
import cn.colg.dto.SeckillExecution;
import cn.colg.entity.Seckill;
import cn.colg.exception.RepeatKillException;
import cn.colg.exception.SeckillCloseException;
import cn.colg.exception.SeckillException;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

public class SeckillServiceTest extends BaseTester {

	private static final Log log = LogFactory.get();

	@Test
	public void testQuerySeckill() {
		List<Seckill> list = seckillService.querySeckill();
		log.info("list：{}", list);
	}

	@Test
	public void testFindById() {
		String seckillId = "c18c12a838c311e89fa754ee75c6aeb0";
		Seckill seckill = seckillService.findById(seckillId);
		log.info("seckill：{}", seckill);
	}

	@Test
	public void testExportSeckillUrl() {
		String seckillId = "c18c12a838c311e89fa754ee75c6aeb0";
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		log.info("exposer：{}", exposer);
		/*
		exposer: 
			{
				"end": 1446393600000,
				"exposed": false,
				"md5": null,
				"now": 1522959531529,
				"seckillId": "c18c12a838c311e89fa754ee75c6aeb0",
				"start": 1446307200000
			}
		*/
	}

	@Test
	public void testExecuteSeckill() {
		String seckillId = "c18c12a838c311e89fa754ee75c6aeb0";
		String userPhone = "95205246715";
		String md5 = "76be59afc9b970b7c3fa41f6f1539865";
		SeckillExecution seckillExecution = null;
		try {
			seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
			log.info("seckillExecution：{}", seckillExecution);
		} catch (RepeatKillException e) {
			log.error("e: {}", e.getMessage());
		} catch (SeckillCloseException e) {
			log.error("e: {}", e.getMessage());
		} catch (SeckillException e) {
			log.error("e: {}", e.getMessage());
		}

		/*
		{
			"seckillId": "c18c12a838c311e89fa754ee75c6aeb0",
			"state": "1",
			"stateInfo": "秒杀成功",
			"successKilled": {
			"createTime": "2018-04-06 04:31:22",
			"seckill": {
			"createTime": "2018-04-05 19:23:25",
			"endTime": "2015-11-02 00:00:00",
			"name": "1000元秒杀iphone6",
			"number": 99,
			"seckillId": "c18c12a838c311e89fa754ee75c6aeb0",
			"startTime": "2015-11-01 00:00:00",
			"successKilleds": null
			},
			"seckillId": "c18c12a838c311e89fa754ee75c6aeb0",
			"state": "0",
			"userPhone": "95205246715"
			}
		}
		*/
	}

	/**
	 * 集成测试代码完整逻辑，注意可重复执行。
	 * 
	 * 如果秒杀开启，执行秒杀操作，应该一起运行
	 */
	@Test
	public void testSeckillLogic() {
		String seckillId = "c18c12a838c311e89fa754ee75c6aeb0";
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if (exposer.getExposed()) {
			log.info("exposer：{}", exposer);

			// 执行秒杀操作
			String userPhone = "95205246715";
			String md5 = exposer.getMd5();
			SeckillExecution seckillExecution = null;
			try {
				seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
				log.info("seckillExecution：{}", seckillExecution);
			} catch (RepeatKillException e) {
				log.error("e: {}", e.getMessage());
			} catch (SeckillCloseException e) {
				log.error("e: {}", e.getMessage());
			} catch (SeckillException e) {
				log.error("e: {}", e.getMessage());
			}
		} else {
			log.warn("expose: {}", exposer);
		}
	}

}
