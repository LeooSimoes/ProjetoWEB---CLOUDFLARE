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
        <link rel="stylesheet" href="./estilo.css">
        <script type="text/javascript" src="./jquery.min.js"></script>
        <script type="text/javascript" src="./javascript.js"></script>
    </head>

    <%if ((request.getSession()).getAttribute("logado") == null) {%>
    <body>
        <script type="text/javascript">
            window.onload = function () {
                popUpReg();
                popUpLog();
            }
        </script>
        <nav class="menu">
            <div class="desktop">
                <img class="logo" src="imagens/logo-cloudflare.svg">
                <ul>
                    <li class="hover-white">
                        <span class="dark">Produtos<div class="iconpro"><img src="imagens/iconpro.png"></div></span>
                    </li>

                    <li class="hover-white"><span class="dark">Planos</span></li>
                    <li class="hover-white"><span class="dark">Blog</span></li>
                    <li class="hover-white_x"><span class="dark">Sales <span class="dark" style="font-weight: bold;">1-888-993-5273</span></span></li>

                    <div class="right">

                        <div class="right-bord">
                            <li class="li-right-bord">Inscreva-se</li>
                        </div>

                        <div class="tela-post sumido">
                            <div class="container-post">
                                <h2 class="crie" style="margin-bottom:20px">Crie uma conta CloudFlare</h2>
                                <form autocomplete="off">
                                    <div><input class="dadosI" placeholder="Email" type="text" name="email" value="" required="required" aria-invalid="true"></div>
                                    <div><input class="dadosI s" placeholder="Senha" type="password" name="senha" value="" required="required" aria-invalid="true"></div>
                                    <div><input class="dadosI t" placeholder="Endereço" type="text" name="endereco" value=""></div>
                                    <div class="control"><div class="check"><input class="check" required="required" aria-invalid="true" type="checkbox"></div>
                                        <span class="text">Aceito os termos e condições da Cloudflare e a política de privacidade.</span></div>
                                    <input class="submit I" type="submit" value="Criar Conta">
                                    <div class="close"><span>Fechar</span></div>
                                </form>
                            </div>
                        </div>

                        <li class="right"><span class="dark login">Login</span></li>
                        <div class="tela-post sumido">
                            <div class="container-post">
                                <h2 class="crie">Logue em sua conta CloudFlare</h2>
                                <form autocomplete="off"  action="./login" method="post">
                                    <div><input class="dados" id="email" placeholder="Email" type="text" name="email" value=""></div>
                                    <div><input class="dados" id="senha" placeholder="Senha" type="password" name="senha" value=""></div>
                                    <input class="submit L" id="criar" type="submit" value="Logar">
                                    <span class="invisible">Dados invalidos</span>
                                    <div class="close"><span>Fechar</span></div>
                                </form>
                            </div>
                        </div>

                        <li class="right"><span class="dark">Está sob ataque?</span></li>
                        <li class="right"><span class="dark">Suporte</span></li>

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
            <span class="subcenter">Assista o vídeo <span style="font-size: 12px">></span></span>
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
    </body>

    <%} else {%>
    <body>
        <script type="text/javascript">
            window.onload = function () {
                popUpPost();
            }
        </script>
        <nav class="menu">
            <div class="desktop">
                <img class="logo" src="imagens/logo-cloudflare.svg">
                <ul>
                    <li class="hover-white">
                        <span class="dark">Produtos<div class="iconpro"><img src="imagens/iconpro.png"></div></span>
                    </li>
                    <li class="hover-white"><span class="dark">Planos</span></li>
                    <li class="hover-white"><span class="dark">Blog</span></li>
                    <li class="hover-white_x"><span class="dark">Sales <span class="dark" style="font-weight: bold;">1-888-993-5273</span></span></li>

                    <div class="right">
                        <div class="right-bord">
                            <li class="li-right-bord"><span><%out.println((request.getSession()).getAttribute("usuario"));%></span></li>
                        </div>
                        <li class="right"><span class="dark">Está sob ataque?</span></li>
                        <li class="right"><span class="dark">Suporte</span></li>
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
            <span class="subcenter">Assista o vídeo <span style="font-size: 12px">></span></span>
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

                <h1 class="sp-center" style="margin-top: 45px; text-align: center;">
                    <button class="btn-post" type="button">Deseja postar? Clique aqui</button>
                </h1>

                <form autocomplete="off"  action="./busca.jsp" method="get" enctype="multipart/form-data">
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

                    <%if (!p.getFile().equals("")) {
                        String ext = p.getFile().substring(p.getFile().lastIndexOf("."));%>
                    <%if (ext.equals(".jpg") || ext.equals(".png")) {%>
                    <img src="<%=request.getContextPath()%>/<%=p.getFile()%>" width="60%" height="20%">
                    <%} else if (ext.equals(".mp4") || (ext.equals(".webm")) || (ext.equals(".ogg"))) {%> 
                    <video width="60%" height="20%" controls>
                        <source src="<%=request.getContextPath()%>/<%=p.getFile()%>" type="video/mp4">
                        <source src="<%=request.getContextPath()%>/<%=p.getFile()%>" type="video/webm">
                        <source src="<%=request.getContextPath()%>/<%=p.getFile()%>" type="video/ogg">
                    </video> 
                    <%}%>
                    <%}%>
                </div>
                <%}%>

            </div>
        </div>

        <!-----------------------------------------AREA DE POSTAGEM------------------------------------------------------------------>
        <div class="tela-post sumido">
            <div class="container-post">
                <form autocomplete="off"  action="./form" method="post" enctype="multipart/form-data">
                    <%
                        Consultas c2 = new Consultas();
                        String user2 = String.valueOf((request.getSession()).getAttribute("usuario"));
                        int id2 = c2.idUser(user2);
                    %>
                    <input type="hidden" name="id" value="<%=id%>">
                    <div><input class="titulo" type="text" name="titulo" placeholder="Título" value=""></div>
                    <div><textarea class="dadosI" name="texto" maxlength="255" placeholder="Escreva Aqui..." value=""></textarea></div>
                    <div><input class="files" type="file" name="arquivos"></div>
                    <div><input class="postar" type="submit" name="postar" value="Postar"></div>
                    <div class="close"><span>Fechar</span></div>
                </form>
            </div>
        </div>
        <!-----------------------------------------AREA DE POSTAGEM------------------------------------------------------------------>

        <div class="foot"></div>

        <%}%>
    </body>
</html> 