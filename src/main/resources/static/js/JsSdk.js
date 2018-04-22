var Sdk_appId = document.getElementById('JsSdk').getAttribute('appId');
var Sdk_timestamp = document.getElementById('JsSdk').getAttribute('timestamp');
var Sdk_noncestr = document.getElementById('JsSdk').getAttribute('noncestr');
var Sdk_signature = document.getElementById('JsSdk').getAttribute('signature');
var Sdk_openId = document.getElementById('JsSdk').getAttribute('openId');
var Sdk_FromOrganId = document.getElementById('JsSdk').getAttribute('FromOrganId');

if (Sdk_openId==""){Sdk_openId="0"};
if (Sdk_FromOrganId==""){Sdk_FromOrganId=0};
//alert(Sdk_appId);
//alert(Sdk_timestamp);
//alert(Sdk_noncestr);
//alert(Sdk_signature);
//alert(Sdk_openId);


wx.config({
	debug: false,
	appId: Sdk_appId,
	timestamp: Sdk_timestamp,
	nonceStr: Sdk_noncestr,
	signature: Sdk_signature,
	jsApiList: [
	'onMenuShareTimeline',
    'onMenuShareAppMessage',				
	'chooseImage',
	'uploadImage',
	'hideMenuItems',
	'closeWindow'
	]
});

wx.ready(function(){   // config信息验证后会执行ready方法
	//alert("ok");	

	wx.hideMenuItems({   //隐藏部分按钮
		menuList: [ "menuItem:share:weiboApp","menuItem:share:qq","menuItem:share:QZone","menuItem:readMode","menuItem:share:brand","menuItem:copyUrl","menuItem:openWithQQBrowser","menuItem:openWithSafari" ] // 要隐藏的菜单项，只能隐藏“传播类”和“保护类”按钮，所有menu项见附录3
	});

	wx.onMenuShareTimeline({
		title: '蕾特恩·祛痘，领100元新人奖励，还有特惠项目！', // 分享标题
		link: 'http://webapp.szreturn.com/Index.asp?FromOpenId='+Sdk_openId+'&FromOrganId='+Sdk_FromOrganId, // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
		imgUrl: 'http://webapp.szreturn.com/Images/logo300X300.jpg', // 分享图标
		success: function () { 
			// 用户确认分享后执行的回调函数
			//$.toast("分享成功");
		},
		cancel: function () { 
			// 用户取消分享后执行的回调函数
			//$.toast("分享取消");
		}
	});




	wx.onMenuShareAppMessage({
		title: '蕾特恩·祛痘，领100元新人奖励，还有特惠项目！', // 分享标题
		desc: '推荐蕾特恩祛痘，免费领取100元奖励，还有更多优惠券、免费体验券！', // 分享描述
		link: 'http://webapp.szreturn.com/Index.asp?FromOpenId='+Sdk_openId+'&FromOrganId='+Sdk_FromOrganId, // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
		imgUrl: 'http://webapp.szreturn.com/Images/logo300X300.jpg', // 分享图标
		type: '', // 分享类型,music、video或link，不填默认为link
		dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
		success: function () { 
			// 用户确认分享后执行的回调函数
			//$.toast("分享成功");
		},
		cancel: function () { 
			// 用户取消分享后执行的回调函数
			//$.toast("分享取消");
		}
	});






});

wx.error(function(res){  // config信息验证失败会执行error函数
	//alert("error");
});














