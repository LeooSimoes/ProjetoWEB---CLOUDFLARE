<%-- 
    Document   : busca
    Created on : 27/10/2017, 22:09:04
    Author     : leona
--%>

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

        <%if (!((request.getSession()).getAttribute("logado") == null)) {%>

        <div class="top">
            <a href="./index.jsp"><img class="logo-dark" src="./imagens/logo-cloudflare-dark.svg"></a>
        </div>
        <div class="tela" style="height: auto; padding-bottom: 10px;">

            <%  Consultas c = new Consultas();
                     ArrayList<postagens> post = c.busca(request.getParameter("busca"));
                     for (int i = 0; i < post.size(); i++) {%>
                     <div class="post" style="width: 50%;">
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
            <div class="foot"</div>

            <%} else {
                response.sendRedirect("./index.jsp");
            }%>
    </body>
</html>
