function popUpReg() {
    document.querySelector(".right-bord").addEventListener("click", function () {
        document.querySelectorAll(".tela-post.sumido")[0].className = "tela-post";
        $(".submit.I").click(function (ev) {
            $.ajax({
                type: "post",
                url: "./inscrever",
                data: {
                    email: $(".dadosI").val(),
                    senha: $(".dadosI.s").val(),
                    endereco: $(".dadosI.t").val()
                }
            });

            document.querySelectorAll(".tela-post")[0].className = "tela-post sumido";
            return false;
        });
        document.querySelectorAll(".close")[0].addEventListener("click", function () {
            document.querySelectorAll(".tela-post")[0].className = "tela-post sumido";
        });
    });
}

function popUpLog() {
    document.querySelector(".dark.login").addEventListener("click", function () {
        document.querySelectorAll(".tela-post.sumido")[1].className = "tela-post";
    });
    document.querySelectorAll(".close")[1].addEventListener("click", function () {
        document.querySelectorAll(".tela-post")[1].className = "tela-post sumido";
    });
}

function popUpPost() {
    document.querySelector(".btn-post").addEventListener("click", function () {
        document.querySelectorAll(".tela-post.sumido")[0].className = "tela-post";
    });
    document.querySelectorAll(".close")[0].addEventListener("click", function () {
        document.querySelectorAll(".tela-post")[0].className = "tela-post sumido";
    });
}

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