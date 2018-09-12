<#include "/includes/login-header.ftl">
<script type="text/javascript">
	function register(){
		jQuery("#registerForm").submit();
	}
</script>
<div id="main" style="width: 1000px;margin: 0 auto;">
	<form action="${basePath }/register.do" method="post" id="registerForm">
		<table  cellspacing="5">
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" id="username" name="username">
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>
					<input type="text" id="password" name="password">
				</td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td>
					<input type="text" id="name" name="name">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="registerBtn" value="提交" onclick="register();">
				</td>
			</tr>
		</table>
	</form>
</div>
<#include "/includes/issuccess.ftl">
<#include "/includes/login-footer.ftl">