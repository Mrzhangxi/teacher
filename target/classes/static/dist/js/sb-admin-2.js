/*!
 * Start Bootstrap - SB Admin 2 v3.3.7+1 (http://startbootstrap.com/template-overviews/sb-admin-2)
 * Copyright 2013-2016 Start Bootstrap
 * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap/blob/gh-pages/LICENSE)
 */
$(function() {
    $('#side-menu').metisMenu();
});

//Loads the correct sidebar on window load,
//collapses the sidebar on window resize.
// Sets the min-height of #page-wrapper to window size
$(function() {
    $(window).bind("load resize", function() {
        var topOffset = 50;
        var width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
        if (width < 768) {
            $('div.navbar-collapse').addClass('collapse');
            topOffset = 100; // 2-row-menu
        } else {
            $('div.navbar-collapse').removeClass('collapse');
        }

        var height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
        height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
        }
    });

    var url = window.location;
    // var element = $('ul.nav a').filter(function() {
    //     return this.href == url;
    // }).addClass('active').parent().parent().addClass('in').parent();
    var element = $('ul.nav a').filter(function() {
        return this.href == url;
    }).addClass('active').parent();

    while (true) {
        if (element.is('li')) {
            element = element.parent().addClass('in').parent();
        } else {
            break;
        }
    }
});

$(document).ready(function () {
    // $.ajax({
    //     type:"GET",
    //     url:" https://api.passport.xxx.com/checkNickname?username="+mylogin.username+"&token="+mylogin.token+"&nickname="+nickname+"&format=jsonp&cb=?",
    //     dataType:"json",
    //     success:function(data){
    //         if(data.errorCode==0){
    //             $("#nickname").val(mylogin.nickname);
    //         }else{
    //             $("#nickname").val("用户");
    //         }
    //     },
    //     error:function(jqXHR){
    //         console.log("Error: "+jqXHR.status);
    //     }
    // });
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/user/all",
        dataType:"json",
        success:function (data) {
            alert(data)
        }
    })
})

