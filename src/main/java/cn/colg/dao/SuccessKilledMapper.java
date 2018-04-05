package cn.colg.dao;

import org.apache.ibatis.annotations.Param;

import cn.colg.entity.SuccessKilled;

public interface SuccessKilledMapper {

	int insertSuccessKilled(@Param("seckillId") String seckillId, @Param("userPhone") String userPhone);

	SuccessKilled findBySeckillId(@Param("seckillId") String seckillId, @Param("userPhone") String userPhone);
}