var email_pattern = '^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$';
var password_pattern = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})$";
var name_pattern = '^[A-Za-z-]{2,20}$';
var phone_pattern = "^\\d{3}-\\d{7}$";

$(document).ready(function () {
    var form = $("#autorization_form");
    form.fadeTo(0.1, 0);
    form.fadeTo(700, 1);
});
function checkInfo(phone){
    var ownInfoEditBox = $("#ownInfoEditBox");
    var submitInfo = $("#submitInfo");
    ownInfoEditBox.addClass("ownInfoHidden");
    submitInfo.addClass("ownInfoHidden");
    ownInfoEditBox.removeClass("ownInfoVisible");
    submitInfo.removeClass("ownInfoVisible");
//    alert(phone);
    $('#userInfo').text(phone);
}

function editUserInfo(info){
//    var idInfo  = "#idinfo" + id;
    var ownInfoEditBox = $("#ownInfoEditBox");
    var submitInfo = $("#submitInfo");
    ownInfoEditBox.removeClass('ownInfoHidden');
    submitInfo.removeClass('ownInfoHidden');
    ownInfoEditBox.addClass('ownInfoVisible');
    submitInfo.addClass('ownInfoVisible');
    $('#userInfo').text(info);
}

function submitInfo (id) {
    var inputInfo = $("#ownInfoEditBox").val();
    var path = '/info?id=' + id + '&action=edit&value=' + inputInfo;
//    alert(path)
    $.get(path, function(responseText){
        $('#userInfo').text(responseText);
    });
}

function registr() {
    document.location.href = "/pages/login/registration.jsp"
}

function cancelRegPage(){
    document.location.href = "/pages/login/login.jsp"
}

var validateEmail = false;
var validatePassword = false;
var validateName = false;
var validateSurname = false;
var validatePhone = false;
function emailValidate () {
    var input = $("#add_email_id").val();
    var info = $("#required_email_pattern_info")
    if(input.length == 0){
        info.text("")
    }
    if(input.match(email_pattern) ){
        info.text("")
        validateEmail = true;
    }
    else{
        info.text("Email is incorrect");
        validateEmail = false;
    }

}

function passwordValidate(){
    var input = $("#add_password_id").val();
    var info = $("#required_password_pattern_info")

    if(input.match(password_pattern) ){
        validatePassword = true;
        info.text("")
    }
    else{
        info.text("Pasword should contain numbers and uppercase, lowercase symbols. It should be within [6,20]");
        validatePassword = false;
    }
    if(input.length == 0){
        info.text("")
    }
}

function nameValidate(name){
    var input;
    var info;

    if(name == "name"){
        input = $("#add_name_id").val();
        info = $("#required_name_pattern_info");
    }
    else{
        input = $("#add_surname_id").val();
        info = $("#required_surname_pattern_info");
    }
    if(input.length == 0){
        info.text("")
    }
    if(input.match(name_pattern)){
        if(name == "name"){
            validateName = true;
        }
        else{
            validateSurname = true;
        }
        info.text("")
    }
    else {
        info.text("Name shoudn't contain characters such as: . _ <>\" @, and etc.");
        if(name == "name")
            validateName = false;
        else{
            validateSurname = false;
        }
   }
}

function phoneValidate(){
    var input = $("#add_phone_id").val();
    var info = $("#required_phone_pattern_info")

    if(input.match(phone_pattern) ){
        validatePhone = true;
        info.text("")
    }
    else{
        info.text("Phone should be like this XXX-YYYYYYY");
        validatePhone = false;
    }
    if(input.length == 0){
        info.text("")
    }
}

function validate(formID){
    if(validateEmail &&
        validatePassword &&
        validateName &&
        validateSurname &&
        validatePhone){
        var postForm = $(formID)
        postForm.submit();
    }
}

