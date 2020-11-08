/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$.validator.addMethod(
    "regex",
    function(value, element, regexp) {
        var re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    },
    "Please check your input format."
);
var private_text_json = 
        '{"Validate":{'+
            '"id":"^[A-Za-z0-9]*[-]{0,1}[^\']*$",'+
            '"enum":"^[A-Z0-9]{2}[^\']*$",'+
            '"booking_id":"^[B]{1}[0-9]{16}$",'+
            '"rating_id":"^[R]{1}[0-9]{8}$",'+
            '"password":"^[0-9A-Za-z_]",'+
            '"cartype_id":"^CTI[0-9]{5}$",'+
            '"cust_id":"^[A-Z]{2}[0-9]{9}[^\']*$",'+
            '"driver_id":"^[D]{1}[0-9]{7}[^\']*$",'+
            '"phone_num":"^[0-9]{4}[-]{1}[0-9]{3}[-]{1}[0-9]{4}$",'+
            '"ic_num":"^[0-9]{6}[-]{1}[0-9]{2}[-]{1}[0-9]{4}$",'+
            '"card_num":"^([0-9]{4}[-]{1}[0-9]{4}[-]{1}[0-9]{4}[-]{1}[0-9]{4}|[0-9]{10})$",'+
            '"license":"^[0-9]{8}$",'+
            '"name":"^[A-Za-z ]+$",'+
            '"cvv":"^[0-9]{3}$",'+
            '"expiry_date":"^[0-9]{2}[/]{1}[0-9]{2}$"'+
        '}}';
var regex_list = JSON.parse(private_text_json);
function cut_dash(text){
    return text.split("-")[0];
}