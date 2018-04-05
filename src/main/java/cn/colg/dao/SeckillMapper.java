package cn.colg.dao;

import cn.colg.entity.Seckill;
import java.util.List;

public interface SeckillMapper {
    int deleteByPrimaryKey(String seckillId);

    int insert(Seckill record);

    Seckill selectByPrimaryKey(String seckillId);

    List<Seckill> selectAll();

    int updateByPrimaryKey(Seckill record);
}