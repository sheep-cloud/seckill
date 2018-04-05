package cn.colg.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;

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
		log.info("减库存：{}", seckillMapper.reduceNumber(id, new Date()));
	}

	@Test
	public void testFindById() {
		String id = "c18c12a838c311e89fa754ee75c6aeb0";
		log.info("根据id查询: {}", seckillMapper.findById(id));
	}

	@Test
	public void testQuerySeckill() {
		List<Seckill> list = seckillMapper.querySeckill(0, 100);
		log.info("分页查询结果：{}", list);
	}

}
