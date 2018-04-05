package cn.colg.dao;

import cn.colg.entity.SuccessKilled;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuccessKilledMapper {
    int deleteByPrimaryKey(@Param("seckillId") String seckillId, @Param("userPhone") String userPhone);

    int insert(SuccessKilled record);

    SuccessKilled selectByPrimaryKey(@Param("seckillId") String seckillId, @Param("userPhone") String userPhone);

    List<SuccessKilled> selectAll();

    int updateByPrimaryKey(SuccessKilled record);
}