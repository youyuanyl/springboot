<#include "/includes/header.ftl">
<script type="text/javascript">
	jQuery(document).ready(function() {

	})
	function showOrHideChild(id) {
		var display = jQuery("#child" + id).css("display");
		jQuery(".childMenu").hide();
		
		if(display && display == "none"){
			jQuery("#child" + id).show();
		}
	}

</script>

<div>
	<div>
		<input type="button" id="" value="新增菜单" onclick="test.addMenu();">
	</div>
	<div>
		<ul>
			<#if menuList??>
				<#list menuList as menu>
					<li onclick="showOrHideChild('${menu.id}');" style="cursor: pointer;">
						<span>${menu.menuname }</span>
						<#if secondMap?? && secondMap[menu.id]?? >
							<#assign secondList = secondMap[menu.id] />
							<ul id="child${menu.id }" class="childMenu" style="display: none;">
								<#list secondList as second>
									<li>${second.menuname }</li>
								</#list>
							</ul>
						</#if>
					</li>
				</#list>
			</#if>
		</ul>
	</div>


</div>
<#include "/includes/footer.ftl">
