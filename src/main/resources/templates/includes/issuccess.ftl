<!-- 登录结果提示 -->
<#if issuccess?? && issuccess == "login_2">
   <script type="text/javascript">
		alert("验证码失效，请刷新后重新登录！");
	</script>
</#if>
<#if issuccess?? && issuccess == "login_3">
   <script type="text/javascript">
		alert("验证码输入错误，请重新输入！");
	</script>
</#if>
<#if issuccess?? && issuccess == "login_4">
   <script type="text/javascript">
		alert("用户名或密码错误！");
	</script>
</#if>

<!-- 注册结果提示 -->
<#if issuccess?? && issuccess == "register_1">
   <script type="text/javascript">
		alert("注册成功！");
	</script>
</#if>
<#if issuccess?? && issuccess == "register_2">
   <script type="text/javascript">
		alert("注册失败！");
	</script>
</#if>