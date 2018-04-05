package cn.colg.enums;

/**
 * 使用枚举表述常量数据字段
 *
 * @author colg
 */
public enum SeckillStatEnum {
	
	// 枚举类必须定义枚举值，编译才会通过
	
	SUCCESS			("1", 	"秒杀成功"),
	END				("0", 	"秒杀结束"),
	REPEAT_KILL		("-1", 	"重复秒杀"),
	INNER_ERROR		("-2",	"系统异常"),
	DATA_REWRITE	("-3",	"数据篡改");
	
	
	private String state;
	private String stateInfo;

	private SeckillStatEnum(String state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public String getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static SeckillStatEnum stateOf(String state) {
		for (SeckillStatEnum statEnum : values()) {
			if (state.equals(statEnum.getState())) {
				return statEnum;
			}
		}
		return null;
	}
}
