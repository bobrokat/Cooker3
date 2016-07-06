/**
 * Created by Ekaterina on 05.05.2016.
 */
 f = function( select){
    jQuery.ajax(
        {
            url:"/cookadmin/toajax",
            data: {"select" : jQuery("#select").val()},
            headers: {
                Accept: 'application/json'
            },
            dataType: "json",
            success: function(response_data){
                if (response_data !== undefined) {
                    jQuery("#res").html("");
                    for (var i = 0; i < response_data.length; i ++) {
                        jQuery("#res").append( "<li>" +
                            "<h4><span class=\"text\">" + response_data[i].id + "</span><span class=\"line\"></span></h4>" +
                            "<div class=\"price\">" +
                            "<h5><a >" + response_data[i].user.login +"</a></h5>" +
                            "<span>"+ response_data[i].date + "</span>" +
                            "</div>" +
                            "<div class=\"description\">"
                            // + "<b>Заказ:</b>"
                            );
                        //for(var j = 0; j < response_data[i].productinorderList; j++){
                        //    jQuery("#res").append( response_data[i].productinorderList[j].product.name +"<br>");
                        //
                        //}
                            jQuery("#res").append("<br>" +
                            "<b>Сумма :</b>" + response_data[i].price +
                            "<br>" +
                            "<b>Адрес: </b>" + response_data[i].address +
                            "<br>" +
                            "<b> Телефон: </b>" + response_data[i].user.phone +
                            "<br>"+
                            "<b>Примечание: </b>");
                        if(response_data[i].note != false){
                            jQuery("#res").append(response_data[i].note +  "</div>");

                        }
                        if(response_data[i].status == false){
                            jQuery("#res").append("<div class=\"status\">" +
                                "<form action='/cookadmin' method='post'>" +
                                "Заказ готов: <input type='checkbox' name='checkbox' value='true'>" +
                                "<button type='submit'  name='orderId' value='" + response_data[i].id  + "' class='add-to-cart-button'>ok</button>"
                                + "</form>" +
                                    "<form action='/pdf' method='post'>" +
                            "<button type='submit' name='orderidid'  value='"+ response_data[i].id  +"' class='add-to-cart-button'>Бланк Заказа</button>"+
                            "</form>"+
                                "</div>"

                            )

                        }

                        jQuery("#res").append("</li>");


                    }
                }
                else {
                    jQuery("#res").append("No!")
                }
            }

        });
};
f();
change = function (param) {
    jQuery("#select").val(param);
    f();
};