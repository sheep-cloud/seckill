### Java高并发秒杀系统API

#### 慕课网课程：
1. [Java高并发秒杀API之业务分析与DAO层 ](https://www.imooc.com/learn/630)
2. [Java高并发秒杀API之Service层](https://www.imooc.com/learn/631)
3. [Java高并发秒杀API之web层](https://www.imooc.com/learn/630)
4. [Java高并发秒杀API之高并发优化](https://www.imooc.com/learn/632)
5. [Java秒杀系统方案优化 高性能高并发实战](https://coding.imooc.com/class/168.html)

#### 秒杀功能
- 秒杀接口暴露
- 执行秒杀
- 相关查询

#### 代码开发阶段
- [Dao设计编码：接口设计+SQL编写](https://github.com/colg-cloud/seckill/tree/master/src/main/java/cn/colg/dao)
- [Service设计编码：业务逻辑实现](https://github.com/colg-cloud/seckill/tree/master/src/main/java/cn/colg/service)
- Web设计编码

---

#### 技术总结
#####联合主键，避免重复秒杀
```
-- 秒杀成功明细表
-- 联合主键
PRIMARY KEY (seckill_id, user_phone),
```
在这里使用**秒杀商品id+用户手机号**作为秒杀成功的一个联合主键。当用户使用该手机秒杀同一件商品时从数据库层面来说是不允许的。
可以从单元测试的日志查看：
```
	private static final Log log = LogFactory.get();

	@Test
	public void testInsertSuccessKilled() {
		String seckillId = "c18c169938c311e89fa754ee75c6aeb0";
		String userPhone = "18701012345";
		int insertCount = successKilledMapper.insertSuccessKilled(seckillId, userPhone);
		log.info("insertCount： {}", insertCount);
	}
```
执行结果：
1. 第一次：`INFO cn.colg.dao.SuccessKilledMapperTest - insertCount： 1`    表示插入成功
2. 第二次：`INFO cn.colg.dao.SuccessKilledMapperTest - insertCount： 0`    表示插入失败

#####使用注解控制事务方法的优点
```
	<!-- 配置基于注解的声明式事务  - 默认使用注解来管理事务行为 -->
	<tx:annotation-driven transaction-manager="transactionManager"/>
	
	@Transactional(propagation=Propagation.REQUIRED) ：如果有事务, 那么加入事务, 没有的话新建一个(默认情况下)
	@Transactional(propagation=Propagation.NOT_SUPPORTED) ：容器不为这个方法开启事务
	@Transactional(propagation=Propagation.REQUIRES_NEW) ：不管是否存在事务,都创建一个新的事务,原来的挂起,新的执行完毕,继续执行老的事务
	@Transactional(propagation=Propagation.MANDATORY) ：必须在一个已有的事务中执行,否则抛出异常
	@Transactional(propagation=Propagation.NEVER) ：必须在一个没有的事务中执行,否则抛出异常(与Propagation.MANDATORY相反)
	@Transactional(propagation=Propagation.SUPPORTS) ：如果其他bean调用这个方法,在其他bean中声明事务,那就用事务.如果其他bean没有声明事务,那就不用事务.
	@Transactional(timeout=30) //默认是30秒
```
1. 开发团队达成一致的风格，明确标注事务方法的编程风格。
2. 保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC/HTTP请求或者剥离到事务方法外部。
3. 不是所有的方法都需要事务，如：只有一条修改操作，只读操作不需要事务控制

#### 前端页面流程
![这里写图片描述](https://img-blog.csdn.net/20180406050614687?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L05vclJpbkluVGhlU2t5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
####详情页流程逻辑
![这里写图片描述](https://img-blog.csdn.net/20180406050804438?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L05vclJpbkluVGhlU2t5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
####秒杀API的URL设计
![这里写图片描述](https://img-blog.csdn.net/20180406051459176?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L05vclJpbkluVGhlU2t5/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

######错误处理
[According to TLD or attribute directive in tag file, attribute value does not accept any expressions](https://blog.csdn.net/jasper_success/article/details/6693434)
```
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>		改为	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>	改为	<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
```