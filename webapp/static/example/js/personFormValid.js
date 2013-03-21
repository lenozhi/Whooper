 $(document).ready(function(){
 
	jQuery.validator.addMethod("password", function( value, element ) {
		var result = this.optional(element) || value.length >= 6 && /\d/.test(value) && /[a-z]/i.test(value);
	
		return result;
	}, "Your password must be at least 6 characters long and contain at least one number and one character.");
	
	 jQuery.validator.addMethod("gtt", function(value, element, param) {
	     return value > param;
	    }, $.validator.format("输入值必须大于{0}!"));

	//jQuery.validator.messages.required = "";
	//jQuery.validator.messages.email="dsfsf";
	$("#personAttribute").validate({
		
		onkeyup: false,
	//	submitHandler: function(form) {
			//alert("submit! use link below to go to the other step");
			//$(form).find(":submit").attr("disabled", true);
		//	$("#personAttribute").submit();
			
		//},
		rules: {
			firstName: {
				remote: {
					url:"/BaseProject/ajax/checkLoginName",
					dataType: "json",
		                data: { enName: function() { return $("#firstName").val(); } } 
				}
			},
			d: {
				gtt:3
			}
		}
		
	
	});

	
 });

