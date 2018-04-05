package cn.colg.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.colg.core.BaseTester;
import cn.colg.entity.Seckill;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * 配置spring和junit整合
 * 
 * spring-test, junit
 * 
 * @author colg
 */
public class SeckillMapperTest extends BaseTester {

	private static final Log log = LogFactory.get();

	@Test
	public void testReduceNumber() {
		String id = "c18c12a838c311e89fa754ee75c6aeb0";
		int updateCount = seckillMapper.reduceNumber(id, new Date());
		log.info("updateCount：{}", updateCount);
	}

	@Test
	public void testFindById() {
		String id = "c18c12a838c311e89fa754ee75c6aeb0";
		Seckill seckill = seckillMapper.findById(id);
		log.info("seckill: {}", seckill);
	}

	@Test
	public void testQuerySeckill() {
		List<Seckill> list = seckillMapper.querySeckill(0, 100);
		log.info("list：{}", list);
	}

	@Test
	public void testFindNameById() {
		String id = "c18c12a838c311e89fa754ee75c6aeb0";
		String name = seckillMapper.findNameById(id);
		log.info("name：{}", name);
	}

}
