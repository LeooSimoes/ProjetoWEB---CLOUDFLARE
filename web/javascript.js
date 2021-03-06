function popUpReg() {
    $(".dadosI.f").keyup(_.throttle(function () {
        $(".miniloading").css("display", "block");
        $.ajax({
            type: "get",
            url: "./buscaLogin?email=" + $(".dadosI.f").val(),
            dataType: "json",
            success: function (data) {
                if ($(".dadosI.f").val() == "") {
                    $(".verif.e").css("display", "none");
                    $(".verif.c").css("display", "none");
                } else if (($(".dadosI.f").val()).length == 1) {
                    $(".verif.e").css("display", "block");
                    $(".verif.c").css("display", "none");
                } else if (data["resultado"] == true) {
                    $(".verif.e").css("display", "block");
                    $(".verif.c").css("display", "none");
                } else {
                    $(".verif.c").css("display", "block");
                    $(".verif.e").css("display", "none");
                }
            }
        });
        $(document).ajaxComplete(function () {
            $(".miniloading").css("display", "none");
        });
    }, 1500));

    document.querySelector(".right-bord").addEventListener("click", function () {
        document.querySelectorAll(".tela-post.sumido")[0].className = "tela-post";   
        $(".submit.I").click(function (ev) {
            $(".loading").css("display", "block");
            $.ajax({
                type: "post",
                url: "./inscrever",
                data: {
                    email: $(".dadosI.f").val(),
                    senha: $(".dadosI.s").val(),
                    cep: $(".dadosI.t").val(),
                    cidade: $(".dadosI.fo").val(),
                    uf: $(".dadosI.fi").val(),
                    bairro: $(".dadosI.si").val(),
                    rua: $(".dadosI.se").val()
                }
            });
            $(document).ajaxComplete(function () {
                setTimeout(function () {
                    $(".loading").css("display", "none");
                    document.querySelectorAll(".tela-post")[0].className = "tela-post sumido";
                    $(".insc").each(function(){
                        this.reset();
                    });
                    $(".verif.c").css("display", "none");
                    $(".verif.e").css("display", "none");
                }, 2000);
            });
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

function getEndereco() {
    if ($.trim($(".dadosI.t").val()) != "") {
        $.getJSON("http://cep.republicavirtual.com.br/web_cep.php?cep=" + $(".dadosI.t").val() + "&formato=json", function (data) {
            console.log(data);
            if (data["resultado"]) {
                $(".dadosI.fo").val(decodeURIComponent(data["cidade"]));
                $(".dadosI.fi").val(decodeURIComponent(data["uf"]));
                $(".dadosI.si").val(decodeURIComponent(data["bairro"]));
                if (data["tipo_logradouro"] !== "") {
                    $(".dadosI.se").val(decodeURIComponent(data["tipo_logradouro"]) + " " + decodeURIComponent(data["logradouro"]));
                }
            }
        });
    }
}