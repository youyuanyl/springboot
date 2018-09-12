<#include "/includes/login-header.ftl">
<script type="text/javascript">
	jQuery(document).ready(function(){
		changeImg();
		
	})
	function login(){
		jQuery("#loginForm").submit();
	}
	//切换验证码
	function changeImg(){
		jQuery("#checkImg").attr("src", "${basePath}/loginCheckImage.do?t="+new Date().getTime());
	}
</script>

	<div style="margin: 0 auto;width: 310px;padding-top: 200px;">
	<form action="${basePath}/login.do" method="post" id="loginForm">
		<table cellspacing="10" class="login-table">
			<tr>
				<th>用户名</th>
				<td>
					<input type="text" id="username" name="username" value="" placeholder="用户名">
				</td>
			</tr>
			<tr>
				<th>密码</th>
				<td>
					<input type="password" id="password" name="password" value="" placeholder="密码">
				</td>
			</tr>
			<tr>
				<th>验证码</th>
				<td>
					<input type="text" id="checkcode" name="checkcode" placeholder="验证码" style="width: 130px;"/>
					<img src="" id="checkImg" class="checkImg" onclick="changeImg();"/>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="button" id="subButton" value="登录" onclick="login();">
					<input type="button" id="subButton" value="注册" onclick="javascript:window.location.href='${basePath}/toRegister.do'">
				</th>
			</tr>
		</table>
	</form>
</div>
<#include "/includes/issuccess.ftl">
<#include "/includes/login-footer.ftl">