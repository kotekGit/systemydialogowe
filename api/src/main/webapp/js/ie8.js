
	jQuery( document ).ready( function ( $ )
	{
		$("select.resizableIE8")
				.each(function() {
					$(this).css("width", "auto");
				});
		
		//fix for this bug: https://jira-ptim-new.asseco.pl/browse/EPLUS-633
        $(".btn-group-vertical").each(function() {
            var element = $( this ),
            childrens = element.children();
            childrens.each(function(){
    			$( this ).removeClass("btn");
    		});
            
        	if(childrens.length == 1) {
        		
        		element.removeClass( "btn-group-vertical" );
        	}
        });
	});
	
