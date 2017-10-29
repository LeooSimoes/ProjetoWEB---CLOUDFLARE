<%@page import="javax.servlet.annotation.MultipartConfig"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ClassServlets.postagens"%>
<%@page import="banco.Consultas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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

        <%if ((request.getSession()).getAttribute("logado") == null) {%>
        <nav class="menu">
            <div class="desktop">
                <img class="logo" src="imagens/logo-cloudflare.svg">
                <ul>
                    <li class="hover-white">
                        <a href class="dark">Produtos<div class="iconpro"><img src="imagens/iconpro.png"></div></a>
                    </li>

                    <li class="hover-white"><a href class="dark">Planos</a></li>
                    <li class="hover-white"><a href class="dark">Blog</a></li>
                    <li class="hover-white_x"><a href class="dark">Sales <span style="font-weight: bold;">1-888-993-5273</span></a></li>

                    <div class="right">

                        <div class="right-bord">
                            <li class="li-right-bord"><a href="./inscrever">Inscreva-se</a></li>
                        </div>

                        <li class="right"><a href ="./login" class="dark">Login</a></li>
                        <li class="right"><a href class="dark">Está sob ataque?</a></li>
                        <li class="right"><a href class="dark">Suporte</a></li>

                    </div>
                </ul>

                <div class="iconmobile">
                    <img class="listrinha" src="imagens/mobile.png">
                </div>
            </div>
        </nav>

        <div class="back-photo">
            <img class="img" src="imagens/poster.jpg"/>
        </div>

        <div class="gradient">
        </div>

        <div class="center">
            <h1 class="center">Faça com que a Internet funcione como deveria</h1>
            <a href class="subcenter">Assista o vídeo <span style="font-size: 12px">></span></a>
        </div>

        <section class="scroll">
            <div class="scroll-center">
                <h1 class="sp-center">Rede global construída para escalar exponencialmente</h1>
                <h2 class="sp-center">10 Tbps de capacidade e 117 data centers</h2>
                <div class="mapa">
                    <img src="imagens/mapa.jpg">
                </div>
            </div>
        </section>

        <div class="pessoal">
            <div class="sub-pessoal">
                <h1 class="sp-center">Fazemos a Internet funcionar da maneira que deveria para qualquer coisa online</h1>
                <h3 class="sp-center">A Cloudflare acelera e protege milhões de sites, APIs, serviços SaaS e outras propriedades conectadas à Internet. Nossa tecnologia Anycast permite que nossos benefícios se escalem com cada servidor que adicionamos à nossa crescente rede de data centers.</h3>
            </div>
        </div>
        <div class="foot"></div>

        <%} else {%>

        <nav class="menu">
            <div class="desktop">
                <img class="logo" src="imagens/logo-cloudflare.svg">
                <ul>
                    <li class="hover-white">
                        <a href class="dark">Produtos<div class="iconpro"><img src="imagens/iconpro.png"></div></a>
                    </li>

                    <li class="hover-white"><a href class="dark">Planos</a></li>
                    <li class="hover-white"><a href class="dark">Blog</a></li>
                    <li class="hover-white_x"><a href class="dark">Sales <span style="font-weight: bold;">1-888-993-5273</span></a></li>

                    <div class="right">

                        <div class="right-bord">
                            <li class="li-right-bord"><a href><%out.println((request.getSession()).getAttribute("usuario"));%></a></li>
                        </div>

                        <li class="right"><a href class="dark">Está sob ataque?</a></li>
                        <li class="right"><a href class="dark">Suporte</a></li>

                    </div>
                </ul>

                <div class="iconmobile">
                    <img class="listrinha" src="imagens/mobile.png">
                </div>
            </div>
        </nav>

        <div class="back-photo">
            <img class="img" src="imagens/poster.jpg"/>
        </div>

        <div class="gradient">
        </div>

        <div class="center">
            <h1 class="center">Faça com que a Internet funcione como deveria</h1>
            <a href class="subcenter">Assista o vídeo <span style="font-size: 12px">></span></a>
        </div>

        <section class="scroll">
            <div class="scroll-center">
                <h1 class="sp-center">Rede global construída para escalar exponencialmente</h1>
                <h2 class="sp-center">10 Tbps de capacidade e 117 data centers</h2>
                <div class="mapa">
                    <img src="imagens/mapa.jpg">
                </div>
            </div>
        </section>

        <div class="pessoal">
            <div class="sub-pessoal">
                <h1 class="sp-center">Fazemos a Internet funcionar da maneira que deveria para qualquer coisa online</h1>
                <h3 class="sp-center">A Cloudflare acelera e protege milhões de sites, APIs, serviços SaaS e outras propriedades conectadas à Internet. Nossa tecnologia Anycast permite que nossos benefícios se escalem com cada servidor que adicionamos à nossa crescente rede de data centers.</h3>
            </div>

            <div class="postagens">
                <h1 class="sp-center" style="margin-top: 45px; text-align: center;"><a href="./postar.jsp" style="text-decoration: none">Deseja postar? Clique aqui</a></h1>
                <form action="./busca.jsp" method="get" enctype="multipart/form-data">
                    <input class="busca" type="text" name="busca" placeholder="Buscar Posts..." value="">
                </form>
                <%  Consultas c = new Consultas();
                    String user = String.valueOf((request.getSession()).getAttribute("usuario"));
                    int id = c.idUser(user);
                    ArrayList<postagens> post = c.post(id);
                    for (int i = 0; i < post.size(); i++) {%>
                <div class="post">
                    <%postagens p = post.get(i);%>
                    <h2><%= p.getTitulo()%></h2>
                    <p><%= p.getTexto()%></p>
                    <%String ext = p.getFile().substring(p.getFile().lastIndexOf("."));%>
                    <% if (ext.equals(".jpg") || ext.equals(".png")) {%>
                    <img src="<%=request.getContextPath()%>/<%=p.getFile()%>" width="60%" height="20%">
                    <%} else if (ext.equals(".mp4") || (ext.equals(".webm")) || (ext.equals(".ogg"))) {%> 
                    <video width="60%" height="20%" controls>
                        <source src="<%=request.getContextPath()%>/<%=p.getFile()%>" type="video/mp4">
                        <source src="<%=request.getContextPath()%>/<%=p.getFile()%>" type="video/webm">
                        <source src="<%=request.getContextPath()%>/<%=p.getFile()%>" type="video/ogg">
                    </video> 
                    <%}%>
                </div>
                <%}%>

            </div>
        </div>

        <div class="foot"></div>
        <%}%>
    </body>
</html> 