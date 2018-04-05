package cn.colg.dao;

import org.junit.Test;

import cn.colg.core.BaseTester;
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
		String userPhone = "18701012345";
		int insertCount = successKilledMapper.insertSuccessKilled(seckillId, userPhone);
		log.info("insertCount： {}", insertCount);
	}

	@Test
	public void testFindBySeckillId() {
		String seckillId = "c18c169938c311e89fa754ee75c6aeb0";
		String userPhone = "18701012345";
		SuccessKilled successKilled = successKilledMapper.findBySeckillId(seckillId, userPhone);
		log.info("successKilled：{}", successKilled);
	}

}
