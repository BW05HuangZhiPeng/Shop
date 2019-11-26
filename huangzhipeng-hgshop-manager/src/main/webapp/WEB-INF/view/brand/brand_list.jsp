<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>hgshop后台管理系统</title>

	<!-- Bootstrap core CSS -->
    <link href="/resource/css/bootstrap.css" rel="stylesheet">
     <script src="/resource/jquery/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.min.js" ></script>
    
  </head>
  
  <body>
  	<div class="container-fluid">
  		<div class="row">
  			<form action="/Brand/tobrand_list" method="post">
				  <div class="form-group">
				    <label for="name">品牌名称</label>
				    <input type="text" class="form-control" name="name" value="${brand.name}" placeholder="品牌名称">
				  </div>
				  <div class="form-group">
				    <label for="firstChar">品牌首字母</label>
				    <input type="text" class="form-control" name="firstChar" value="${brand.firstChar}" placeholder="品牌首字母">
				  </div>
				  <button class="btn btn-success" type="submit">搜索</button>
				</form>
  		</div>
  		
  		<div class="row" style="float: right;">
				  <button class="btn btn-danger" id="DelAll">批量删除</button>
				<button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#myModal">
				  新增品牌
				</button>
  		</div>
  		
  		<div class="row">
  			<table class="table table-striped">
		      <thead>
		        <tr>
		        	<th><input type="checkbox" id="cbk">全选</th>
		          <th>编号</th>
		          <th>品牌名称</th>
		          <th>首字母</th>
		          <th>状态</th>
		          <th>操作</th>
		        </tr>
		      </thead>
		      <tbody>
		      <c:if test="${brandlist!=null}">
		      <c:forEach items="${brandlist}" var="brand">
		        <tr>
		          <td><input type="checkbox" class="ck" value="${brand.id}"/></td>
		          <td>${brand.id}</td>
		          <td>${brand.name}</td>
		          <td>${brand.firstChar}</td>
		          
		           <c:if test="${brand.deletedFlag==0}">
		           <td>
		                               正常
		           </td>
		           </c:if>
		           <c:if test="${brand.deletedFlag==1}">
		           <td>
		                               删除
		           </td>
		           </c:if>
		          <td>
		          <c:if test="${brand.deletedFlag==0}">
		           <button class="btn btn-danger" name="Del" value="${brand.id}">删除</button>
		           </c:if>
		          <c:if test="${brand.deletedFlag==1}">
		           <button class="btn btn-success" name="QY" value="${brand.id}">启用</button>
		           </c:if>
		          	
		          	<button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#Upd" name="Upd" value="${brand.id }">
								  修改
								</button>
								
								<button type="button" class="btn btn-primary btn-md" data-toggle="modal" name="particulars" data-target="#particulars" value="${brand.id}"> 
								  查看
								</button>
		          </td>
		        </tr>
		        </c:forEach>
		        </c:if>
		      </tbody>
		    </table>
		    
		    <nav>
		    ${page}
				</nav>
  		</div>
  		
  	</div>
  
  
  	<!-- Add -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">新增品牌</h4>
		      </div>
		      <div class="modal-body">
		        <form class="form-horizontal" action="/Brand/Addbrand" onsubmit="return false" id="Addform">
						  <div class="form-group">
						    <label for="addName" class="col-sm-3 control-label">品牌名称</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" name="name" id="addName" placeholder="品牌名称">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="addFirstChar" class="col-sm-3 control-label">品牌首字母</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" name="firstChar" id="addFirstChar" placeholder="品牌首字母">
						    </div>
						  </div>
						  <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				        <button type="submit" class="btn btn-primary">添加</button>
		      </div>
						</form>
		      </div>
		    </div>
		  </div>
		</div>
		
		
  	<!-- Upd -->
		<div class="modal fade" id="Upd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">修改品牌</h4>
		      </div>
		      <div class="modal-body">
		        <form class="form-horizontal" action="/Brand/UpdBrand" onsubmit="return false" id="Updform">
		         <input type="hidden" name="id" id="updid"/>
						  <div class="form-group">
						    <label for="addName" class="col-sm-3 control-label">品牌名称</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" name="name" id="UpdName" placeholder="品牌名称">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="addFirstChar" class="col-sm-3 control-label">品牌首字母</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" name="firstChar" id="UpdFirstChar" placeholder="品牌首字母">
						    </div>
						  </div>
						  <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				        <button type="submit" class="btn btn-primary">修改</button>
		      </div>
						</form>
		      </div>
		    </div>
		  </div>
		</div>
		
		
  	<!-- 详情 -->
		<div class="modal fade" id="particulars" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">品牌详情</h4>
		      </div>
		      <div class="modal-body" id="parti">
		          
		         
		      </div>
		      <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		    </div>
		  </div>
		</div>
  
  </body>
  <script type="text/javascript">
  //添加
  $("#Addform").submit(function(){
	  var n=$("#addName").val();
	  var c=$("#addFirstChar").val();
	  if(n==null||n==""||c==null||c==""){
		  alert("不能为空");
		  return;
	  }else if(c.length>1){
		  alert("首字母不能长度不能大于1");
		  return;
	  }else{
		  $.post("/Brand/Addbrand",$("#Addform").serialize(),function(res){
			 if(res>0){
				 alert("添加成功！！！");
				 location="/Brand/tobrand_list";
			 }else{
				 alert("添加失败！！！");
			 } 
			 
		 });  
	  }
  });
  //修改
  $("#Updform").submit(function(){
	  var n=$("#UpdName").val();
	  var c=$("#UpdFirstChar").val();
	  if(n==null||n==""||c==null||c==""){
		  alert("不能为空");
		  return;
	  }else if(c.length>1){
		  alert("首字母不能长度不能大于1");
		  return;
	  }else{
		 $.post("/Brand/UpdBrand",$("#Updform").serialize(),function(res){
			 if(res>0){
				 alert("修改成功！！！");
				 location="/Brand/tobrand_list";
			 }else{
				 alert("修改失败！！！");
			 }
			 
		 }); 
	  }
	 
	  
	  
  });
  
  //回显
  $("[name=Upd]").click(function(){
	  var id=$(this).val();
	  $.post("/Brand/Parti?id="+id,function(data){
		  $("#updid").val(data.id);
		  $("#UpdName").val(data.name);
		  $("#UpdFirstChar").val(data.firstChar);
		  
	  }); 
  });
  

  //详情
  $("[name=particulars]").click(function(){
	  var id=$(this).val();
	  $("#parti").empty();
	  $.post("/Brand/Parti?id="+id,function(data){
		  var str="";
		  if (data.deletedFlag==1) {
			str="正常";
		}else{
			str="不存在";
		}
		  $("#parti").append('<p>品牌Id：'+data.id+'</p><p> 品牌名称：'+data.name+'</p><p>品牌首字母:'+data.firstChar+'</p><p>状态:'+str+'</p>');
	  });
  });
  
  //批量删除
  $("#DelAll").click(function(){
	  var id=[];
	  $(".ck:checked").each(function(){
		  id.push($(this).val());
	  })
	  if (id==null||id=="") {
		alert("请选中要删除的数据");
		return;
		}else{
			if(confirm("确定要删除吗？")){
				$.post("/Brand/DelAll?brandid="+id,function(res){
					 if(res>0){
						 alert("删除成功！！！");
						 location="/Brand/tobrand_list";
					 }else{
						 alert("删除失败！！！");
					 }
					 
				 }); 
			}
		}
	
	  
  });
  
  //启用
  $("[name=QY]").click(function(){
	  var id=[];
	  id.push($(this).val());
	  if (id==null||id=="") {
		alert("请选中要启用的数据");
		return;
		}else{
			if(confirm("确定要启用吗？")){
				$.post("/Brand/QYBrand?brandid="+id,function(res){
					 if(res>0){
						 alert("启用成功！！！");
						 location="/Brand/tobrand_list";
					 }else{
						 alert("启用失败！！！");
					 }
					 
				 }); 
			}
		}
	
	  
  });
 
  //删除
  $("[name=Del]").click(function(){
	  var id=[];
	  id.push($(this).val());
	  if (id==null||id=="") {
			alert("请选中要删除的数据");
			return;
			}else{
				if(confirm("确定要删除吗？")){
					$.post("/Brand/DelAll?brandid="+id,function(res){
						 if(res>0){
							 alert("删除成功！！！");
							 location="/Brand/tobrand_list";
						 }else{
							 alert("删除失败！！！");
						 }
						 
					 }); 
				}
			}
	  
  });
  
  //全选
   $("#cbk").click(function(){
		$(".ck").attr("checked",this.checked);
   });
  
//分页的点击事件
	 
  $('.page-link').click(function (e) {
  	
  	  //获取点击的的url
      var url = $(this).attr('data');
       // console.log(url);
       //在中间区域显示地址的内容
       location=url;
  });
  </script>
</html>