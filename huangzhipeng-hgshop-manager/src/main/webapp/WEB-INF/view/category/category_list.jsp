<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  	<base href="${pageContext.request.contextPath }/">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>hgshop后台管理系统</title>

<!-- Bootstrap core CSS -->
<link href="/resource/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" />
<script type="text/javascript" src="/resource/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="/resource/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"></script>

<script type="text/javascript">
	$(function() {
		$.post('/Category/categoryLists', {}, function(data) {
			$('#tree').treeview({
				data : data,
				onNodeSelected : function(event, node) {
					$(".pname").val(node.text);
					$(".pid").val(node.id);
					var parentNode = $("#tree").treeview('getParent', node);
					if (parentNode.id) {
						$("#updateParentId").val(parentNode.id);
					}
				}
			});
		});
	});
	
	function addCategory(id) {
		if ($("[name=name]").val()==null || $("[name=name]").val()=='') {
			alert("不能为空！！！");
		}else{
			$.post('/Category/categoryAdd', $("#" + id).serialize(), function(data) {
				if (data) {
					alert("添加成功");
					window.location.reload();
				} else {
					alert("添加失败");
				}
			}, "json");
		}
	}
	function deleteCategory() {
		var node = $("#tree").treeview('getSelected');
		if (node.length == 1) {
			var id = node[0].id;
			$.post('/Category/categoryDelete', {
				id : id
			}, function(data) {
				if (data.code==20010) {
					alert("删除成功");
					window.location.reload();
				} else {
					alert(data.code + ":" + data.msg);
				}
			}, 'json');
		}
	}
</script>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-5">
				<h3>展示分类列表</h3>
				<div id="tree"></div>
			</div>
			<div class="col-sm-7">
				<h3>分类添加操作</h3>
				<form class="form-horizontal" id="addForm">
					<div class="form-group">
						<label for="pname" class="col-sm-3 control-label">父分类</label>
						<div class="col-sm-9">
							<input type="text" class="form-control pname" id="pname"
								placeholder="父分类"> <input type="hidden" name="parentId"
								class="pid" />
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-3 control-label">分类名称</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="分类名称">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-10">
							<button class="btn btn-success" onclick="addCategory('addForm')">添加</button>
						</div>
					</div>
				</form>




				<h3>分类修改操作</h3>
				<form class="form-horizontal" id="updateForm">
					<input type="hidden" name="id" id="updateId" class="pid" /> <input
						type="hidden" name="parentId" id="updateParentId" />
					<div class="form-group">
						<label for="name" class="col-sm-3 control-label">分类名称</label>
						<div class="col-sm-9">
							<input type="text" class="form-control pname" id="updateName" name="name"
								placeholder="分类名称">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-10">
							<button class="btn btn-success" onclick="addCategory('updateForm')">修改选中节点</button>
						</div>
					</div>
				</form>



				<h3>删除操作</h3>
				<div class="row">
					<div class="col-sm-offset-2">
						<button class="btn btn-danger" onclick="deleteCategory()">删除选中节点</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
