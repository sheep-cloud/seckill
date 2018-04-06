<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>秒杀详情页</title>
<%@ include file="common/head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="panel panel-info">
			<div class="panner-heading text-center">
				<h1>${seckill.name }</h1>
			</div>
			<div class="panel-body text-center">
				<h2 class="text-danger btn-lg">
					<!-- 显示time图标 -->
					<span class="glyphicon glyphicon-time"></span>
					<!-- 展示倒计时 -->
					<span class="glyphicon" id="seckill-box"></span>
				</h2>
			</div>
			<div class="panel-footer"></div>
		</div>
	</div>
	<!-- 登录弹出层，输入电话 -->
	<div id="killPhoneModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title text-center btn-lg">
						<span class="glyphicon glyphicon-phone"></span> 秒杀电话：
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-8 col-xs-offset-2">
							<input type="text" name="killPhone" id="killphoneKey" placeholder="请填写手机号" class="form-control" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<!-- 验证信息 -->
					<span id="killPhoneMessage" class="glyphicon"></span>
					<button type="button" id="killPhoneBtn" class="btn btn-success btn-xs">
						<span class="glyphicon glyphicon-saved"></span> Submit
					</button>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- jquery-cookie 操作插件 -->
<script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<!-- jquery.countdown 倒计时插件 -->
<script src="https://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js"></script>

<!-- 开始编写交互逻辑 -->
<script src="/resources/script/seckill.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		// 使用EL表达式传入参数
		seckill.detail.init({
			seckillId : "${seckill.seckillId}",
			startTime : "${seckill.startTime.time}", 	// 毫秒
			endTime : "${seckill.endTime.time}" 		// 毫秒
		});
	});
</script>
</html>