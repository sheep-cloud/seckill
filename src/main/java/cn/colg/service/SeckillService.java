package cn.colg.service;

import java.util.List;

import cn.colg.dto.Exposer;
import cn.colg.dto.SeckillExecution;
import cn.colg.entity.Seckill;
import cn.colg.exception.RepeatKillException;
import cn.colg.exception.SeckillCloseException;
import cn.colg.exception.SeckillException;

/**
 * 业务接口：站在“使用者”角度设计接口 <br />
 * 
 * 三个方面： <br />
 * 1. 方法定义粒度 <br />
 * 2. 参数 <br />
 * 3. 返回类型{return 类型/异常;}
 *
 * @author colg
 */
public interface SeckillService {

	/**
	 * 查询所有秒杀记录
	 * 
	 * @return
	 */
	List<Seckill> querySeckill();

	/**
	 * 查询单个秒杀记录
	 * 
	 * @param seckillId
	 *            商品库存id
	 * @return
	 */
	Seckill findById(String seckillId);

	/**
	 * 秒杀开启时输出秒杀接口地址，否则输出系统时间和秒杀时间
	 * 
	 * @param seckillId
	 *            商品库存id
	 * @return 秒杀接口
	 */
	Exposer exportSeckillUrl(String seckillId);

	/**
	 * 执行秒杀操作
	 * 
	 * @param seckillId
	 *            库存商品id
	 * @param userPhone
	 *            用户手机号
	 * @param md5
	 * 
	 * 
	 * @return 秒杀执行后的结果
	 * 
	 * @throws SeckillException
	 *             秒杀相关业务异常
	 * @throws RepeatKillException
	 *             重复秒杀异常
	 * @throws SeckillCloseException
	 *             秒杀关闭异常
	 */
	SeckillExecution executeSeckill(String seckillId, String userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException;

}
