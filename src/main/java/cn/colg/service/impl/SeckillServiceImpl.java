package cn.colg.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.colg.dao.SeckillMapper;
import cn.colg.entity.Seckill;
import cn.colg.service.SeckillService;

@Service
public class SeckillServiceImpl implements SeckillService {
	
	@Autowired
	private SeckillMapper seckillMapper;

	@Override
	public int reduceNumber(String seckillId, Date killTime) {
		return seckillMapper.reduceNumber(seckillId, killTime);
	}

	@Override
	public Seckill findById(String seckillId) {
		return seckillMapper.findById(seckillId);
	}

	@Override
	public List<Seckill> querySeckill(int offet, int limit) {
		return seckillMapper.querySeckill(offet, limit);
	}

}
