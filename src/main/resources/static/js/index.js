

function newPage(){
	if(isMoreEnable==true){
		if(window.location.href.indexOf('more')!=-1){
			window.location.href=window.location.href;
		}else{
			window.location.href=window.location.href+'more';
		}
		
		
	}

}

