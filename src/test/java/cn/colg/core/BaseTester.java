package cn.colg.core;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.colg.dao.SeckillMapper;
import cn.colg.dao.SuccessKilledMapper;
import cn.colg.service.SeckillService;
import cn.colg.service.SuccessKilledService;

/**
 * 基础测试类，单元测试继承该类即可
 * 
 * spring-test, junit
 * 
 * 配置 Spring 和 Junit 整合
 *
 * @author colg
 */
@RunWith(SpringJUnit4ClassRunner.class) // junit启动时加载springIOC容器
@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" }) // 告诉junit sprign配置文件位置
public abstract class BaseTester {

	// 注入service
	@Autowired
	protected SeckillService seckillService;
	@Autowired
	protected SuccessKilledService successKilledService;

	// 注入mapper
	@Autowired
	protected SeckillMapper seckillMapper;
	@Autowired
	protected SuccessKilledMapper successKilledMapper;
}
