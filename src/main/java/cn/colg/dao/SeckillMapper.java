package cn.colg.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.colg.entity.Seckill;

public interface SeckillMapper {

	int reduceNumber(@Param("seckillId") String seckillId, @Param("killTime") Date killTime);

	Seckill findById(@Param("seckillId") String seckillId);

	List<Seckill> querySeckill(@Param("offet") int offet, @Param("limit") int limit);
}