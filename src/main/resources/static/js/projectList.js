

function newPage(){
	if(isMoreEnable==true){
		//window.location.reload();
		if(window.location.href.indexOf('?')!=-1){
			window.location.href=window.location.href.split('?')[0];
		}else{
			window.location.href=window.location.href;
		}
	}
}

function exchange(id){
		$.ajax({
		data :{id:id},
		url : basepath+"/order/shopList",
		error : function(menu) {
			$.messager.alert('提示信息','服务器连接超时请重试!','error'); 
			return false;
		},
		success : function(result) {
			if(result.rs=='ok'){//成功
				$(window.parent.document).find('#ddTool').css('display','block');
				$(window.parent.document).find('#ddTool').html(result.ct);
/*				$('#ddTool').css('display','block');
				$('#ddTool').html(result.ct);*/
				//alert(result.ct);
			}else{
				alert(result.rs);
			}
		}
	}); 
}