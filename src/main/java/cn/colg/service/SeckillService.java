package cn.colg.service;

import java.util.Date;
import java.util.List;

import cn.colg.entity.Seckill;

public interface SeckillService {

	/**
	 * 减库存
	 * 
	 * @param seckillId
	 *            商品库存id
	 * @param killTime
	 *            减库存的时间
	 * @return 如果影响行数>1，表示更新的记录行数
	 */
	int reduceNumber(String seckillId, Date killTime);

	/**
	 * 根据商品库存id查询
	 * 
	 * @param seckillId
	 *            商品库存id
	 * @return
	 */
	Seckill findById(String seckillId);

	/**
	 * 根据具偏移量查询秒杀商品列表
	 * 
	 * @param offet
	 * @param limit
	 * @return
	 */
	List<Seckill> querySeckill(int offet, int limit);
}
