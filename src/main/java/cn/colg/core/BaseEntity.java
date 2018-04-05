package cn.colg.core;

import cn.hutool.json.JSONUtil;

/**
 * entity的基类，建议所有实体类都继承
 *
 * @author colg
 */
public abstract class BaseEntity {

	@Override
	public String toString() {
		return JSONUtil.toJsonStr(this);
	}

}
