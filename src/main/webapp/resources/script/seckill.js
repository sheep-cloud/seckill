/*
	jquery.cookie.js插件：  
	      
	    <script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>  
	    <script type="text/javascript" src="js/jquery.cookie.js"></script>   
	      
	    新增cookie：  
	        $.cookie('cookieName', 'cookieValue');    
	        注：如果没有设置cookie的有效期，则cookie默认在浏览器关闭前都有效，故被称为"会话cookie"。  
	          
	        // 创建一个cookie并设置有效时间为7天:  
	        $.cookie('cookieName', 'cookieValue', { expires: 7 });  
	          
	        // 创建一个cookie并设置cookie的有效路径：  
	        $.cookie('cookieName', 'cookieValue', { expires: 7, path: '/' });  
	          
	    读取cookie：  
	        $.cookie('cookieName'); // 若cookie存在则返回'cookieValue'；若cookie不存在则返回null   
	          
	    删除cookie：把ncookie的值设为null即可  
	        $.cookie('the_cookie', null);   
 */

// 存放主要交互逻辑js代码
// javascript 模块化(package.class.method)
// seckill.detail.init(params);
/**
 * seckill 模块逻辑
 * 
 * seckill.detail.init(params);
 */
var seckill = {
	// 封装秒杀相关ajax的url
	URL : {
		now : function() {
			return "/seckill/time/now";
		},
		exposer : function(seckillId) {
			return "/seckill/" + seckillId + "/exposer";
		},
		execution : function(seckillId, md5) {
			return "/seckill/" + seckillId + "/" + md5 + "/execution";
		}
	},
	// 验证手机号
	validatePhone : function(phone) {
		if (phone && phone.length == 11 && !isNaN(phone)) {
			return true;
		} else {
			return false;
		}
	},
	// 处理秒杀逻辑
	handleSeckillKill : function(seckillId, node) {
		// 获取秒杀地址，控制显示逻辑，执行秒杀
		node.hide()
			.html('<button class="btn btn-primary btn-sm" id="killBtn">开始秒杀</button>');// 按钮
		$.post(seckill.URL.exposer(seckillId), {}, function(result) {
			// 在回调函数中，执行交互流程
			if(result && result["success"]) {
				var exposer = result["data"];
				if(exposer["exposed"]) {
					// 开启秒杀
					// 获取秒杀地址
					var md5 = exposer["md5"];
					var killUrl = seckill.URL.execution(seckillId, md5);
					// click 事件只能点击一次，防止用户重复点击
					$("#killBtn").one("click", function() {
						// 执行秒杀请求
						// 1：先禁用按钮
						$(this).addClass("disabled");
						// 2：发送秒杀请求
						$.post(killUrl, {}, function(result) {
							if(result && result["success"]) {
								var killResult = result["data"];
								var state = killResult["state"];
								var stateInfo = killResult["stateInfo"];
								console.log(stateInfo);
								// 3：显示秒杀结果
								node.html('<span class="label label-success">' + stateInfo + '</span>');
							}
						});
					});
					node.show();
				} else {
					// 未开启秒杀
					var now = exposer["now"];
					var start = exposer["start"];
					var end = exposer["end"];
					// 重新计算计时逻辑
					seckill.countdown(seckillId, now, startTime, endTime);
				}
			}
		});
	},
	// 秒杀倒计时
	countdown: function(seckillId, nowTime, startTime, endTime) {
		var seckillBox = $("#seckill-box");
		// 时间判断
		if(nowTime > endTime) {
			// 秒杀结束
			seckillBox.html("秒杀结束");
		} else if(nowTime < startTime) {
			// 秒杀未开始，计时事件绑定
			/*
			关于显示NaN天 NaN时 NaN分 NaN秒 的问题，原因是new Date(startTime + 1000)，startTime 被解释成一个字符串了。
			解决办法：	1.new Date(startTime-0 + 1000);
	          		2.new Date(Number(startTime) + 1000);
	         */
			var killTime = new Date(Number(startTime) + 1000); // 加上一秒，防止时间偏移
			seckillBox.countdown(killTime, function(event) {
				// 控制时间格式
				var format = event.strftime("秒杀倒计时： %D天  %H时 %M分 %S秒");
				seckillBox.html(format);
				// 时间完成后回调事件
			}).on("finish.countdown", function() {
				seckill.handleSeckillKill(seckillId, seckillBox);
			});
		} else {
			// 秒杀开始
			seckill.handleSeckillKill(seckillId, seckillBox);
		}
	},
	// 详情页秒杀逻辑
	detail : {
		// 详情页初始化
		init : function(params) {
			// 手机验证和登录，计时交互
			// 规划我们的交互流程
			// 在cookie中查找手机号
			var killPhone = $.cookie("killPhone");
			var seckillId = params["seckillId"];
			var startTime = params["startTime"];
			var endTime = params["endTime"];
			
			/*
			这种方式也可以
			console.log(params.seckillId);
			console.log(params.startTime);
			console.log(params.endTime);
			*/

			// 验证手机号
			if (!seckill.validatePhone(killPhone)) {
				// 绑定phone
				// 控制输出
				var killPhoneModal = $("#killPhoneModal");
				killPhoneModal.modal({
					show : true, 				// 当初始化时显示模态框。
					backdrop : "static", 		// 指定一个静态的背景，当用户点击模态框外部时不会关闭模态框。
					keyboard : false			// 当按下 escape 键时关闭模态框，设置为 false 时则按键无效。
				});
				$("#killPhoneBtn").click(function() {
					var inputPhone = $("#killphoneKey").val();
					if (seckill.validatePhone(inputPhone)) {
						// 手机号码写入cookie，7天，有效路径
						$.cookie("killPhone", inputPhone, {
							expires : 7,
							path : "/seckill"
						});
						// 刷新页面
						window.location.reload();
					} else {
						var label = '<label class="label label-danger">手机号错误!</label>';
						$("#killPhoneMessage").hide().html(label).show(300);
					}
				});
			}
			// 已经登录
			// 计时交互
			$.get(seckill.URL.now(), {}, function(result) {
				if(result && result["success"]) {
					var nowTime = result["data"];
					// 时间判断
					seckill.countdown(seckillId, nowTime, startTime, endTime);
				}
			});
		}
	}
}