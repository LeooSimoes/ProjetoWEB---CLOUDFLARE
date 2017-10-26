<%@page import="banco.Consultas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html>
        <head>
            <title>Cloudflare, a Empresade Desempenho e Segurança Web | Cloudflare Brasil</title>
            <meta charset="utf-8" name="viewport" content="width=400px">
            <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:300" rel="stylesheet">
            <link href="https://fonts.googleapis.com/css?family=Open+Sans:300" rel="stylesheet">
            <link rel="stylesheet" href="./estilo.css">
            <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
            <script type="text/javascript" src="./javascript.js"></script>

        </head>
        <body>

            <%if ((request.getSession()).getAttribute("logado") != null) {%>
            <div class="top">
                <a href="./index.jsp"><img class="logo-dark" src="imagens/logo-cloudflare-dark.svg"></a>
                <div class="user">
                    <p class="user"><%out.println((request.getSession()).getAttribute("usuario"));%></p>
                </div> 
                <div class="iconmobile">
                    <img class="listrinha" src="imagens/MobileDark.png">
                </div>
            </div>
            <div class="tela">
                <div class="container" style="width: 625px; height: 375px; margin-top: 13px;text-align: center;">
                    <form action="./form" method="post">
                        <%
                            Consultas c = new Consultas();
                            String user = String.valueOf((request.getSession()).getAttribute("usuario"));
                            int id = c.idUser(user);%>
                             <input type="hidden" name="id" value="<%=id%>"></input>
                        <div><input class="titulo" type="text" name="titulo" placeholder="Título" value=""></input></div>
                        <div><textarea class="dadosI" name="texto" maxlength="255" placeholder="Escreva Aqui..." value=""></textarea></div>
                        <div><input class="files" type="file" name="arquivos"></input></div>
                        <div><input class="postar" type="submit" name="postar" value="Postar"></input></div>
                    </form>
                </div>
            </div>

            <%} else {
            %><h1><%out.println("Página não encontrada :/");
                }%></h1>
        </body>
    </html>

