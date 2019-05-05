//判断用户是否绑定邮箱
function checkEmailBound() {
    doAjax("_action=CheckEmailBound", "html", function (data) {
        if (data == 0) {
            alert("您尚未绑定邮箱，无需进行解绑操作");
        }
        else if (data == 2) {
            alert("邮箱为您当前登陆大麦网的唯一凭证，请您先绑定并验证手机，再解绑邮箱");
        }
        else {
            location.href = "https://my.damai.cn/account/unbindemail";
        }
    });
}

//判断用户是否绑定电话
function checkPhoneBound() {
    doAjax("_action=CheckPhoneBound", "html", function (data) {
        if (data == 0) {
            alert("您尚未绑定手机，无需进行解绑操作");
        }
        else if (data == 2) {
            alert("手机为您当前登陆大麦网的唯一凭证，请您先绑定并验证邮箱，再解绑手机");
        }
        else {
            location.href = "https://my.damai.cn/account/unbindphone";
        }
    });
}

function doAjax(urlParameters, retrievalDataType, callFunction) {
    jQuery.ajax({
        type: "post",
        url: "accountsafe.aspx",
        data: urlParameters,
        dataType: retrievalDataType,
        cache: false,
        success: callFunction,
        error: function () { tipsFB("系统忙，请稍候再试"); }
    });
}


var getVerifyCode = false;
var remainSecond = 120;
var interValObj;
var isWait = false;
var emailRegExp = /^[0-9a-zA-Z_][_0-9a-zA-Z-\.]*@([0-9a-zA-Z][0-9a-zA-Z-]*\.){1,4}([a-zA-Z]{2,4})$/;
var mobileRegExp = /^1\d{10}$/;


function checkMobileInput() {
    var input = $("#mobile").val();
    var reg = mobileRegExp;
    checkInput(input,reg);
}


function checkNicknameAndEmailInput() {
    var nickname = $("#nickname").val();
    var email = $("#email").val();

    var check1 = nickname == null || nickname == undefined || nickname == "";
    var check2 = email == null || email == undefined || email == "";

    var input = email;
    if (check1 || check2) {
        input=null;
    }
    var reg = emailRegExp;
    checkInput(input,reg);
}

function checkInput(input,reg) {
    if (input != null && input != undefined && input != ""&&reg.test(input)) {
        $("#vcodeCheckBtn").attr("disabled", false);
        $("#vcodeCheckBtn").attr("class", "oth-btn pd_send_code ce");

        return;
    }

    $("#vcodeCheckBtn").attr("disabled", true);
    $("#vcodeCheckBtn").attr("class", "oth-btn oe");
}

function emailGuideCheck() {

    $("#nickname_tip").attr("style", "display:none");
    $("#email_tip").attr("style", "display:none");
    $("#emailcheck_tip").empty();
    $("#nickname_tip").empty();


    var nickname = $("#nickname").val();
    var email = $("#email").val();

    if (nickname == null || nickname == undefined || nickname == "") {
        $("#nickname_tip").append("请填写昵称");
        $("#nickname_tip").attr("style", "display:show");
        return;
    }

    if (nickname.length > 30) {
        $("#nickname_tip").append("昵称不能超过30个字符");
        $("#nickname_tip").attr("style", "display:show");
        return;
    }

    //var reg = /^[0-9a-zA-Z_][_0-9a-zA-Z-\.]*@([0-9a-zA-Z][0-9a-zA-Z-]*\.){1,4}([a-zA-Z]{2,4})$/;
    if (email == null || email == "" || email == undefined || !emailRegExp.test(email)) {
        $("#email_tip").attr("style", "display:show");
        return;
    }

    $("#emailcheck_tip").empty();
    $("#vcodeCheckBtn").attr("class", "oth-btn pd_send_code ce");

    jQuery.ajax({
        type: "post",
        url: "accountsafe.aspx?_action=CheckEmail",
        dataType: "text",
        data:{email:email,nickname:nickname},
        cache: false,
        success: function (data) {
            var obj = $.parseJSON(data);
            var code = obj.code;
            var rtData = obj.data;
            var msg = obj.msg;

            $("#emailcheck_tip").empty();
            $("#emailcheck_tip").append(msg);
            if (code==200||code==300) {
                $("#waitBtn").attr("style", "display:show");
                $("#vcodeCheckBtn").attr("style", "display:none");
                getVerifyCode = true;
                remainSecond = rtData;
                interValObj = window.setInterval(SetRemainTime, 1000);
                return;
            }
        },
        error: function () { alert("服务错误，请联系大麦客服");}
    });
    

}

function emailBind() {

    $("#nickname_tip").attr("style", "display:none");
    $("#email_tip").attr("style", "display:none");
    $("#emailcheck_tip").empty();
    $("#nickname_tip").empty();

    var nickname = $("#nickname").val();
    var email = $("#email").val();
    var verifyCode = $("#verifyCode").val();


    if (nickname == null || nickname == undefined || nickname == "") {
        $("#nickname_tip").append("请填写昵称");
        $("#nickname_tip").attr("style", "display:show");
        return;
    }

    if (nickname.length > 30) {
        $("#nickname_tip").append("昵称不能超过30个字符");
        $("#nickname_tip").attr("style", "display:show");
        return;
    }


    //var reg = /^[0-9a-zA-Z_][_0-9a-zA-Z-\.]*@([0-9a-zA-Z][0-9a-zA-Z-]*\.){1,4}([a-zA-Z]{2,4})$/;
    if (email == null || email == "" || email == undefined || !emailRegExp.test(email)) {
        $("#email_tip").attr("style", "display:show");
        return;
    }

    if (!getVerifyCode) {
        $("#emailcheck_tip").append("请先获取验证码");
        return;
    }

    if (verifyCode == null || verifyCode == undefined || verifyCode == "") {
        $("#emailcheck_tip").append("请填写邮箱验证码");
        return;
    }

    jQuery.ajax({
        type: "post",
        url: "accountsafe.aspx?_action=BindEmail4ThirdParty",
        dataType: "text",
        data: { email: email, nickname: nickname, verifyCode: verifyCode },
        cache: false,
        success: function (data) {
            var obj = $.parseJSON(data);

            $("#emailcheck_tip").empty();
            
            if (obj.code == 200) {
                $("#waitBtn").attr("style", "display:none");
                $("#vcodeCheckBtn").attr("style", "display:none");
                window.location = "/account/accountSafe";
                return;
            }

            if (obj.code == 300) {
                $("#emailcheck_tip").append(obj.msg);
                return;
            }

            $("#emailcheck_tip").append(obj.msg);
        },
        error: function () { alert("服务错误，请联系大麦客服"); }
    });


}

function sendMobileVerifyCode() {

    var mobile = $("#mobile").val();
    $("#mobilecheck_tip").empty();
    $("#vcode_tip").empty();


    //var re = /^1\d{10}$/;
    if (mobile == null || mobile == undefined || mobile == "" || (!mobileRegExp.test(mobile))) {
        $("#mobilecheck_tip").append("请填写正确的手机号");
        $("#mobilecheck_tip").attr("style", "display:show");
        return;
    }

    jQuery.ajax({
        type: "post",
        url: "accountsafe.aspx?_action=CheckMobile",
        dataType: "text",
        data: { mobile: mobile },
        cache: false,
        success: function (data) {
            var obj = $.parseJSON(data);
            var msg = obj.msg;
            var code = obj.code;
            var rtData = obj.data;
            $("#vcode_tip").empty();

            if (code == 100) {
                $("#mobilecheck_tip").append(obj.msg);
                return;
            }

            if (code == 200||code==300) {
                $("#waitBtn").attr("style", "display:show");
                $("#vcodeCheckBtn").attr("style", "display:none");
                //if (code == 200) {
                    //$("#vcode_tip").append(obj.msg);
                //}
                getVerifyCode = true;
                isWait = true;
                remainSecond = rtData;
                interValObj = window.setInterval(SetRemainTime, 1000);                
                return;
            }            

            $("#vcode_tip").append(obj.msg);
            
        },
        error: function () { alert("服务错误，请联系大麦客服"); }
    });
}

function bindMobile() {

    $("#mobilecheck_tip").empty();
    $("#vcode_tip").empty();

    var mobile = $("#mobile").val();
    var vcode = $("#vcode").val();
    var password = $("#password").val();

    $("#mobilecheck_tip").empty();
    $("#password_tip").empty();

    //var re = /^1\d{10}$/;
    if (mobile == null || mobile == undefined || mobile == "" || (!mobileRegExp.test(mobile))) {
        $("#mobilecheck_tip").append("请填写正确的手机号");
        $("#mobilecheck_tip").attr("style", "display:show");
        return;
    }

    if (!getVerifyCode) {
        $("#vcode_tip").append("请先获取验证码");
        return;
    }


    if (vcode == null || vcode == undefined || vcode == "") {
        $("#vcode_tip").append("请填写验证码");
        $("#vcode_tip").attr("style", "display:show");
        return;
    }

    if (password == null || password == undefined || password == ""||
        password.length < 6 || password.length > 16) {
        $("#password_tip").append("请填写6-16位密码，区分大小写");
        $("#password_tip").attr("style", "display:show");
        return;
    }


    jQuery.ajax({
        type: "post",
        url: "accountsafe.aspx?_action=BindMobile4ThirdParty",
        dataType: "text",
        data: { mobile:mobile,verifyCode:vcode,password:password},
        cache: false,
        success: function (data) {

            $("#vcode_tip").empty();
            $("#mobilecheck_tip").empty();

            var obj = $.parseJSON(data);
            if (obj.code == 200) {
                //$("#waitBtn").attr("style", "display:show");
                //$("#vcodeCheckBtn").attr("style", "display:none");
                //alert(obj.msg);
                getVerifyCode = false;
                window.location = "/account/accountSafe.aspx?_action=EmailGuide";
            }

            if (obj.code == 300) {
                $("#vcode_tip").append(obj.msg);
                return;
            }

            $("#mobilecheck_tip").append(obj.msg);

        },
        error: function () { alert("服务错误，请联系大麦客服"); }
    });
}

function emptyPasswordLable() {
    $("#password_label").empty();
}

function fillPasswordLabel() {
    $("#password_label").empty();

    var password = $("#password").val();
    if (password == null || password == "" || password == undefined) {
        $("#password_label").append("6-16位，区分大小写");
    }

}


function SetRemainTime() {
    if (remainSecond == 1) {
        window.clearInterval(interValObj);
        $("#waitBtn").attr("style", "display:none");
        $("#vcodeCheckBtn").attr("style", "display:show");
        $("#vcode_tip").empty();
        $("#waitBtn").empty();

        remainSecond = 120;
        return;
    }

    remainSecond = remainSecond - 1;
    $("#waitBtn").empty();
    $("#waitBtn").append(remainSecond + ' 秒');

}

function skipEmailBind() {
    var nickname = $("#nickname").val();
    var email = $("#email").val();
    var gotoPage = "/account/accountSafe.aspx?_action=loadDefaultPage";

    if ((email != null && email != "") || (nickname != null && nickname != "")) {

        confirm_show("您填写的内容还未保存，确认放弃？",
            function () { window.location = gotoPage; },"确认放弃");

        return;
    } else {
        window.location = gotoPage;
    }
}