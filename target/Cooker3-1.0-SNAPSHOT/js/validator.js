/**
 * Created by Ekaterina on 07.05.2016.
 */

//password
$(document).ready(function() {
    $('#repassword').blur(function() {
        var p1 = $("#password").val();
        var p2 = $("#repassword").val();
        if(p2 != '') {
            if (p1 == p2) {
                $(this).css({'background' : '#d8c7aa'});
                $('#info').text('');

            } else {
                $(this).css({'background' : 'red'});
                $('#info').text("Пароли не совпадают");
            }
        } else {
            $(this).css({'background' : 'red'});
            $('#info').text("Повторите пароль");
        }
    });
});
//login
function responseLogin(){
    jQuery.ajax({
        type: 'post',
        url: "/index/checklogin",
        data: { "loginreg" : jQuery("#loginreg").val() },
        dataType: "text",
        success: function(response_data){
            console.log(response_data);
            if(response_data == 'on'){
                jQuery("#infologin").text("Имя занято").css("color","red");
                jQuery("#loginreg").css({'background' : 'red'});
            }else{
                jQuery("#infologin").text("Имя свободно").css("color","green");
                jQuery("#loginreg").css({'background' : '#d8c7aa'});
            }
        },

            error: function( xhr, status ) {
        alert( 'error' );
    }

});
}
//phone
function responsePhone(){
    jQuery.ajax({
        type: 'post',
        url: "/index/checkphone",
        data: { "phone" : jQuery("#phone").val() },

        dataType: "text",
        success: function(response_data){
            console.log(response_data);
            if(response_data == 'on'){
                jQuery("#infophone").text("Номер занят").css("color","red");
                jQuery("#phone").css({'background' : 'red'});
            }else{
                jQuery("#infophone").text("Номер свободен").css("color","green");
                jQuery("#phone").css({'background' : '#d8c7aa'});
            }
        },

        error: function( xhr, status ) {
            alert( 'error' );
        }

    });
}

//addingproduct
function responsenewProd(){
    jQuery.ajax({
        type: 'post',
        url: "/contentadmin/addtoDB/check",
        data: { "prodname" : jQuery("#prodname").val() },

        dataType: "text",
        success: function(response_data){
            console.log(response_data);
            if(response_data == 'on'){
                jQuery("#infoprodname").text("Такой товар уже есть").css("color","red");
                jQuery("#prodname").css({'background' : 'red'});
            }else{
                jQuery("#infoprodname").text("");
                jQuery("#prodname").css({'background' : '#d8c7aa'});
            }
        },

        error: function( xhr, status ) {
            alert( 'error' );
        }

    });
}

//removeproduct
function responseremoveProd(){
    jQuery.ajax({
        type: 'post',
        url: "/contentadmin/removeProduct/check",
        data: { "prodremove" : jQuery("#prodremove").val() },

        dataType: "text",
        success: function(response_data){
            console.log(response_data);
            if(response_data == 'off'){
                jQuery("#infoprodremove").text("Такого товара не существует").css("color","red");
                jQuery("#prodremove").css({'background' : 'red'});
            }else{
                jQuery("#infoprodremove").text("");
                jQuery("#prodremove").css({'background' : '#d8c7aa'});
            }
        },

        error: function( xhr, status ) {
            alert( 'error' );
        }

    });
}

//slider
function responseSlider(){
    jQuery.ajax({
        type: 'post',
        url: "/contentadmin/addtoSlider/check",
        data: { "prod1" : jQuery("#prod1").val(), "prod2" : jQuery("#prod2").val(), "prod3" : jQuery("#prod3").val()},

        dataType: "text",
        success: function(response_data){
            console.log(response_data);
            if(response_data == 'prod1'){
                jQuery("#infoprod1").text("Такого товара не существует").css("color","red");
                jQuery("#prod1").css({'background' : 'red'});
            }
             else if(response_data == 'prod2'){
                jQuery("#infoprod2").text("Такого товара не существует").css("color","red");
                jQuery("#prod2").css({'background' : 'red'});
            }
             else if(response_data == 'prod3'){
                jQuery("#infoprod3").text("Такого товара не существует").css("color","red");
                jQuery("#prod3").css({'background' : 'red'});
            }else{
                jQuery("#infoprod1").text("");
                jQuery("#infoprod2").text("");
                jQuery("#infoprod3").text("");
                jQuery("#prod1").css({'background' : '#d8c7aa'});
                jQuery("#prod2").css({'background' : '#d8c7aa'});
                jQuery("#prod3").css({'background' : '#d8c7aa'});

            }
        },

        error: function( xhr, status ) {
            alert( 'error' );
        }

    });
}