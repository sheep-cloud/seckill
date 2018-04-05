package cn.colg.dao;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * tester的基类，建议所有实体类都继承
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

	/**
	 * 注入mapper实现类依赖
	 */
	@Autowired
	protected SeckillMapper seckillMapper;
	@Autowired
	protected SuccessKilledMapper successKilledMapper;
}
