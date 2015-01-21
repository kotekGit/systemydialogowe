/*
 * Author: Krzysztof Jedynak 2013-09-30
 * Call Boostrap datapicker
 */
jQuery( document ).ready( function ( $ )
{
    var checkout = $( '.datepicker' );
//        wrapper = $( "<div/>" ),
//        span = $( "<span/>" );
//
//    wrapper.addClass("input-append date");
//    span.addClass( "add-on" );
//    span.append( $( "<i/>" ).addClass( "icon-calendar" ) );
//    checkout.wrap( wrapper );
//    checkout.after( span );

    checkout.datepicker( {
        format: "yyyy-mm-dd",
        autoclose: true
    } ).on( 'changeDate', function ( ev )
        {
            checkout.datepicker( "hide" );
        } ).on("focus",function(){
        	checkout.not(this).datepicker( "hide" );
        });
    
} );
