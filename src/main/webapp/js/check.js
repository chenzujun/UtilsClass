//只允许输入数字和小数点
function checkKeyForFloat(value, e) {
	var isOK = false;
	var key = window.event ? e.keyCode : e.which;
	
	if ((key > 95 && key < 106) || // 小键盘上的0到9
			(key > 47 && key < 60) || // 大键盘上的0到9
			(key == 110 && value.indexOf(".") < 0) || // 小键盘上的.而且以前没有输入.
			(key == 190 && value.indexOf(".") < 0) || // 大键盘上的.而且以前没有输入.
			key == 8 || key == 9 || key == 46 || key == 37 || key == 39 // 不影响正常编辑键的使用(8:BackSpace;9:Tab;46:Delete;37:Left;39:Right)
	) {
		isOK = true;
	} else {
		if (window.event) // IE
		{
			e.returnValue = false; // event.returnValue=false 效果相同.
		} else // Firefox
		{
			e.preventDefault();
		}
	}
	return isOK;
}

// JS数组去重
function removesame(arr){
	var uq = {};// 唯一标记
	var rq = [];// 去重后数组
	var prefix = '';
	for ( var i = 0; i < 8; i++) {
		if (typeof arr[i] == 'string') {
			prefix = '_str';
		} else {
			prefix = '';
		}
		if (!uq[ddd[i] + prefix]) {
			uq[ddd[i] + prefix] = true;
			rq.push(ddd[i]);
		}
	}

	return rq;
}