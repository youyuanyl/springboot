<#assign basePath=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自定义系统</title>
<script>
	//此处设置项目全局变量：比如根路径
	var basePath = "${basePath}";
</script>

<link rel="stylesheet" href="${basePath }/css/main.css">
<link rel="stylesheet" href="${basePath }/css/style.css">

<script src="${basePath }/js/jquery-3.3.1.js"></script>
<script src="${basePath }/layer/layer.js"></script>

<script src="${basePath }/js/test.js"></script>
</head>
<body>
	<div class="main_div" style="">
		<div id="banner" style="height: 50px;">
			<div id="welcom">欢迎：${LOGIN_USER.name}</div>
			<div class="pass_change">
				<a href="${basePath}/logout.do">退出系统</a>
			</div>
		</div>
		<div id="body">
			<div style="height: 40px;width: 100%;">
				当前位置： ${currentLocation }
				<hr>
			</div>
			<#if firstLevelMenu??>
				<div class="menuDiv">
					<ul>
						<#list firstLevelMenu as menu>
							<li>
								<#if secondLevelMenuMap?? && secondLevelMenuMap[menu.id]?? >
									<a>${menu.menuname }</a>
									<#assign secondLevelMenu=secondLevelMenuMap[menu.id] />
									<#if secondLevelMenu??>
										<ul>
											<#list secondLevelMenu as sLevelmenu>
												<li>
													<a href="${basePath }${sLevelmenu.url }">${sLevelmenu.menuname }</a>
													<script type="text/javascript">
														jQuery("#currentLocation").text("${sLevelmenu.description }")
													</script>
												</li>
											</#list>
										</ul>
									</#if>
								<#else>
									<a href="${basePath }${menu.url }">${menu.menuname }</a>
									<script type="text/javascript">
										jQuery("#currentLocation").text("${menu.description }")
									</script>
								</#if>
							</li>
						</#list>
						<!-- <li>
							<a href="#">菜单一</a>
							<ul>
								<li>
									<a href="#">二级菜单</a>
								</li>
								<li>
									<a href="#">二级菜单</a>
								</li>
								<li>
									<a href="#">二级菜单</a>
								</li>
							</ul>
						</li> -->
					</ul>
				</div>
			<#else>
				<div>该用户未绑定角色，请联系系统管理员！</div>
			</#if>
