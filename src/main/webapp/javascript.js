$(function () {
    var nav = $(".menu");
    var img = $(".logo");
    var div = $(".li-right-bord");
    var imgMob = $(".listrinha");
    var li = $(".hover-white");
    var li2 = $(".hover-white_x");
    $(window).scroll(function () {
        if ($(this).scrollTop() > 0) {
            nav.addClass("menuFixo");
            img.attr("src", "imagens/logo-cloudflare-dark.svg");
            div.addClass("li-right-bordB");
            imgMob.attr("src", "imagens/MobileDark.png");
            li.addClass("rOrange");
            li2.addClass("rOrange");
        } else {
            nav.removeClass("menuFixo");
            img.attr("src", "imagens/logo-cloudflare.svg");
            div.removeClass("li-right-bordB");
            imgMob.attr("src", "imagens/mobile.png");
            li.removeClass("rOrange");
            li2.removeClass("rOrange");
        }
    });
});
      