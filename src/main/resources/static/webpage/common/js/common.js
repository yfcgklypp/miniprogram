/***
 * 格式化时间 yyyy-MM-dd HH:mm:ss
 */
function formatDate(date) { 
	 var now = new Date(date);
     var year = now.getFullYear(); 
     var month = now.getMonth() + 1; 
     var date = now.getDate(); 
     var hour = now.getHours(); 
     var minute = now.getMinutes(); 
     var second = now.getSeconds(); 
     if(month < 10){
    	 month = '0' + month;
     }
     if(date < 10){
    	 date = '0' + date;
     }
     if(hour < 10){
    	 hour = '0' + hour;
     }
     if(minute < 10){
    	 minute = '0' + minute ;
     }
     if(second < 10){
    	 second = '0' + second;
     }
     return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second; 
}
function formatShort(date) { 
	var now = new Date(date);
	var year = now.getFullYear(); 
	var month = now.getMonth()+1; 
	var date = now.getDate(); 
	if(month < 10){
		month = '0' + month;
	}
	if(date < 10){
		date = '0' + date;
	}
	return year+"-"+month+"-"+date; 
}

function formatShortChain(date) { 
	var now = new Date(date);
	var year = now.getFullYear(); 
	var month = now.getMonth()+1; 
	var date = now.getDate(); 
	if(month < 10){
		month = '0' + month;
	}
	if(date < 10){
		date = '0' + date;
	}
	return year+"年"+month+"月"+date+"日"; 
}

function formatMonth(date) { 
	var now = new Date(date);
	var year = now.getFullYear(); 
	var month = now.getMonth()+1; 
	if(month < 10){
		month = '0' + month;
	}
	return year+"-"+month; 
}

function formatMonthChain(date) { 
	var now = new Date(date);
	var year = now.getFullYear(); 
	var month = now.getMonth()+1; 
	if(month < 10){
		month = '0' + month;
	}
	return year+"年"+month+"月"; 
}

function viewButton(permissionsJson){
	var buttonsHtml="";
	for (var i=0;i<permissionsJson.length;i++){
		var button=permissionsJson[i];
		if(button.type==2){
			buttonsHtml+=button.buttonHtml;
		}
	}
	return buttonsHtml;
}

/**
 * 校验是否是正整数
 */
function isNotPositiveInt(number){
	if(number == null || number == ""){
		return false;
	}
	var region = /^[1-9]*[1-9][0-9]*$/g;
	if(!isNaN(number) && region.test(number)){
		return false;
	}
	return true;
}

/**
 * 校验是否是非负数
 */
function isNotNonNegative(number){
	if(number == null || number == ""){
		return false;
	}
	//var region = /^\d+(\.{0,1}\d+){0,1}$/g;
	if(!isNaN(number) && number >= 0){
		return false;
	}
	return true;
}

/**
 * 校验是否含有特殊字符
 */
function hasSpecialChar(str){
	var region = /[<>@￥%^&$#]+/g;
	if(region.test(str)){
		return true;
	}
	return false;
}

/**
 * 字符串长度是否超过指定长度
 */
function strLenMoreParam(str, lenParam){
	var len = str.length;
	if(len > lenParam){
		return true;
	}
	return false;
}

/**
 * 字符串长度是否超过20
 */
function strLenMore20(str){
	var len = str.length;
	if(len > 20){
		return true;
	}
	return false;
}

/**
 * 校验是否是大写字符
 */
function isNotBigChar(str){
	var region = /^[A-Z]+$/g;
	if(region.test(str)){
		return false;
	}
	return true;
}

/**
 * 手机号格式和长度校验
 */
function isNotPhone(phone){
	var region = /^[1-9]*[1-9][0-9]*$/g;
	var len = phone.length;
	if(region.test(phone) && len == 11){
		return false;
	}
	return true;
}

/**
 * 
 * @param code
 * @returns
 */
function fourNumber(code){
	var region = /^[0-9]{4}$/g;
	if(region.test(code)){
		return true;
	}
	return false;
}