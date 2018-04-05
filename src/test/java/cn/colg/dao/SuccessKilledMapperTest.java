package cn.colg.dao;

import org.junit.Test;

import cn.colg.entity.SuccessKilled;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * 配置spring和junit整合
 * 
 * spring-test, junit
 *
 * @author colg
 */
public class SuccessKilledMapperTest extends BaseTester {

	private static final Log log = LogFactory.get();

	@Test
	public void testInsertSuccessKilled() {
		String seckillId = "c18c169938c311e89fa754ee75c6aeb0";
		int result = successKilledMapper.insertSuccessKilled(seckillId, "95205246715");
		log.info("插入购买明细，可过滤重复：{}", result);
	}

	@Test
	public void testFindBySeckillId() {
		String seckillId = "c18c169938c311e89fa754ee75c6aeb0";
		SuccessKilled successKilled = successKilledMapper.findBySeckillId(seckillId, "95205246715");
		log.info("根据id查询SuccessKilled并携带秒杀产品对象实体：{}", successKilled);
	}

}
