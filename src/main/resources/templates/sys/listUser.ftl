<#include "/includes/header.ftl">

<table cellspacing="0" class="list-table">
	<tr>
		<th>登录名</th>
		<th>密码</th>
		<th>用户名</th>
		<th>操作</th>
	</tr>
	<#list userList as user>
	<tr>
		<td>${user.username}</td>
		<td>${user.password}</td>
		<td>${user.name}</td>
		<td>${request.contextPath}</td>
	</tr>
	</#list>
</table>
<table cellspacing="0" class="list-table">
	<tr style="height: 50px;">
		<td style="text-align: center;">
			<a href="#">首页</a>
			&nbsp;&nbsp;
			<a href="#">上一页</a>
			&nbsp;&nbsp;
			<a href="#">下一页</a>
			&nbsp;&nbsp;
			<a href="#">尾页</a>
		</td>
	</tr>
</table>

<#include "/includes/footer.ftl">
