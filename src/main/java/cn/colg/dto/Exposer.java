package cn.colg.dto;

import cn.colg.core.BaseEntity;

/**
 * 暴露秒杀接口 dto
 *
 * @author colg
 */
public class Exposer extends BaseEntity {

	/**
	 * 是否开启秒杀
	 */
	private boolean exposed;

	/**
	 * 一种加密措施
	 */
	private String md5;

	/**
	 * 库存商品id
	 */
	private String seckillId;

	/**
	 * 系统当前时间（毫秒）
	 */
	private Long now;

	/**
	 * 秒杀开始时间
	 */
	private Long start;

	/**
	 * 秒杀结束时间
	 */
	private Long end;

	public Exposer() {
	}

	public Exposer(boolean exposed, String seckillId) {
		this.exposed = exposed;
		this.seckillId = seckillId;
	}

	public Exposer(boolean exposed, String md5, String seckillId) {
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
	}

	public Exposer(boolean exposed, String seckillId, Long now, Long start, Long end) {
		this.exposed = exposed;
		this.seckillId = seckillId;
		this.now = now;
		this.start = start;
		this.end = end;
	}

	public boolean getExposed() {
		return exposed;
	}

	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(String seckillId) {
		this.seckillId = seckillId;
	}

	public Long getNow() {
		return now;
	}

	public void setNow(Long now) {
		this.now = now;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getEnd() {
		return end;
	}

	public void setEnd(Long end) {
		this.end = end;
	}

}
