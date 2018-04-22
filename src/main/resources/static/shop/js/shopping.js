$(function(){
	flag=true;
	//
	function subData(param){

			$.ajax({
				data :param,
				async:false,
				url : basepath+"/order/orderSubmit",
				error : function(menu) {
					 
					return false;
				},
				success : function(result) {
					if(result.rs=='ok'){//成功

						//alert(result.ct);
					}else{
						flag=false;
						alert('积分不足');
					}
				}
			}); 
	}

	function subDatadel(param){

		$.ajax({
			data :param,
			async:false,
			url : basepath+"/order/orderSubmitdel",
			error : function(menu) {
				 
				return false;
			},
			success : function(result) {
				if(result.rs=='ok'){//成功

					//alert(result.ct);
				}else{
					flag=false;
					alert('未成功');
				}
			}
		}); 
}

	
	
    // 数量减
    $(".minus").click(function() {
    	var ischecked=$(this).closest('li ').find('.goodsCheck').get(0).checked;
    	if(ischecked){
        var t = $(this).parent().find('.num');
        var pre=parseInt(t.text());
        t.text(parseInt(t.text()) - 1);
        if (t.text() <= 1) {
            t.text(1);
        }
        if(pre!=1){
            $(this).closest('.shop-info-text').each(function(){
            	var id=$(this).find('h4').attr('name');
            	var money=parseFloat($(this).find('.shop-pices b').html());
            	var amount=parseFloat($(this).find('.num').html());
            	var param={};
            	param['id']=id;
            	subDatadel(param);

            	
            });

            TotalPrice();        	
        }
    }else{
		alert('请先选择订单项');
    }
    });
    // 数量加
    $(".plus").click(function() {
    	var ischecked=$(this).closest('li ').find('.goodsCheck').get(0).checked;
    	if(ischecked){
        var t = $(this).parent().find('.num');
        t.text(parseInt(t.text()) + 1);
        if (t.text() <= 1) {
            t.text(1);
        }
        
        $(this).closest('.shop-info-text').each(function(){
        	var id=$(this).find('h4').attr('name');
        	var money=parseFloat($(this).find('.shop-pices b').html());
        	var amount=parseFloat($(this).find('.num').html());
        	var param={};
        	param['id']=id;
            subData(param);
            if(!flag){
            t.text(parseInt(t.text()) - 1);
            }

        });
        if(flag){
        	TotalPrice();        	
        }

        flag=true;
    	}else{
    		alert('请先选择订单项');
    	}
    });
    
    
    function clearUncheck(param){
    	
		$.ajax({
			data :param,
			async:false,
			url : basepath+"/order/fixorderStatus",
			error : function(menu) {
				 
				return false;
			},
			success : function(result) {
				if(result.rs=='ok'){//成功

					//alert(result.ct);
				}else{
					
					alert(result.rs);
				}
			}
		}); 

    }
    /******------------分割线-----------------******/
      // 点击商品按钮
  $(".goodsCheck").click(function() {
    var goods = $(this).closest(".shop-group-item").find(".goodsCheck"); //获取本店铺的所有商品
    var goodsC = $(this).closest(".shop-group-item").find(".goodsCheck:checked"); //获取本店铺所有被选中的商品
    var Shops = $(this).closest(".shop-group-item").find(".shopCheck"); //获取本店铺的全选按钮
    var param={};    
    var id = $(this).closest("li").find(".shop-info-text h4").attr('name');

    var number=$(this).closest("li").find(".shop-arithmetic span ").html();

    if (goods.length == goodsC.length) { //如果选中的商品等于所有商品
      Shops.prop('checked', true); //店铺全选按钮被选中
      if ($(".shopCheck").length == $(".shopCheck:checked").length) { //如果店铺被选中的数量等于所有店铺的数量
        $("#AllCheck").prop('checked', true); //全选按钮被选中
        TotalPrice();
      } else {
        $("#AllCheck").prop('checked', false); //else全选按钮不被选中 
        TotalPrice();
      }
        $(".settlement").css({"background":"#ff4444","color":"#fff"});
    } else { //如果选中的商品不等于所有商品
      Shops.prop('checked', false); //店铺全选按钮不被选中
      $("#AllCheck").prop('checked', false); //全选按钮也不被选中
      // 计算
      TotalPrice();
      // 计算
        $(".settlement").css({"background":"#ff4444","color":"#fff"});
    }

    param["id"]=id;
    param["number"]=number;
    if(this.checked){
    	param["isChecked"]=true;  	
    }else{
    	param["isChecked"]=false;
    }
    clearUncheck(param);

  });
  // 点击店铺按钮
  $(".shopCheck").click(function() {
    if ($(this).prop("checked") == true) { //如果店铺按钮被选中
      $(this).parents(".shop-group-item").find(".goods-check").prop('checked', true); //店铺内的所有商品按钮也被选中
      if ($(".shopCheck").length == $(".shopCheck:checked").length) { //如果店铺被选中的数量等于所有店铺的数量
        $("#AllCheck").prop('checked', true); //全选按钮被选中
        TotalPrice();
         $(".settlement").css({"background":"#ff4444","color":"#fff"});
      } else {
        $("#AllCheck").prop('checked', false); //else全选按钮不被选中
        TotalPrice();
      }
    } else { //如果店铺按钮不被选中
      $(this).parents(".shop-group-item").find(".goods-check").prop('checked', false); //店铺内的所有商品也不被全选
      $("#AllCheck").prop('checked', false); //全选按钮也不被选中
      TotalPrice();
    }
  });
  // 点击全选按钮
  $("#AllCheck").click(function() {
    if ($(this).prop("checked") == true) { //如果全选按钮被选中
      $(".goods-check").prop('checked', true); //所有按钮都被选中
      TotalPrice();
       $(".settlement").css({"background":"#ff4444","color":"#fff"});
    } else {
      $(".goods-check").prop('checked', false); //else所有按钮不全选
      TotalPrice();
    }
    $(".shopCheck").change(); //执行店铺全选的操作
  });
    //计算
  function TotalPrice() {
    var allprice = 0; //总价
    $(".shop-group-item").each(function() { //循环每个店铺
      var oprice = 0; //店铺总价
      $(this).find(".goodsCheck").each(function() { //循环店铺里面的商品
        if ($(this).is(":checked")) { //如果该商品被选中
          var num = parseInt($(this).parents(".shop-info").find(".num").text()); //得到商品的数量
          var price = parseFloat($(this).parents(".shop-info").find(".price").text()); //得到商品的单价
          var total = price * num; //计算单个商品的总价
          oprice += total; //计算该店铺的总价
        }
        $(this).closest(".shop-group-item").find(".ShopTotal").text(oprice.toFixed(2)); //显示被选中商品的店铺总价
      });
      var oneprice = parseFloat($(this).find(".ShopTotal").text()); //得到每个店铺的总价
      allprice += oneprice; //计算所有店铺的总价
    });
    var am=0;
    $(document).find('.shop-info-text').each(function(){
    	var id=$(this).find('h4').attr('name');
    	var money=parseFloat($(this).find('.shop-pices b').html());
    	var amount=parseFloat($(this).find('.num').html());
    	am+=money*amount;
    });
    $('#AllTotal').html(allprice.toFixed(2));
    
    //$("#AllTotal").text(allprice.toFixed(2)); //输出全部总价
  }



  $("#showlist").on("click",function () {
        if($(this).text()=="编辑"){
            $(this).text("完成");
            $(".settlement").text("清空");
            $(".shop-total").css({'display':'none'})
            $(".deletea").animate({
              right:'0',
            },400)
            $(".shop-group-item ul li").animate({
              marginLeft:'-56',
            },400)
/*             $(".settlement").on('click',function () {
                $(" .shop-group-item ul .goodsCheck").each(function () {
                    if($(this).get(0).checked){
                        $(this).parents("li").remove();
                        

                    }
                });
                if($(" .shop-group-item ul li .goodsCheck").length==0){
                    // alert(1)
                    $(".shop-group-item").remove();
                    $(".payment-bar").remove();
                    $(".shopping").remove();
                     $(".shop-empty").show();
                }

                 $(".shop-empty").show();
            });*/
        }else if($(this).text()=="完成"){
  
            $(this).text("编辑");
            $(".settlement").text("结算");
            $(".shop-total").css({'display':'block'})
             $(".deletea").animate({
              right:'-56',
            },400)
            $(".shop-group-item ul li").animate({
              marginLeft:'0',
            },400)
        }})

     $(".deletea").on("click",function () {
        var that=$(this).parent();
        $(".del-shadow").show();
        $(".del-sure").on("click",function () {
            var am=0;

            that.find('.shop-info-text').each(function(){
            	var id=$(this).find('h4').attr('name');
            	var money=parseFloat($(this).find('.shop-pices b').html());
            	var amount=parseFloat($(this).find('.num').html());
            	var param={};
            	param['id']=id;
            	param['all']='y';
            	subDatadel(param);            	
            });
            
            that.parents("li").remove();
            $(".del-shadow").hide();
            TotalPrice();
            
/*            $(document).find('.shop-info-text').each(function(){
            	var id=$(this).find('h4').attr('name');
            	var money=parseFloat($(this).find('.shop-pices b').html());
            	var amount=parseFloat($(this).find('.num').html());
            	am+=money*amount;
            });
            $('#AllTotal').html(am);
            $(".del-shadow").hide();*/
            
        });
        $(".del-cancel").on("click",function () {
            //that.parents("li").remove();
            $(".del-shadow").hide();
        });

    })
});
