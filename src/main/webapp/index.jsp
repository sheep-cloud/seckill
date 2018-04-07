<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vue 测试实例</title>
<script src="https://cdn.bootcss.com/vue/2.2.2/vue.min.js"></script>
</head>
<body>
<div id="app">
  <table cellpadding="20">
  	<thead>
	  	<tr>
	  		<th>序号</th>
	  		<th>名称</th>
	  		<th>值</th>
	  	</tr>
  	</thead>
  	<tbody>
	  	<tr v-for="(value, key, index) in object">
	  		<td>{{index + 1}}</td>
	  		<td>{{key}}</td>
	  		<td>{{value}}</td>
	  	</tr>
  	</tbody>
  </table>
</div>

<script>
new Vue({
  el: '#app',
  data: {
    object: {
      name: '菜鸟教程',
      url: 'http://www.runoob.com',
      slogan: '学的不仅是技术，更是梦想！'
    },
  }
})
</script>
</body>
</html>