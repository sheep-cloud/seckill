package cn.colg.core;

import org.springframework.beans.factory.annotation.Autowired;

import cn.colg.service.SeckillService;
import cn.colg.service.SuccessKilledService;

/**
 * Controller 的基类，用于抽取注入的Service
 * 
 * @author Yang Lei
 */
public abstract class BaseController {

	@Autowired
	protected SeckillService seckillService;
	@Autowired
	protected SuccessKilledService successKilledService;
}
