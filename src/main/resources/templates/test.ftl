<#assign basePath=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试页</title>
<style type="text/css">
table tr td {
	text-align: center;
}
</style>
<script type="text/javascript" src="${basePath }/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function() {
		timer();
		getData(); // 第一次加载数据
		/* setInterval(function() {
			getData();
		}, 10000); */
	});

	function getData() {
		jQuery.ajax({
			type : 'POST',
			url : "${basePath }/getData.do",
			dataType : "json",
			success : function(result) {
				var html = "<table border='1' bordercolor='#a0c6e5' style='border-collapse: collapse; width: 30%;'>";
				html += "<tr><th>单词</th><th>数量</th></tr>";
				for (var i = 0; i < result.length; i++) {
					//alert(result[i].word)
					html += "<tr><td>" + result[i].word + "</td><td>" + result[i].count + "</td></tr>";
				}
				html += "</table>";
				jQuery("#dataDIV").html(html);
			}
		})
	}

	function timer() {
		var second = parseInt(10);
		setInterval(function() {
			$(".timeShow").html('本页数据还剩下<font color="red">' + second + '</font>秒刷新,刷新间隔时间: 10 秒钟');
			if (second > 0) {
				second--;
			} else {
				second = parseInt(10);
				getData();
			}
		}, 1000);
	}

	function upload() {
		var formData = new FormData($('#uploadForm')[0]);
		$.ajax({
			type : 'post',
			url : "${basePath }/upload.do",
			data : formData,
			cache : false,
			processData : false,
			contentType : false,
		}).success(function(data) {
			alert(data);
		}).error(function() {
			alert("上传失败");
		});
	}
</script>
</head>
<body>
	<h1>测试页面</h1>
	<hr>
	<span class="timeShow"></span>
	<div id="dataDIV"></div>
	<hr>

	<form action="${basePath }/upload.do" method="post" enctype="multipart/form-data" id="uploadForm">
		<input type="file" id="file1" name="file1">
		<input type="file" id="file2" name="file2">
		<input type="file" id="file3" name="file3">
	</form>
	<a href="javascript:void(0)" onclick="upload()">上传</a>


</body>
</html>