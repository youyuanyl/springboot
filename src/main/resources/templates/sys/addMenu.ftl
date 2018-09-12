<#assign basePath=request.contextPath />
<div style="width: 400px;margin: 0 auto;">
	<form action="${basePath }/admin/saveMenu.do" method="post" id="saveMenuForm">
		<table cellspacing="5" width="100%;">
			<tr>
				<td>父菜单：</td>
				<td>
					<select id="parentidSel" name="parentid">
						<option value=""></option>
						<#list menuList as menu>
							<option value="${menu.id }">${menu.menuname }</option>
						</#list>
					</select>
				</td>
			</tr>
			<tr>
				<td>菜单名称：</td>
				<td>
					<input type="text" id="menuname" name="menuname">
				</td>
			</tr>
			<tr>
				<td>菜单路径：</td>
				<td>
					<input type="text" id="url" name="url">
				</td>
			</tr>
			<!-- <tr>
				<td>菜单描述：</td>
				<td>
					<input type="text" id="description" name="description">
				</td>
			</tr> -->
			<tr>
				<td>菜单顺序：</td>
				<td>
					<input type="text" id="ordernum" name="ordernum">
				</td>
			</tr>
		</table>
	</form>
</div>
