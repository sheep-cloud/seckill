package cn.colg.entity;

import cn.colg.core.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
 * 秒杀成功明细表
 *
 * @author colg
 */
public class SuccessKilled extends BaseEntity implements Serializable {
	/**
	 * 秒杀商品id
	 */
	private String seckillId;

	/**
	 * 用户手机号
	 */
	private String userPhone;

	/**
	 * 状态标识（-1：无效，0：成功，1：已付款）
	 */
	private String state;

	/**
	 * 变通： 多对一
	 */
	private Seckill seckill;

	/**
	 * 创建时间
	 */
	private Date createTime;

	private static final long serialVersionUID = 1L;

	/**
	 * 获取秒杀商品id
	 *
	 * @return seckill_id - 秒杀商品id
	 */
	public String getSeckillId() {
		return seckillId;
	}

	/**
	 * /* 设置seckillId
	 *
	 * @param seckillId
	 *            秒杀商品id
	 */
	public void setSeckillId(String seckillId) {
		this.seckillId = seckillId == null ? null : seckillId.trim();
	}

	/**
	 * 获取用户手机号
	 *
	 * @return user_phone - 用户手机号
	 */
	public String getUserPhone() {
		return userPhone;
	}

	/**
	 * /* 设置userPhone
	 *
	 * @param userPhone
	 *            用户手机号
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone == null ? null : userPhone.trim();
	}

	/**
	 * 获取状态标识（-1：无效，0：成功，1：已付款）
	 *
	 * @return state - 状态标识（-1：无效，0：成功，1：已付款）
	 */
	public String getState() {
		return state;
	}

	/**
	 * /* 设置state
	 *
	 * @param state
	 *            状态标识（-1：无效，0：成功，1：已付款）
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
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

	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

}