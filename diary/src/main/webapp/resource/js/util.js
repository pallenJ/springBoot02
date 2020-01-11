function summerTrs(str) {
	return str
	
	.replace(/&lt;/gi, "<")
	.replace(/&gt;/gi, ">")
	.replace(/&quot;/gi, "\"")
	.replace(/&#034;/gi,"\"")
	.replace(/&#039;/gi,"\'")
	.replace(/&nbsp;/gi," ")
	.replace(/&amp;/gi, "&")
	;
}



$(function () {
	 $('.modal').on('hidden.bs.modal', function (e) {
		   var pwInput = $("input[type=password]");
		   pwInput.removeClass("is-valid");
		   pwInput.removeClass("is-invalid");
		   pwInput.val("");
		});

	
	$(".summernote-trs").each(function() {
		
		var content = summerTrs($(this).html());
		var content = summerTrs($(this).html());
		$(this).html(content);	
	}); //summernote에 html로 쓰인 내용의 변환을 되돌리기 위한것.	
	
	$(".content-div").css({"min-height":"200px","max-height":"500px","overflow":"auto"});
	
	 $(".pw-form-custom").on("change keyup paste", function() {
		 	var pw_regex = /(?=.*\d{1,20})(?=.*[~`!@#$%\^&*()-+=]{1,20})(?=.*[a-zA-Z]{2,20}).{6,20}$/;;

		    var pw_eq = $("#brd_pw").val() == $("#brd_pw_ck").val();
		    var pw_regex_check = pw_regex.test($(this).val());
		    var pw_ck = pw_eq && pw_regex_check;
		    isValid(pw_ck, $("input[type=password]"));
		    $(".invalid-feedback").text(pw_regex_check?"비밀번호가 일치하지 않습니다":"최소 6자리 이상, 영문 숫자 특수기호를 포함해주세요")
	    
		    
	});
	 
	 $(".insert-view-checkbox").change(function() {
	 	$(".insert-view").prop("type", $(this).prop("checked")?"text":"password");
	 })
	 
	 
	 $(".btn-preview").click(function() {
		 	var content = summerTrs($('#content_div').summernote("code"));
		 	$("#brd_preview").html(content);
		 	$("#brd_previewModal").modal();
	 });
	 
	 function isValid(flag,selector) {//성공 실패 상태를 위한것. toggle처리하기가 곤란해서 메소드를 만듦
        if(flag){
            selector.removeClass("is-invalid")
            selector.addClass("is-valid")
        }else{
            selector.removeClass("is-valid")
            selector.addClass("is-invalid")
        }
    }
});
