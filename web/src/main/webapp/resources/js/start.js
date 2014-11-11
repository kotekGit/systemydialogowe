$.PATH = function(path) {
	    return "http://localhost:9000/" + path;
}


$(document).ready(function() {
	$.ajax({
		  type: "POST",
		  url: $.PATH("findAll"),
		  success : function(s) {
			  console.log(s)
		  },
		  error : function(e) {
			  console.log(e)
		  }
	});
});