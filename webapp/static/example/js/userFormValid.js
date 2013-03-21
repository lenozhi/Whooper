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
	$("#loginForm").validate({
		
		onkeyup: false,
	//	submitHandler: function(form) {
		//	alert("submit! use link below to go to the other step");
			//$(form).find(":submit").attr("disabled", true);
	//		$(form).ajaxSubmit();
			//form.submit();
	//	},
		rules: {
			username: {
				remote: {
					url:"/BaseProject/ajax/checkLoginName",
					dataType: "json",
		                data: { enName: function() { return encodeURIComponent($("#username").val()); } } 
				}
			},
			d: {
				gtt:3
			}
		},
		
		messages: {
	
			password2: {
				required: " ",
				equalTo: "Please enter the same password as above"	
			},
			mail: {
				required: " ",
				email: "Please enter a valid email address, example: you@yourdomain.com",
				remote: jQuery.validator.format("{0} is already taken, please enter a different address.")	
			}
		},
		debug:true,
		errorContainer: "#messageBox",
		errorPlacement: function(error, element) {
			//if ( element.is(":checkbox") )
				//error.appendTo ( element.parent().next() );
				error.insertAfter( element );
		}
	});

	 $("#code").mask("(999) 999-9999");
 });

