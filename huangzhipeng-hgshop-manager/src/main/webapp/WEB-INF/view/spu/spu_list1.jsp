<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<base href="${pageContext.request.contextPath }/">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>hgshop后台管理系统</title>

	<!-- Bootstrap core CSS -->
    <link href="/resource/css/bootstrap.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" />
    <script type="text/javascript" src="/resource/jquery/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resource/bootstrap-treeview/js/bootstrap-treeview.js" ></script>
    
    <script>
    	$(function(){
    		$("#addCategoryName").click(function() {
    			$.post('/Category/categoryLists1', {}, function(data) {
    				var options = {
   						levels : 2,
   						data : data,
   						onNodeSelected : function(event, data) {
   							$("#addCategoryId").val(data.id);
   							$("#addCategoryName").val(data.text);
   							$("#tree").hide();//选中树节点后隐藏树
   						}
   					};
    				$('#tree').treeview(options);
					$('#tree').show();
    			});
			});
    	});
    	function preAddSpu(){
    		$('#addButton').show();
			$('#modalForm input').prop('readonly',false);
			$('#modalForm input').prop('disabled',false);
			$('#modalForm select').prop('disabled', false);
			$("#addBrandId").empty();
			$("#addBrandId").append("<option value=''>请选择品牌</option>");
			$("input[type='text']").val("");
    		$("[name=brandId]").val("");
    		$.post("/Brand/getAllBrands", {},function(data) {
               	//遍历数据
               	for(var i in data){
                    $("#addBrandId").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                }
			},"json");
    		$("#addSmallPic2").hide();
       }
    	function addSpu(){
    		var formData = new FormData($('#modalForm')[0]);
    		$.ajax({
                type:'post',
                data:formData,
                url:'/Spu/spuAdd',
				 processData : false, // 告诉jQuery不要去处理发送的数据
				 contentType : false, // 告诉jQuery不要去设置Content-Type请求头
				 dataType:'json',
				 success:function(data){
                       if(data){
                            //关闭模态框
                            $('#myModal').modal('hide')
                            window.location.reload();
                            
                           }else{
                            alert("商品添加失败");
                           }
	 				   
	 				 }
	 				
			   });
    		/* $.post('spuAdd',formData,function(data){
    			if(data){
    				$("#myModal").modal('hide');
    				window.location.reload();
    			}else{
    				alert('添加spu失败');
    			}
    		},'json'); */
    	}
    	function getSpuById(id,flag){
    		preAddSpu();
    		$("#addBrandId").empty();
    		$.post('/Spu/getSpuById',{id:id},function(data){
    			//$("#addSmallPic1").after('<img id="addSmallPic2" src="pic/' + data.smallPic + '" alt="商品图标">');
    			$("#addSmallPic2").prop("src", "pic/" + data.smallPic);
    			$("#addSmallPic2").show();
    			if(flag == 1){
    				$('#addButton').show();
    				$('#myModalLabel').text('编辑spu');
    				$('#modalForm input').prop('readonly',false);
    				$('#modalForm input').prop('disabled',false);
    				$('#modalForm select').prop('disabled', false);
    			}else{
    				$('#myModalLabel').text('查看spu');
    				$('#addButton').hide();
    				$('#modalForm input').prop('readonly',true);
    				$('#modalForm input').prop('disabled',true);
    				$('#modalForm select').prop('disabled', true);
    			}
    			$('#addId').val(data.id);
    			$('#addSmallPic').val(data.smallPic);
    			
    			$('#addGoodsName').val(data.goodsName);
    			$('#addCaption').val(data.caption);
    			$('#addIsMarketable').val(data.isMarketable);
    			$('#addBrandId').val(data.brandId);
    			$('#addBrandId option[value=' + data.brandId + ']').prop('selected',true);
    			$('#addCategoryId').val(data.categoryId);
    			$('#addCategoryName').val(data.cName);
    		},'json');
    	/* 	$("#addBrandId").prepend("<option value=''>请选择品牌</option>"); */
    	}
    	$(function(){
    		$('#cbk').on('click',function(){
    			$('.ck').prop('checked', this.checked);
    		});
    	})
    	
    	function deleteSpu(ids){
    		if(ids==undefined){
    			ids = $('.ck:checked').map(function(){
    				return this.value;
    			}).get().join(',');
    		}
    		if(ids!=''){
    			if(confirm('确定要删除选中的数据吗?')){
    				$.post('/Spu/spuDelete',{ids:ids},function(data){
    	    			if(data){
    	    				window.location.reload();
    	    			}else{
    	    				alert('删除spu失败');
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
						<!-- 加入了列 填充整行 -->
						<form class="col-sm-12" action="/Spu/spuList" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label>商品名称</label> 
								<input type="text" name="goodsName" class="form-control" placeholder="请输入品牌名称" value="${spu.goodsName}">
							</div>

							<div class="form-group">
								<label>商品副标题</label> 
								<input type="text" name="caption" class="form-control" placeholder="请输入商品副标题" value="${spu.caption}">
							</div>
							<!-- 隐藏分类的id值 -->
							<input type="hidden" id="cid" name="categoryId" value="${spu.categoryId}"/>
							<button class="btn btn-success" type="submit">搜索</button>
						</form>
					</div>

					<!-- 外边距(下方) 10像素的大小 -->
					<div class="row" style="margin-bottom: 10px;">
						<!-- 右端对齐 -->
						<div class="col-sm-12" align="right">
							<input type="button" class="btn btn-danger"
								onclick="deleteSpu()" value="批量删除" />
							<button class="btn btn-primary btn-sm" onclick="preAddSpu()"
								data-toggle="modal" data-target="#spuAddModal">添加商品</button>
						</div>
					</div>


					<div class="row">
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col"><input type="checkbox" id="cbk" />全选</th>
									<th scope="col">序号</th>
									<th scope="col">图标</th>
									<th scope="col">商品名称</th>
									<th scope="col">商品状态</th>
									<th scope="col">商品品牌</th>
									<th scope="col">商品分类</th>
									<th scope="col">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pageInfo.list}" var="spu" varStatus="index">
									<tr>
										<td scope="row">
											<input type="checkbox" class="ck" value="${spu.id}"/>
										</td>
										<td>${index.count}</td>
										<td>
											<img width="40px" height="40px" src="/pic/${spu.smallPic}"/>
										</td>
										<td>${spu.goodsName}</td>
										<td>${spu.isMarketable==0 ? '上架' : '下架'}</td>
										<td>${spu.bName}</td>
										<td>${spu.cName}</td>
										<td>
											<a href="javascript:void(0)" onclick="deleteSpu(${spu.id})" class="btn btn-info">删除</a>
											<button class="btn btn-info btn-sm" data-toggle="modal"
												data-target="#spuAddModal"
												onclick="getSpuById(${spu.id},1)">修改</button>
											<button class="btn btn-primary btn-sm" data-toggle="modal"
												data-target="#spuAddModal"
												onclick="getSpuById(${spu.id},2)">详情</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<nav>
				  <ul class="pagination">
				  	<c:if test="${pageInfo.hasPreviousPage}">
				    <li>
				      <a href="/Spu/spuList?pageNum=${pageInfo.pageNum - 1}&goodsName=${spu.goodsName}&caption=${spu.caption}&categoryId=${spu.categoryId}">
				        <span aria-hidden="true">上一页</span>
				      </a>
				    </li>
				    </c:if>
				    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
				    	<c:if test="${pageInfo.pageNum==pageNum}">
				    	<li class="active"><a href="/Spu/spuList?pageNum=${pageNum}&goodsName=${spu.goodsName}&caption=${spu.caption}&categoryId=${spu.categoryId}">${pageNum}</a></li>
				    	</c:if>
				    	<c:if test="${pageInfo.pageNum!=pageNum}">
				    	<li><a href="/Spu/spuList?pageNum=${pageNum}&goodsName=${spu.goodsName}&caption=${spu.caption}&categoryId=${spu.categoryId}">${pageNum}</a></li>
				    	</c:if>
				    </c:forEach>
				    <c:if test="${pageInfo.hasNextPage}">
				    <li>
				      <a href="/Spu/spuList?pageNum=${pageInfo.pageNum + 1}&goodsName=${spu.goodsName}&caption=${spu.caption}&categoryId=${spu.categoryId}" aria-label="Next">
				        <span aria-hidden="true">下一页</span>
				      </a>
				    </li>
				    </c:if>
				  </ul>
				</nav>
					</div>

	</div>


	<!-- ////////////////写入添加模态框 //////////////////////////////-->
	<div class="modal fade" id="spuAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<!-- 关闭的x效果 -->
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>

					<!-- 模态框的标题 -->
					<h4 class="modal-title" id="spuAddModalLabel">添加商品操作</h4>
				</div>
				<div class="modal-body">
					<form id="modalForm" enctype="multipart/form-data" action="javascript:void(0)">
						<input type="hidden" name="id" id="addId"/>
						<input type="hidden" name="smallPic" id="addSmallPic"/>
						<div class="form-group row">
							<label for="addGoodsName"
								class="col-sm-3 col-form-label col-form-label-sm">商品名称</label>
							<div class="col-sm-9">
								<input type="text" class="form-control form-control-sm"
									id="addGoodsName" name="goodsName" placeholder="请输入商品名称">
							</div>
						</div>

						<div class="form-group row">
							<label for="addCaption" class="col-sm-3 col-form-label">商品副标题</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="addCaption"
									name="caption" placeholder="请输入商品的副标题">
							</div>
						</div>

						<div class="form-group row">
							<label for="addIsMarketable" class="col-sm-3 col-form-label">商品状态</label>
							<div class="col-sm-9">
								<select class="form-control" id="addIsMarketable" name="isMarketable">
									<option value="0">上架</option>
									<option value="1">下架</option>
								</select>
							</div>
						</div>

						<div class="form-group row">
							<label for="addBrandId" class="col-sm-3 col-form-label">商品品牌</label>
							<div class="col-sm-9">
								<select class="form-control" id="addBrandId" name="brandId">
									
								</select>
							</div>
						</div>

						<div class="form-group row">
							<label for="addCategoryName" class="col-sm-3 col-form-label">商品分类</label>
							<!-- 左边部分 -->
							<div class="col-sm-9">
								<input type="hidden" class="form-control" id="addCategoryId" name="categoryId"> 
								<input type="text" class="form-control" id="addCategoryName" placeholder="选择商品分类">
								<div id="tree" style="display: none; position:absolute; z-index:1010; background-color:white; "></div>
							</div>
						</div>


						<div class="form-group row">
							<label for="addSmallPic1" class="col-sm-3 col-form-label">商品图标</label>
							<div class="col-sm-9">
								<input type="file" class="form-control" id="addSmallPic1"
									name="file" />
								<img id="addSmallPic2" alt="商品图标" style="display:none">
							</div>
						</div>


					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="addButton" onclick="addSpu()">添加</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- ///////////////////添加模态框结束//////////////////////////// -->


</body>
</html>