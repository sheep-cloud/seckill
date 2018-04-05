package cn.colg.service;

import cn.colg.entity.SuccessKilled;

public interface SuccessKilledService {

	/**
	 * 插入购买明细，可过滤重复
	 * 
	 * @param seckillId
	 *            秒杀商品id
	 * @param userPhone
	 *            用户手机号
	 * @return 插入的行数
	 */
	int insertSuccessKilled(String seckillId, String userPhone);

	/**
	 * 根据id和手机号查询SuccessKilled并携带秒杀产品对象实体
	 * 
	 * @param seckillId
	 * @return
	 */
	SuccessKilled findBySeckillId(String seckillId, String userPhone);
}
