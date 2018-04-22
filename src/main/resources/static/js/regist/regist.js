
function regist(){
	var username=$.trim($('#username').val());
	var password=$.trim($('#password').val());
	var recommond=$.trim($('#recommond').val());
	flag=true;

	var param={};
	if(username==null||username==''){
		alert('用户名称不能为空');
		return ;
	}else if(!(/^1[0-9][0-9]\d{8}$/.test(username))){
		alert('手机号格式错误');	
		return ;
	}else{
		Util.queryServerData('checkUsername',{username:username},Util.checkEle);
		param['username']=username;
	}
	if(flag==false){
		return ;
	}
	if(password==null||password==''){
		alert('密码不能为空');
		return ;
	}else if(!/[A-Za-z0-9]{6}/.test(password)){
		alert('密码格式错误');
		return ;
	}else{
		param['password']=password;
	}
	if(recommond==null||recommond==''){

	}else if(!/[a-zA-Z0-9]{6}/.test(recommond)){
		alert('推荐码错误');
		return ;		

	}else{
		Util.queryServerData('checkRecom',{recommond:recommond},Util.checkEle);
		param['recommond']=recommond;		
	}

	if(flag==false){
		return ;
	}
	//alert(JSON.stringify(param))

	Util.queryServerData('regist',param,Util.regist);
	//$.mobile.go('#p2');
}


Util={
		queryServerData : function(url, param, backMethod) {
			$.ajax({
				url :  url,
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

			if(data.ms!=''&&data.ms!=null&&typeof data.ms!='undefined'||data.ms=='undefined'){

				alert(data.ms);
				flag=false;
				return ;
			}
		},regist:function(data){
			if(data.ms=="ok"){
				
		    	$('#ew').attr('src',"recommEW?rc="+$('#recode').val()+"&rd="+(new Date()));

				alert('注册成功');
				$.mobile.go('#p2');
			}else{
				alert('注册失败请核对信息');
				flag=false;
				//alert(data.ms);
			}
		}
		
}


$(function(){
	fname=$("#fname");
	fmobile=$("#fmobile");
	fsex=$("#fsex");
	fdesc=$("#fdesc");

    if($('#isreg').val()==1){
    	$('#ew').attr('src',"recommEW?rc="+$('#recode').val()+"&rd="+(new Date()));
    	$.mobile.go('#p2');
    }else{
    	if($('#recode').val()!='no'){
    		$('#recommond').textbox("setValue", $('#recode').val());
    		$('#recommond').textbox({disabled:true});
    	}
    }

	
	
});



function shorcom(){
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
			Utilc.queryServerData('checkUsername',{username:mobile},Utilc.checkEle);
			param['mobile']=mobile;
		}
		if(!flag){
			return ;
		}
		if(name!=null&&name!=''&&typeof name!='undefined'){
			param['name']=name;
		}

		if(desc!=null&&desc!=''&&typeof desc!='undefined'){
			param['desc']=desc;
		}
		param['sex']=sex;
		//alert(2);
		Utilc.queryServerData('recommn',param,Utilc.reco);
		

	
}

/*function reset(){
	fname.textbox("setValue", "");
	fmobile.textbox("setValue", "");
	fsex.switchbutton("check");
	fdesc.textbox("setValue", "");
}
*/






Utilc={
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
			if(data.ms!=''&&data.ms!=null&&typeof data.ms!='undefined'||data.ms=='undefined'){
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