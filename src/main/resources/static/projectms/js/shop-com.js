$(function(){
    var d = $(".cont >span:first-child >b").text();
    var divs = $(".com-shop li >div.module");
    var price = $(".com-pices >b").text()
    var s = 0;
    var sn = 0;
   // var snum = parseInt($('.com-shop li >div.module').find(".num").text()) 
       $(".com-shop li > div.module").each(function(){
             var snum = parseInt($(this).find(".num").text()) 
             var price = parseFloat($(this).find(".com-pices >b").text())
              s += price * snum; 
              sn += snum; 
              // alert(snum)
     })
      // alert(sn) 
      $(".cont >span:nth-child(2) >b").text(s.toFixed(2));
      $(".cont >span:first-child >b").text(sn);
/*     $(".com-code").click(function(){
         var Name = $(this).parents().find("div:nth-child(2) > .com-info-text h4").text();
         //alert(Name)
         $(".shop-give").find('h4').html("恭喜您成功兑换<br/>"+Name)
               $(".shop-give").show()
               $(".shop-give >p").click(function(){
                $(".shop-give").hide()
               })
     })*/
})
