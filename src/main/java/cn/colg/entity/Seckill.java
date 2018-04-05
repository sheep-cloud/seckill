package cn.colg.entity;

import cn.colg.core.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 秒杀库存表
 *
 * @author colg
 */
public class Seckill extends BaseEntity implements Serializable {
	/**
	 * 商品库存id
	 */
	private String seckillId;

	/**
	 * 商品名称
	 */
	private String name;

	/**
	 * 库存数量
	 */
	private Integer number;

	/**
	 * 秒杀开始时间
	 */
	private Date startTime;

	/**
	 * 秒杀结束时间
	 */
	private Date endTime;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 一对多
	 */
	private List<SuccessKilled> successKilleds;

	private static final long serialVersionUID = 1L;

	/**
	 * 获取商品库存id
	 *
	 * @return seckill_id - 商品库存id
	 */
	public String getSeckillId() {
		return seckillId;
	}

	/**
	 * /* 设置seckillId
	 *
	 * @param seckillId
	 *            商品库存id
	 */
	public void setSeckillId(String seckillId) {
		this.seckillId = seckillId == null ? null : seckillId.trim();
	}

	/**
	 * 获取商品名称
	 *
	 * @return name - 商品名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * /* 设置name
	 *
	 * @param name
	 *            商品名称
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 获取库存数量
	 *
	 * @return number - 库存数量
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * /* 设置number
	 *
	 * @param number
	 *            库存数量
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * 获取秒杀开始时间
	 *
	 * @return start_time - 秒杀开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * /* 设置startTime
	 *
	 * @param startTime
	 *            秒杀开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * 获取秒杀结束时间
	 *
	 * @return end_time - 秒杀结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * /* 设置endTime
	 *
	 * @param endTime
	 *            秒杀结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 获取创建时间
	 *
	 * @return create_time - 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * /* 设置createTime
	 *
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<SuccessKilled> getSuccessKilleds() {
		return successKilleds;
	}

	public void setSuccessKilleds(List<SuccessKilled> successKilleds) {
		this.successKilleds = successKilleds;
	}

}