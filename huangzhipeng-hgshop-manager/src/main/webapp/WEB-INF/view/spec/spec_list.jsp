<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<base href="${pageContext.request.contextPath }/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>hgshop后台管理系统</title>

	<!-- Bootstrap core CSS -->
    <link href="/resource/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="/resource/jquery/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.min.js"></script>
    
    
    <script>
    	//全局变量
		  var index=0;
		  //增加选项
		  function addSpecOption(){
		   	//创建div的jquery对象
			  var $div = '<div class="form-group addOption" data-option-id='+0+'><label class="col-sm-3 control-label">规格内容</label><div class="col-sm-6"><input type="text" class="form-control" name="options['+index+'].optionName" placeholder="请输入规格内容"></div><div class="col-sm-3"><input type="button" class="btn-danger deleteOption" value="删除" onclick="deleteOption(this)"/></div></div>';
			  //传递参数判断的操作
			  //加入到指定的from表单中
			  $("#addForm").append($div);
			  //下标++
   			index++;
     	}
		  
		function deleteOption(obj){
 	 	  //$(obj)代表的把Dom对象转换成jquery对象: 通过找到加入的div的jquery对象,通过jquery中的parent()方法，再通过jquery对象中的remove()把自己删除
		  var $div = $(obj).parent().parent();
	      //自定属性的获取方式
	      var optionId = $div.data().optionId;
	      
	      if(optionId==0){
	    	  $div.remove();
	      }else{
	          $.post('/Spec/specOptionDelete',{id:optionId},function(data){
	        	if(data){
	              alert("选项删除成功");
	              $div.remove();
	            }else{
	              alert("选项删除失败");
	            }
	     	  },"json")
       	  }
 	 	 }
		
		function addSpec(){
			$.post('/Spec/specAdd',$('#addForm').serialize(),function(data){
	        	if(data){
	              alert("规格添加成功");
	              index = 0;
	              $('#myModal').modal('hide');
	              $('#addForm .addOption').remove();
	              window.location.reload();
	            }else{
	              alert("规格添加失败");
	            }
	     	  },"json")
		}
		function preAddSpec(){
			$('#addId').val('');
			$('#addSpecName').val('');
			$('#addForm .addOption').remove();
			
			$('#addSpec').show();
    		$('#addOption').show();
    		$('.deleteOption').show();
    		
    		$('#addForm input').prop('readonly', false);
			
			index = 0;
		}
		function getSpecById(id,flag){
			$.post('/Spec/getSpecById',{id:id},function(data){
	        	//1.填充spec数据
				$('#addId').val(data.id);
	        	$('#addSpecName').val(data.specName);
	        	//2.拼接spec_option选项
				var str = ''; 
	        	for(var i in data.options){
	        		str += '<div class="form-group addOption" data-option-id='+data.options[i].id+'><label class="col-sm-3 control-label">规格内容</label><div class="col-sm-6"><input type="hidden"  name="options['+index+'].id" value="' + data.options[i].id + '"/><input type="text" class="form-control" name="options['+index+'].optionName" placeholder="请输入规格内容" value="' + data.options[i].optionName + '"></div><div class="col-sm-3"><input type="button" class="btn-danger deleteOption" value="删除" onclick="deleteOption(this)"/></div></div>';
					index++;
	        	}
	        	$("#addForm").append(str);
	        	
	        	if(flag==2){
	        		$('#addSpec').hide();
	        		$('#addOption').hide();
	        		$('.deleteOption').hide();
	        		$('#addForm input').prop('readonly', true);
	        	}
	        	
			},"json")
		}
		$(function(){
    		$('#cbk').on('click',function(){
    			$('.ck').prop('checked', this.checked);
    		});
    	})
    	function deleteSpec(ids){
    		if(ids==undefined){
    			//批量删除 [user1,user2,user3]  ----> [1,2,3]
    			ids = $('.ck:checked').map(function(){
    				return this.value;
    			}).get().join(',');
    			alert(ids);
    		}
    		if(ids!=''){
    			if(confirm('确定要删除选中的数据吗?')){
    				$.post('/Spec/specDelete',{ids:ids},function(data){
    	    			if(data){
    	    				window.location.reload();
    	    			}else{
    	    				alert('删除规格失败');
    	    			}
    	    		},'json');
    			}
    		}else{
    			alert('请选中要删除的数据');
    		}
    	}
    </script>
  </head>
  
  <body>
  	<div class="container-fluid">
  		<div class="row">
  			<form action="/Spec/specList" method="post">
  				<input type="hidden"  name="pageNum" value="${pageInfo.pageNum }">
				  <div class="form-group">
				    <label for="specName">规格名称</label>
				    <input type="text" class="form-control" id="specName" name="specName" value="${spec.specName }" placeholder="规格名称">
				  </div>
				  <button class="btn btn-success" type="submit">搜索</button>
				</form>
  		</div>
  		
  		<div class="row" style="float: right;">
				  <button class="btn btn-danger" onclick="deleteSpec()">批量删除</button>
					<button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#myModal" onclick="preAddSpec()">
				  	新增规格
					</button>
  		</div>
  		
  		<div class="row">
  			<table class="table table-striped">
		      <thead>
		        <tr>
		        	<th><input type="checkbox" id="cbk">全选</th>
		          <th>编号</th>
		          <th>规格名称</th>
		          <th>规格选项</th>
		          <th>操作</th>
		        </tr>
		      </thead>
		      <tbody>
		      	<c:forEach items="${pageInfo.list}" var="spec" varStatus="index">
		        <tr>
		        	<td><input type="checkbox" class="ck" value="${spec.id}"/></td>
		          <td>${index.count }</td>
		          <td>${spec.specName }</td>
		          <td>
		          		${spec.optionNames}
		          </td>
		          <td>
		          	<button class="btn btn-danger" onclick="deleteSpec(${spec.id})">删除</button>
		          	<button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#myModal" onclick="getSpecById(${spec.id},1)">
								  修改
								</button>
								<button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#myModal" onclick="getSpecById(${spec.id},2)">
								  查看
								</button>
		          </td>
		        </tr>
		        </c:forEach>
		      </tbody>
		    </table>
		    
		    <nav>
				  <ul class="pagination">
				  	<c:if test="${pageInfo.hasPreviousPage}">
				    <li>
				      <a href="/Spec/specList?pageNum=${pageInfo.pageNum - 1}&specName=${spec.specName}">
				        <span aria-hidden="true">上一页</span>
				      </a>
				    </li>
				    </c:if>
				    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
				    	<c:if test="${pageInfo.pageNum==pageNum}">
				    	<li class="active"><a href="/Spec/specList?pageNum=${pageNum}&specName=${spec.specName}">${pageNum}</a></li>
				    	</c:if>
				    	<c:if test="${pageInfo.pageNum!=pageNum}">
				    	<li><a href="/Spec/specList?pageNum=${pageNum}&specName=${spec.specName}">${pageNum}</a></li>
				    	</c:if>
				    </c:forEach>
				    <c:if test="${pageInfo.hasNextPage}">
				    <li>
				      <a href="/Spec/specList?pageNum=${pageInfo.pageNum + 1}&specName=${spec.specName}" aria-label="Next">
				        <span aria-hidden="true">下一页</span>
				      </a>
				    </li>
				    </c:if>
				  </ul>
				</nav>
  		</div>
  	</div>
  
  
  	<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="preAddSpec()"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">新增规格参数</h4>
		      </div>
		      <div class="modal-body">
		        <form class="form-horizontal" id="addForm">
		        	<input type="hidden" id="addId" name="id"/>
						  <div class="form-group">
						    <label for="addSpecName" class="col-sm-3 control-label">规格名称</label>
						    <div class="col-sm-9">
						      <input type="text" class="form-control" id="addSpecName" name="specName" placeholder="规格名称">
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="col-sm-3">
									<input type="button" class="btn btn-info" value="增加选项内容" id="addOption"
										onclick="addSpecOption()" />
								</div>
						  </div>
						</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="preAddSpec()">关闭</button>
		        <button type="button" class="btn btn-primary" onclick="addSpec()" id="addSpec">添加</button>
		      </div>
		    </div>
		  </div>
		</div>

  </body>
</html>
