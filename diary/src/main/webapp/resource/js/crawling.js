$(function() {
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