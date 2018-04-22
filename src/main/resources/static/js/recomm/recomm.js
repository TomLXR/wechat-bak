

$(function(){
	fname=$("#fname");
	fmobile=$("#fmobile");
	fsex=$("#fsex");
	fdesc=$("#fdesc");
	freco=$('#freco');
	
	freco.on('click',function(){
		flag=true;
		var name=$.trim(fname.val());
		var mobile=$.trim(fmobile.val());
		var desc=$.trim(fdesc.val());
		var sex='1';
		if($('span.switchbutton-inner').css('margin-left')=='0px'){
			sex='1'
		}else{
			sex='0'
		}
		
		var param={};
		if(mobile==null||mobile==''){
			alert('手机号码不能为空');
			return ;
		}else if(!(/^1[0-9][0-9]\d{8}$/.test(mobile))){
			alert('手机号格式错误');	
			return ;
		}else{
			Util.queryServerData('checkUsername',{username:mobile},Util.checkEle);
			param['mobile']=mobile;
		}
		if(!flag){
			return ;
		}
		if(name!=null&&name!=''&&typeof name!='undefined'||name=='undefined'){
			param['name']=name;
		}

		if(desc!=null&&desc!=''&&typeof desc!='undefined'||desc=='undefined'){
			param['desc']=desc;
		}
		param['sex']=sex;
		//alert(JSON.stringify(param));
		Util.queryServerData('recommn',param,Util.reco);
		
		
	});
	
	
});
function reset(){
	fname.textbox("setValue", "");
	fmobile.textbox("setValue", "");
	fsex.switchbutton("check");
	fdesc.textbox("setValue", "");
}







Util={
		queryServerData : function(url, param, backMethod) {
			$.ajax({
				url :  basepath+'/'+url,
				datatype : 'json',
				async:false,
				data : param,
				type : 'POST',
				error : function(result) {
					console.log("no no no no no no buxingle");
				},
				success : function(data) {
					backMethod.call(Util,data);
				}

			});

		},
		checkEle:function(data){
			if(data.ms!=''&&data.ms!=null&&typeof data.ms!='undefined'&&data.ms!='undefined'){
				alert("只能推荐新用户");
				flag=false;
				return ;
			}
		},reco:function(data){
			if(data.ms=="ok"){
				$.mobile.go('#p2');
				alert('推荐成功已发送短信');

			}else{
				alert('推荐失败请核对信息');
				flag=false;
			}
		}
		
}