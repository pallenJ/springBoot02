$(function() {
	var hostFlag = true;
	var filter = "win16|win32|win64|mac";
		if (0 > filter.indexOf(navigator.platform.toLowerCase())) {
        hostFlag = false; //모바일
      } else {
        hostFlag = true; //웹
      }
	
	function loadDataHereDom() {
		
		console.log("data here loaded!!!");
		console.log("path:"+location.pathname);
		console.log("href:"+location.href);
		console.log("platform:"+navigator.platform);
		console.log("appName:"+navigator.appName);
		console.log("appVer:"+navigator.appVersion);
		console.log("appAgent:"+navigator.userAgent);
		console.log("app Vender:"+navigator.vendor);
		console.log("web:"+hostFlag)
	}

	window.onload = function() {
		loadDataHereDom();
	}

	$("a").click(function() {
		console.log("a tag click")
	})

	$("button").click(function() {
		console.log("btn tag click")
	})
	$("input[type='button']").click(function() {
		console.log("btn tag click")
	})

})