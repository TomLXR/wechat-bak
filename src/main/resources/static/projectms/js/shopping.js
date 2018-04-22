$(function(){
    $("#showlist").on("click",function () {
        if($(this).text()=="编辑"){
            $("#show").hide();
            $("#hide").show();
            $("#AllTotal").text(0.00);
            $(this).text("完成");
            $(".settlement").text("删除");
            $(".settlement").on('click',function () {
                $("#hide .goodsCheck").each(function () {
                    if($(this).get(0).checked){
                        $(this).parents("li").remove();

                    }
                });
                if($("#hide .goodsCheck").length==0){
                    $(".shop-name").remove();
                    $(".payment-bar").remove();
                    // $(".shopping").remove();
                    $(".shopping").append('<div style="background: #ccc;width: 100%;height:536px;margin-top: -134px" id="empty">\n' +
                        '                <div style="width: 100%;height: 100%;margin-top: 100px;position:relative;top: 150px;text-align: center;"><img src="images/empty.png" alt="" style="width: 100px;height: 100px;"></div>\n' +
                        '                <div style="position:relative;top: -180px;margin-left: -35%;\n' +
                        '    left: 50%">\n' +
                        '                    <a href="javaScript:void(0)" style="display: inline-block;border-radius: 20px;width:50%;height: 40px;text-align: center;line-height: 40px;border: 1px solid #111111;">\n' +
                        '                        亲,购物车空空的耶~赶紧挑好东西去的吧\n' +
                        '                    </a>\n' +
                        '                </div>\n' +
                        '            </div>');
                }
            });
        }else if($(this).text()=="完成"){
            $("#hide").hide();
            $("#show").show();
            var arrayList=[];
            $("#hide>li").each(function () {
                var obj={};
                var h4=$(this).find("h4").text();
                var h3=$(this).find(".shop-brief>span").text();
                var price=$(this).find("b.price").text();
                var count=$(this).find(".num").text();
                var img=$(this).find(".shop-info-img").find("img").attr("src");
                obj.h4=h4;
                obj.h3=h3;
                obj.price=price;
                obj.count=count;
                obj.img=img;
                arrayList.push(obj);
            });
            $("#show").html("");
            for(var i=0;i<arrayList.length;i++){
                $("#show").append('<li>\n' +
                    '                <div class="shop-info">\n' +
                    '                    <input type="checkbox" class="check goods-check goodsCheck">\n' +
                    '                    <div class="shop-info-img"><a href="#"><img src="'+arrayList[i].img+'" /></a></div>\n' +
                    '                    <div class="shop-info-text">\n' +
                    '                        <h4>'+arrayList[i].h4+'</h4>\n' +
                    '                        <div class="shop-brief"><span>'+arrayList[i].h3+'</span></div>\n' +
                    '                        <div class="shop-price">\n' +
                    '                            <span class="shop-pices">￥<b class="price">'+arrayList[i].price+'</b></span>\n' +
                    '                            <span>*</span>\n' +
                    '                            <span class="num">'+arrayList[i].count+'</span>\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                </div>\n' +
                    '            </li>');
            }
            $(this).text("编辑");
            $(".settlement").text("计算");
        }
        var arrayList=[];
        $("#show>li").each(function () {
            var obj={};
            var h4=$(this).find("h4").text();
            var h3=$(this).find(".shop-brief > span").text();
            var price=$(this).find(".price").text();
             var img=$(this).find(".shop-info-img").find("img").attr("src");
            var count=$(this).find(".num").text();
            obj.h3=h3;
            obj.h4=h4;
            obj.price=price;
            obj.count=count;
            obj.img=img;
            arrayList.push(obj);

        });

      
        $("#hide").html("");
        for(var i=0;i<arrayList.length;i++){
            $("#hide").append('<li>\n' +
                '                <div class="shop-info">\n' +
                '                    <input type="checkbox" class="check goods-check goodsCheck">\n' +
                '                    <div class="shop-info-img"><a href="#"><img src="'+arrayList[i].img+'" /></a></div>\n' +
                '                    <div class="shop-info-text">\n' +
                 '                        <h4 style="display:none">'+arrayList[i].h4+'</h4>\n' +
                '                            <div class="shop-arithmetic">\n' +
                '                                <a href="javascript:;" class="minus">-</a>\n' +
                '                                <span class="num" >'+arrayList[i].count+'</span>\n' +
                '                                <a href="javascript:;" class="plus">+</a>\n' +
                '                            </div>\n' +
                '                        <div class="shop-brief" style="width: 160px;overflow: hidden"><span>'+arrayList[i].h3+'</span></div>\n' +
                '                        <div class="shop-price">\n' +
                '                            <div class="shop-pices">￥<b class="price">'+arrayList[i].price+'</b></div>\n' +

                '                        </div>\n' +
                '                    </div>\n' +
                '<div style="    position: absolute;\n' +
                '    height: 100%;\n' +
                '    background: red;\n' +
                '    width: 56px;\n' +
                '    top: 0;\n' +
                '    right: 0;\n' +
                '    line-height: 120px;\n' +
                '    text-align: center;\n' +
                '    color: #fff;" class="deletea">删除</div>\n'+
                '                </div>\n' +
                '            </li>');
        }
    })
    // 数量减
    // $("#hide .minus").click(function() {
    //     var t = $(this).parent().find('.num');
    //     t.text(parseInt(t.text()) - 1);
    //     if (t.text() <= 1) {
    //         t.text(1);
    //     }
    //     TotalPrice();
    // });
    $("#hide").on("click",".deletea",function () {
        var that=$(this);
        $(".del-shadow").show();
        $(".del-sure").on("click",function () {
            that.parents("li").remove();
            $(".del-shadow").hide();
            var allprice = 0; //总价
            $("ul>li").each(function() { //循环每个店铺
                var oprice = 0; //店铺总价
                $(this).find(".goodsCheck").each(function() { //循环店铺里面的商品
                    if ($(this).is(":checked")) { //如果该商品被选中
                        var num = parseInt($(this).parents(".shop-info").find(".num").text()); //得到商品的数量
                        var price = parseFloat($(this).parents(".shop-info").find(".price").text()); //得到商品的单价
                        var total = price * num; //计算单个商品的总价
                        allprice += total; //计算该店铺的总价
                    }
                });
            });
            $("#AllTotal").text(allprice.toFixed(2)); //输出全部总价
            if($("#hide li").length==0){
                $(".shop-name").remove();
                $(".payment-bar").remove();
              //  $(".shopping").remove();
                $(".shopping").append('<div style="background: #ccc;width: 100%;height:536px;margin-top: -134px" id="empty">\n' +
                    '                <div style="width: 100%;height: 100%;margin-top: 100px;position:relative;top: 150px;text-align: center;"><img src="images/empty.png" alt="" style="width: 100px;height: 100px;"></div>\n' +
                    '                <div style="position:relative;top: -180px;margin-left: -35%;\n' +
                    '    left: 50%">\n' +
                    '                    <a href="javaScript:void(0)" style="display: inline-block;border-radius: 20px;width:50%;height: 40px;text-align: center;line-height: 40px;border: 1px solid #111111;">\n' +
                    '                        亲,购物车空空的耶~赶紧挑好东西去吧\n' +
                    '                    </a>\n' +
                    '                </div>\n' +
                    '            </div>');
            }
        });
        $(".del-cancel").on("click",function () {
            //that.parents("li").remove();
            $(".del-shadow").hide();
        });

    })
    $("#hide").on('click','.minus',function () {
        var t = $(this).parent().find('.num');
        t.text(parseInt(t.text()) - 1);
        if (t.text() <= 1) {
            t.text(1);
        }
        TotalPrice();
    });
    // 数量加
    $("#hide").on('click',".plus",function () {
        var t = $(this).parent().find('.num');
        t.text(parseInt(t.text()) + 1);
        if (t.text() <= 1) {
            t.text(1);
        }
        TotalPrice();
    })
    $("#hide").on("click",".goodsCheck",function () {
        var goods = $(this).find(".goodsCheck"); //获取本店铺的所有商品
        var goodsC = $(this).find(".goodsCheck:checked"); //获取本店铺所有被选中的商品
        var Shops = $(this).find(".shopCheck"); //获取本店铺的全选按钮
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
    })
    // 点击店铺按钮
    $("#hide").on("click",".shopCheck",function () {
        if ($(this).prop("checked") == true) { //如果店铺按钮被选中
            $(this).parent().find(".goods-check").prop('checked', true); //店铺内的所有商品按钮也被选中
            if ($(".shopCheck").length == $(".shopCheck:checked").length) { //如果店铺被选中的数量等于所有店铺的数量
                $("#AllCheck").prop('checked', true); //全选按钮被选中

                TotalPrice();
            } else {
                $("#AllCheck").prop('checked', false); //else全选按钮不被选中
                TotalPrice();
            }
        } else { //如果店铺按钮不被选中
            $(this).parent().find(".goods-check").prop('checked', false); //店铺内的所有商品也不被全选
            $("#AllCheck").prop('checked', false); //全选按钮也不被选中
            TotalPrice();
        }
    })
    // $(".shopCheck").click(function() {
    //     if ($(this).prop("checked") == true) { //如果店铺按钮被选中
    //         $(this).parents(".shop-group-item").find(".goods-check").prop('checked', true); //店铺内的所有商品按钮也被选中
    //         if ($(".shopCheck").length == $(".shopCheck:checked").length) { //如果店铺被选中的数量等于所有店铺的数量
    //             $("#AllCheck").prop('checked', true); //全选按钮被选中
    //             TotalPrice();
    //         } else {
    //             $("#AllCheck").prop('checked', false); //else全选按钮不被选中
    //             TotalPrice();
    //         }
    //     } else { //如果店铺按钮不被选中
    //         $(this).parents(".shop-group-item").find(".goods-check").prop('checked', false); //店铺内的所有商品也不被全选
    //         $("#AllCheck").prop('checked', false); //全选按钮也不被选中
    //         TotalPrice();
    //     }
    // });
    // 点击全选按钮
    // $("#AllCheck").click(function() {
    //     if ($(this).prop("checked") == true) { //如果全选按钮被选中
    //         $("#hide .goods-check").prop('checked', true); //所有按钮都被选中
    //         TotalPrice();
    //     } else {
    //         $("#hide .goods-check").prop('checked', false); //else所有按钮不全选
    //         TotalPrice();
    //     }
    //     if ($(this).prop("checked") == true) { //如果全选按钮被选中
    //         $("#show .goods-check").prop('checked', true); //所有按钮都被选中
    //         TotalPrice();
    //     } else {
    //         $("#show .goods-check").prop('checked', false); //else所有按钮不全选
    //         TotalPrice();
    //     }
    //     $(".shopCheck").change(); //执行店铺全选的操作
    // });
    $("#AllCheck").click(function() {
        if ($(this).prop("checked") == true) { //如果全选按钮被选中
            $("#hide .goods-check").prop('checked', true); //所有按钮都被选中
            TotalPrice();
        } else {
            $("#hide .goods-check").prop('checked', false); //else所有按钮不全选
            TotalPrice();
        }
        if ($(this).prop("checked") == true) { //如果全选按钮被选中
            $("#show .goods-check").prop('checked', true); //所有按钮都被选中
            TotalPrice();
             $(".settlement").css({"background":"#ff4444","color":"#fff"});
        } else {
            $("#show .goods-check").prop('checked', false); //else所有按钮不全选
            TotalPrice();
        }
        //$(".shopCheck").change(); //执行店铺全选的操作
    });
    //计算
    function TotalPrice() {
        var allprice = 0; //总价
        if($("#showlist").text()=="编辑"){
            $("#show>li").each(function() { //循环每个店铺
                var oprice = 0; //店铺总价
                $(this).find(".goodsCheck").each(function() { //循环店铺里面的商品
                    if ($(this).is(":checked")) { //如果该商品被选中
                        var num = parseInt($(this).parents(".shop-info").find(".num").text()); //得到商品的数量
                        var price = parseFloat($(this).parents(".shop-info").find(".price").text()); //得到商品的单价
                        var total = price * num; //计算单个商品的总价
                        allprice += total; //计算该店铺的总价
                    }
                });
            });
            $("#AllTotal").text(allprice.toFixed(2)); //输出全部总价
        }else  if($("#showlist").text()=="完成"){
            $("#hide>li").each(function() { //循环每个店铺
                var oprice = 0; //店铺总价
                $(this).find(".goodsCheck").each(function() { //循环店铺里面的商品
                    if ($(this).is(":checked")) { //如果该商品被选中
                        var num = parseInt($(this).parents(".shop-info").find(".num").text()); //得到商品的数量
                        var price = parseFloat($(this).parents(".shop-info").find(".price").text()); //得到商品的单价
                        var total = price * num; //计算单个商品的总价
                        allprice += total; //计算该店铺的总价
                    }
                });
            });
            $("#AllTotal").text(allprice.toFixed(2)); //输出全部总价
        }

    }
////////////
    $("#show").on('click','.minus',function () {
        var t = $(this).parent().find('.num');
        t.text(parseInt(t.text()) - 1);
        if (t.text() <= 1) {
            t.text(1);
        }
        TotalPrice();
    });
    // 数量加
    $("#show").on('click',".plus",function () {
        var t = $(this).parent().find('.num');
        t.text(parseInt(t.text()) + 1);
        if (t.text() <= 1) {
            t.text(1);
        }
        TotalPrice();
    })
    $("#show").on("click",".goodsCheck",function () {
        var goods = $(this).find(".goodsCheck"); //获取本店铺的所有商品
        var goodsC = $(this).find(".goodsCheck:checked"); //获取本店铺所有被选中的商品
        var Shops = $(this).find(".shopCheck"); //获取本店铺的全选按钮
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
    })
    // 点击店铺按钮
    $("#show").on("click",".shopCheck",function () {
        if ($(this).prop("checked") == true) { //如果店铺按钮被选中
            $(this).parent().find(".goods-check").prop('checked', true); //店铺内的所有商品按钮也被选中
            if ($(".shopCheck").length == $(".shopCheck:checked").length) { //如果店铺被选中的数量等于所有店铺的数量
                $("#AllCheck").prop('checked', true); //全选按钮被选中

                TotalPrice();
            } else {
                $("#AllCheck").prop('checked', false); //else全选按钮不被选中
                TotalPrice();
            }
        } else { //如果店铺按钮不被选中
            $(this).parent().find(".goods-check").prop('checked', false); //店铺内的所有商品也不被全选
            $("#AllCheck").prop('checked', false); //全选按钮也不被选中
            TotalPrice();
        }
    })
       $("#show").on("click",".goodsCheck",function () {
          var Name = $(this).parent().find(".shop-info-text h4").text(); //获取本店铺的所有商品
           // alert(Name)
           // alert(1)
       if ($(this).prop("checked") == true) { //如果店铺按钮被选中 
           $(".settlement").click(function(){
               $(".shop-give").find('h4').html("恭喜您成功兑换<br/>"+Name)
               $(".shop-give").show()
               $(".shop-give >p").click(function(){
                $(".shop-give").hide()
               })
              // setTimeout(function(){$(".shop-give").hide();},2000)
           })
       } 
    })
      
});
