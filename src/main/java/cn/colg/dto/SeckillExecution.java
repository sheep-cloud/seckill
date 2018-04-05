package cn.colg.dto;

import cn.colg.core.BaseEntity;
import cn.colg.entity.SuccessKilled;
import cn.colg.enums.SeckillStatEnum;

/**
 * 封装秒杀执行后的结果
 *
 * @author colg
 */
public class SeckillExecution extends BaseEntity {

	/**
	 * 库存商品id
	 */
	private String seckillId;

	/**
	 * 商品秒杀状态标识（-1：无效，0：成功，1：已付款）
	 */
	private String state;

	/**
	 * 状态表示
	 */
	private String stateInfo;

	/**
	 * 秒杀成功对象，当秒杀成功时，返回此对象
	 */
	private SuccessKilled successKilled;

	public SeckillExecution() {
	}

	public SeckillExecution(String seckillId, SeckillStatEnum statEnum) {
		this.seckillId = seckillId;
		this.state = statEnum.getState();
		this.stateInfo = statEnum.getStateInfo();
	}

	public SeckillExecution(String seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
		this.seckillId = seckillId;
		this.state = statEnum.getState();
		this.stateInfo = statEnum.getStateInfo();
		this.successKilled = successKilled;
	}

	public String getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(String seckillId) {
		this.seckillId = seckillId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

}
