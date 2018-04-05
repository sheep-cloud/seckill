package cn.colg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.colg.dao.SuccessKilledMapper;
import cn.colg.entity.SuccessKilled;
import cn.colg.service.SuccessKilledService;

public class SuccessKilledServiceImpl implements SuccessKilledService {
	
	@Autowired
	private SuccessKilledMapper successKilledMapper;

	@Override
	public int insertSuccessKilled(String seckillId, String userPhone) {
		return successKilledMapper.insertSuccessKilled(seckillId, userPhone);
	}


	@Override
	public SuccessKilled findBySeckillId(String seckillId, String userPhone) {
		return successKilledMapper.findBySeckillId(seckillId, userPhone);
	}

}
