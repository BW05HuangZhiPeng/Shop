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
    <link href="/resource/css/bootstrap.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" />
    <script type="text/javascript" src="/resource/jquery/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resource/bootstrap-treeview/js/bootstrap-treeview.js" ></script>

</head>
<body>

		<div class="container-fluid">
					<div class="row">
						<!-- 加入了列 填充整行 -->
						<form class="col-sm-12" action="/Sku/skuList" method="post">
							<div class="form-group">
								<label>商品名称</label> 
								<input type="text" name="title" class="form-control" placeholder="请输入商品名称" value="${sku.title}">
							</div>

							<div class="form-group">
								<label>商品副标题</label> 
								<input type="text" name="sellPoint" class="form-control" placeholder="请输入卖点" value="${sku.sellPoint}">
							</div>
							<button class="btn btn-success" type="submit">搜索</button>
						</form>
					</div>

					<!-- 外边距(下方) 10像素的大小 -->
					<div class="row" style="margin-bottom: 10px;">
						<!-- 右端对齐 -->
						<div class="col-sm-12" align="right">
							<input type="button" class="btn btn-danger"
								onclick="deleteSku()" value="批量删除" />
							<button class="btn btn-primary btn-sm" onclick="preAddSku()"
								data-toggle="modal" data-target="#skuAddModal">添加sku</button>
						</div>
					</div>

					<div class="row">
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col"><input type="checkbox" id="cbk" />全选</th>
									<th scope="col">序号</th>
									<th scope="col">商品图片</th>
									<th scope="col">商品标题</th>
									<th scope="col">商品价格</th>
									<th scope="col">商品状态</th>
									<th scope="col">商品库存</th>
									<th scope="col">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pageInfo.list}" var="sku" varStatus="index">
									<tr>
										<td scope="row">
											<input type="checkbox" class="ck" value="${sku.id}"/>
										</td>
										<td>${index.count}</td>
										<td>
											<img width="40px" height="40px" src="pic/${sku.image}"/>
										</td>
										<td>${sku.title}</td>
										<td>${sku.price}</td>
										<td>${sku.status==0 ? '上架' : '下架' }</td>
										<td>${sku.stockCount}</td>
										<td>
											<a href="javascript:void(0)" onclick="deleteSku()" class="btn btn-info">删除</a>
											<button class="btn btn-info btn-sm" data-toggle="modal"
												data-target="#skuAddModal"
												onclick="getSkuById(${sku.id},1)">修改</button>
											<button class="btn btn-primary btn-sm" data-toggle="modal"
												data-target="#skuAddModal"
												onclick="getSkuById(${sku.id},2)">详情</button></td>
									</tr>
									</c:forEach>
							</tbody>
						</table>

						<nav>
				            ${Page}
						</nav>
					</div>
					
				</div>

			


	<!-- ////////////////写入添加模态框 //////////////////////////////-->
	<div class="modal fade" id="skuAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<!-- 关闭的x效果 -->
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true" onclick="clearAddSku()">&times;</button>

					<!-- 模态框的标题 -->
					<h4 class="modal-title" id="skuAddModalLabel">添加商品操作</h4>
				</div>
				<div class="modal-body">
					<form id="modalForm" enctype="multipart/form-data" action="javascript:void(0)">
						<input type="hidden" name="id" id="addId"/>
						<input type="hidden" name="image" id="addImage"/>
						<div class="form-group row">
							<label for="addTitle"
								class="col-sm-3 col-form-label col-form-label-sm">商品标题</label>
							<div class="col-sm-9">
								<input type="text" class="form-control form-control-sm"
									id="addTitle" name="title" placeholder="请输入商品标题">
							</div>
						</div>

						<div class="form-group row">
							<label for="addPrice" class="col-sm-3 col-form-label">商品价格</label>
							<div class="col-sm-9">
								<input type="number" class="form-control" id="addPrice"
									name="price" placeholder="请输入商品价格">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="addCostPrice" class="col-sm-3 col-form-label">成本价格</label>
							<div class="col-sm-9">
								<input type="number" class="form-control" id="addCostPrice"
									name="costPrice" placeholder="请输入成本价格">
							</div>
						</div>
						
						
						<div class="form-group row">
							<label for="addMarketPrice" class="col-sm-3 col-form-label">市场价格</label>
							<div class="col-sm-9">
								<input type="number" class="form-control" id="addMarketPrice"
									name="marketPrice" placeholder="请输入市场价格">
							</div>
						</div>


						<div class="form-group row">
							<label for="addSpuId" class="col-sm-3 col-form-label">所属商品</label>
							<div class="col-sm-9">
								<select class="form-control" id="addSpuId" name="spuId">
									<option value="">请选择商品</option>
								</select>
							</div>
						</div>



	                     <div class="form-group row">
							<label for="addStockCount" class="col-sm-3 col-form-label">商品库存</label>
							<div class="col-sm-9">
								<input type="number" class="form-control" id="addStockCount"
									name="stockCount" placeholder="请输入商品库存">
							</div>
						</div>
						
						  <div class="form-group row">
							<label for="addSellPoint" class="col-sm-3 col-form-label">商品卖点</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="addSellPoint"
									name="sellPoint" placeholder="请输入商品卖点">
							</div>
						</div>
						
						
						  <div class="form-group row">
							<label for="addBarcode" class="col-sm-3 col-form-label">商品条形码</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="addBarcode"
									name="barcode" placeholder="请输入商品条形码">
							</div>
						</div>
						
						

						<div class="form-group row">
							<label for="addImage1" class="col-sm-3 col-form-label">商品图标</label>
							<div class="col-sm-9">
								<input type="file" class="form-control" id="addImage1"
									name="file" />
								<img alt="商品图标" id="addImage2">
							</div>
						</div>
						
						<div class="form-group row">
							
							<div class="col-sm-6">
							   	<input type="button" class="btn btn-info" value="增加下来选中规格及选项内容"
									onclick="addSpecAndSpecOption()" />
							</div>
							
							<div class="col-sm-6">
								<select id="addSkuSpecId" class="form-control">
								  <option value="">请选择规格</option>
								</select>
							</div>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"  onclick="clearAddSku()">关闭</button>
					<button type="button" class="btn btn-primary" id="addButton" onclick="addSku()">添加</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- ///////////////////添加模态框结束//////////////////////////// -->


	<script type="text/javascript">
	
	 $('.page-link').click(function (e) {
		  	
	  	  //获取点击的的url
	      var url = $(this).attr('data');
	       // console.log(url);
	       //在中间区域显示地址的内容
	       location=url;
	  });
	function preAddSku(){
		clearAddSku();
		//追加商品
 		$.post("/Spu/spus", {},function(data) {
        	//遍历数据
        	for(var i in data){
            	$("#addSpuId").append("<option value='"+data[i].id+"'>"+data[i].goodsName+"</option>");
        	}
		},"json");

    	//追加规格
		$.post("/Spec/specs", {},function(data) {
        	//遍历数据
        	for(var i in data){
            	$("#addSkuSpecId").append("<option value='"+data[i].id+"'>"+data[i].specName+"</option>");
         	}
		},"json");
   }
	
	var ii=0;
    function addSpecAndSpecOption(){
        //规格的specId
        var specId = $("#addSkuSpecId option:selected").val();
        //查询出规格对应的规格选项
        $.post('/Spec/getSpecById',{id:specId},function(spec){
            if(spec!=null && spec.options!=null && spec.options.length>0){
               //定义拼接的字符串
               var options='';
               //遍历规格选项
               for(var i in spec.options){
                   options+='<option value="'+spec.options[i].id+'">'+spec.options[i].optionName+'</option>';
               }
               //创建div对象
               var str = '<div class="form-group row specOptionDiv"><label class="col-sm-3 col-form-label">'+spec.specName+'</label><input type="hidden" name="skuSpec['+ii+'].specId" value="'+spec.id+'"/><div class="col-sm-9"><select name="skuSpec['+ii+'].specOptionId" class="form-control"><option value="0">请选择'+spec.specName+'项</option>'+options+'</select></div></div>';
               //加入到指定的form中
               $("#modalForm").append(str);
               ii++;
            }else{
               alert("你的规格没有规格选项");
            }
            
        },'json');
    }
	
	function addSku(){
		var formData = new FormData($('#modalForm')[0]);
		$.ajax({
            type:'post',
            data:formData,
            url:'/Sku/skuAdd',
			processData : false, // 告诉jQuery不要去处理发送的数据
			contentType : false, // 告诉jQuery不要去设置Content-Type请求头
			dataType:'json',
			success:function(data){
               	if(data){
	               	//关闭模态框
	               	$('#myModal').modal('hide')
            		window.location.reload();
               	}else{
               		alert("sku添加失败");
               	}
 			}
		});
	}
	
	function clearAddSku(){
		$('#addId').val('');
		$('#addImage').val('');
		$('#addImage2').prop('src','');
		$('#addTitle').val('');
		$('#addSellPoint').val('');
		$('#addPrice').val('');
		$('#addCostPrice').val('');
		$('#addMarketPrice').val('');
		$('#addStockCount').val('');
		$('#addBarcode').val('');
		$('#addStatus').val('');
		
		$('#addButton').show();
		
		$('#modalForm input').prop('readonly', false);
		$('#modalForm input').prop('disabled',false);
		$('#modalForm select').prop('disabled', false);
		
		$('.specOptionDiv').remove();
		$("#addSpuId").html('<option value="">请选择商品</option>');
		
		$("#addSkuSpecId").html('<option value="">请选择规格</option>');
		
		ii = 0;
	}
	
	function getSkuById(id,flag){
    		preAddSku();
    		$.post('/Sku/getSkuById',{id:id},function(data){
    			var sku = data.sku;
    			var specs = data.specs;
    			
    			//1.规格参数div展示
    			for(var i in specs){
	            	//var spec = specs[i].specs.split(':');
	            	var spec = specs[i];
	            	//var optionArr = specs[i].options.split(',');
	            	var optionArr = spec.options;
                   	var options = '';
	            	for(var j in optionArr){
                   		//var option = optionArr[j].split(':');
                   		var option = optionArr[j];
                   		//options += '<option value="'+option[0]+'">'+option[1]+'</option>';
                   		options += '<option value="'+option.id+'">'+option.optionName+'</option>';
	            	}
                    //var str = '<div class="form-group row specOptionDiv"><label class="col-sm-3 col-form-label">'+spec[1]+'</label><input type="hidden" name="skuSpec['+ii+'].specId" value="'+spec[0]+'"/><div class="col-sm-9"><select id="specOptionId' + ii + '" name="skuSpec['+ii+'].specOptionId" class="form-control"><option value="0">请选择'+spec[1]+'项</option>'+options+'</select></div></div>';
                    var str = '<div class="form-group row specOptionDiv"><label class="col-sm-3 col-form-label">'+spec.specName+'</label><input type="hidden" name="skuSpec['+ii+'].specId" value="'+spec.id+'"/><div class="col-sm-9"><select id="specOptionId' + ii + '" name="skuSpec['+ii+'].specOptionId" class="form-control"><option value="0">请选择'+spec.specName+'项</option>'+options+'</select></div></div>';
                    $("#modalForm").append(str);
                	
                    //1.2.将各个规格参数选项进行默认值选中
                	var specs1 = sku.skuSpec;    			
    				for(var k in specs1){
    					//if(specs1[k].specId==spec[0]){
    					//1.2.1.如果规格参数选项是当前sku关联的spec_id，option处于选中状态
    					if(specs1[k].specId==spec.id){	
    						$('#specOptionId' + ii + ' option[value=' + specs1[k].specOptionId + ']').prop('selected',true);
    						break;
    					}
    				}	
    				ii++;
    			}
				
    			//2.sku信息展示
    			$('#addId').val(sku.id);
    			$('#addImage').val(sku.image);
    			$('#addImage2').prop('src','pic/' + sku.image);
    			$('#addTitle').val(sku.title);
    			$('#addSellPoint').val(sku.sellPoint);
    			$('#addPrice').val(sku.price);
    			$('#addCostPrice').val(sku.costPrice);
    			$('#addMarketPrice').val(sku.marketPrice);
    			$('#addSpuId option[value=' + sku.spuId + ']').prop('selected', true);
    			$('#addStockCount').val(sku.stockCount);
    			$('#addBarcode').val(sku.barcode);
    			$('#addStatus').val(sku.status);
    			
    			
    			if(flag == 1){
    				$('#skuAddModalLabel').text('编辑sku');
    			}else{
    				$('#skuAddModalLabel').text('查看sku');
    				$('#addButton').hide();
    				$('#modalForm input').prop('readonly',true);
    				$('#modalForm input').prop('disabled',true);
    				$('#modalForm select').prop('disabled', true);
    			}
    			
    			
    		},'json');
    	}
    	$(function(){
    		$('#cbk').on('click',function(){
    			$('.ck').prop('checked', this.checked);
    		});
    	})
    	function deleteSku(ids){
    		if(ids==undefined){
    			ids = $('.ck:checked').map(function(){
    				return this.value;
    			}).get().join(',');
    		}
    		if(ids!=''){
    			if(confirm('确定要删除选中的数据吗?')){
    				$.post('/Sku/skuDelete',{ids:ids},function(data){
    	    			if(data){
    	    				window.location.reload();
    	    			}else{
    	    				alert('删除sku失败');
    	    			}
    	    		},'json');
    			}
    		}else{
    			alert('请选中要删除的数据');
    		}
    	}
		
	</script>
</body>
</html>