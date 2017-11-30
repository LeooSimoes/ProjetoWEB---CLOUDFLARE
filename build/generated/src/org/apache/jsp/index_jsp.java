package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.annotation.MultipartConfig;
import java.util.ArrayList;
import ClassServlets.postagens;
import banco.Consultas;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Cloudflare, a Empresade Desempenho e Segurança Web | Cloudflare Brasil</title>\n");
      out.write("        <meta charset=\"utf-8\" name=\"viewport\" content=\"width=400px\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./estilo.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"./underscore.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"./jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"./javascript.js\"></script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    ");
if ((request.getSession()).getAttribute("logado") == null) {
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            window.onload = function () {\n");
      out.write("                popUpReg();\n");
      out.write("                popUpLog();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <nav class=\"menu\">\n");
      out.write("            <div class=\"desktop\">\n");
      out.write("                <img class=\"logo\" src=\"imagens/logo-cloudflare.svg\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"hover-white\">\n");
      out.write("                        <span class=\"dark\">Produtos<div class=\"iconpro\"><img src=\"imagens/iconpro.png\"></div></span>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"hover-white\"><span class=\"dark\">Planos</span></li>\n");
      out.write("                    <li class=\"hover-white\"><span class=\"dark\">Blog</span></li>\n");
      out.write("                    <li class=\"hover-white_x\"><span class=\"dark\">Sales <span class=\"dark\" style=\"font-weight: bold;\">1-888-993-5273</span></span></li>\n");
      out.write("\n");
      out.write("                    <div class=\"right\">\n");
      out.write("\n");
      out.write("                        <div class=\"right-bord\">\n");
      out.write("                            <li class=\"li-right-bord\">Inscreva-se</li>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"tela-post sumido\">\n");
      out.write("                            <div class=\"container-post\" style=\"margin-top: 50px; height: 525px\">\n");
      out.write("                                <h2 class=\"crie\" style=\"margin-bottom:20px\">Crie uma conta CloudFlare</h2>\n");
      out.write("                                <form autocomplete=\"off\">\n");
      out.write("                                    <div><input class=\"dadosI f\" placeholder=\"Email\" type=\"text\" name=\"email\" value=\"\" required=\"required\" aria-invalid=\"true\"></div>\n");
      out.write("                                    <img class=\"verif c\" src=\"imagens/certo.png\">\n");
      out.write("                                    <img class=\"verif e\" src=\"imagens/errado.png\">\n");
      out.write("                                    <div><input class=\"dadosI s\" placeholder=\"Senha\" type=\"password\" name=\"senha\" value=\"\" required=\"required\" aria-invalid=\"true\"></div>\n");
      out.write("                                    <div><input class=\"dadosI t\" placeholder=\"CEP\" type=\"text\" name=\"cep\" value=\"\" onblur=\"getEndereco()\"></div>\n");
      out.write("                                    <div><input class=\"dadosI fo\" placeholder=\"Cidade\" type=\"text\" name=\"cidade\" value=\"\"></div>\n");
      out.write("                                    <div><input class=\"dadosI fi\" placeholder=\"Estado\" type=\"text\" name=\"estado\" value=\"\"></div>\n");
      out.write("                                    <div><input class=\"dadosI si\" placeholder=\"Bairro\" type=\"text\" name=\"bairro\" value=\"\"></div>\n");
      out.write("                                    <div><input class=\"dadosI se\" placeholder=\"Rua\" type=\"text\" name=\"rua\" value=\"\"></div>\n");
      out.write("                                    <div class=\"control\"><div class=\"check\"><input class=\"check\" required=\"required\" aria-invalid=\"true\" type=\"checkbox\"></div>\n");
      out.write("                                        <span class=\"text\">Aceito os termos e condições da Cloudflare e a política de privacidade.</span></div>\n");
      out.write("                                    <input class=\"submit I\" type=\"submit\" value=\"Criar Conta\">\n");
      out.write("                                    <img class=\"loading\" src=\"imagens/loading.gif\">\n");
      out.write("                                    <div class=\"close\"><span>Fechar</span></div>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <li class=\"right\"><span class=\"dark login\">Login</span></li>\n");
      out.write("                        <div class=\"tela-post sumido\">\n");
      out.write("                            <div class=\"container-post\">\n");
      out.write("                                <h2 class=\"crie\">Logue em sua conta CloudFlare</h2>\n");
      out.write("                                <form autocomplete=\"off\"  action=\"./login\" method=\"post\">\n");
      out.write("                                    <div><input class=\"dados\" id=\"email\" placeholder=\"Email\" type=\"text\" name=\"email\" value=\"\"></div>\n");
      out.write("                                    <div><input class=\"dados\" id=\"senha\" placeholder=\"Senha\" type=\"password\" name=\"senha\" value=\"\"></div>\n");
      out.write("                                    <input class=\"submit L\" id=\"criar\" type=\"submit\" value=\"Logar\">\n");
      out.write("                                    <span class=\"invisible\">Dados invalidos</span>\n");
      out.write("                                    <div class=\"close\"><span>Fechar</span></div>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <li class=\"right\"><span class=\"dark\">Está sob ataque?</span></li>\n");
      out.write("                        <li class=\"right\"><span class=\"dark\">Suporte</span></li>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("                <div class=\"iconmobile\">\n");
      out.write("                    <img class=\"listrinha\" src=\"imagens/mobile.png\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"back-photo\">\n");
      out.write("            <img class=\"img\" src=\"imagens/poster.jpg\"/>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"gradient\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"center\">\n");
      out.write("            <h1 class=\"center\">Faça com que a Internet funcione como deveria</h1>\n");
      out.write("            <span class=\"subcenter\">Assista o vídeo <span style=\"font-size: 12px\">></span></span>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <section class=\"scroll\">\n");
      out.write("            <div class=\"scroll-center\">\n");
      out.write("                <h1 class=\"sp-center\">Rede global construída para escalar exponencialmente</h1>\n");
      out.write("                <h2 class=\"sp-center\">10 Tbps de capacidade e 117 data centers</h2>\n");
      out.write("                <div class=\"mapa\">\n");
      out.write("                    <img src=\"imagens/mapa.jpg\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <div class=\"pessoal\">\n");
      out.write("            <div class=\"sub-pessoal\">\n");
      out.write("                <h1 class=\"sp-center\">Fazemos a Internet funcionar da maneira que deveria para qualquer coisa online</h1>\n");
      out.write("                <h3 class=\"sp-center\">A Cloudflare acelera e protege milhões de sites, APIs, serviços SaaS e outras propriedades conectadas à Internet. Nossa tecnologia Anycast permite que nossos benefícios se escalem com cada servidor que adicionamos à nossa crescente rede de data centers.</h3>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"foot\"></div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("    ");
} else {
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            window.onload = function () {\n");
      out.write("                popUpPost();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <nav class=\"menu\">\n");
      out.write("            <div class=\"desktop\">\n");
      out.write("                <img class=\"logo\" src=\"imagens/logo-cloudflare.svg\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"hover-white\">\n");
      out.write("                        <span class=\"dark\">Produtos<div class=\"iconpro\"><img src=\"imagens/iconpro.png\"></div></span>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"hover-white\"><span class=\"dark\">Planos</span></li>\n");
      out.write("                    <li class=\"hover-white\"><span class=\"dark\">Blog</span></li>\n");
      out.write("                    <li class=\"hover-white_x\"><span class=\"dark\">Sales <span class=\"dark\" style=\"font-weight: bold;\">1-888-993-5273</span></span></li>\n");
      out.write("\n");
      out.write("                    <div class=\"right\">\n");
      out.write("                        <div class=\"right-bord\">\n");
      out.write("                            <li class=\"li-right-bord\"><span>");
out.println((request.getSession()).getAttribute("usuario"));
      out.write("</span></li>\n");
      out.write("                        </div>\n");
      out.write("                        <li class=\"right\"><span class=\"dark\">Está sob ataque?</span></li>\n");
      out.write("                        <li class=\"right\"><span class=\"dark\">Suporte</span></li>\n");
      out.write("                    </div>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("                <div class=\"iconmobile\">\n");
      out.write("                    <img class=\"listrinha\" src=\"imagens/mobile.png\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"back-photo\">\n");
      out.write("            <img class=\"img\" src=\"imagens/poster.jpg\"/>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"gradient\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"center\">\n");
      out.write("            <h1 class=\"center\">Faça com que a Internet funcione como deveria</h1>\n");
      out.write("            <span class=\"subcenter\">Assista o vídeo <span style=\"font-size: 12px\">></span></span>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <section class=\"scroll\">\n");
      out.write("            <div class=\"scroll-center\">\n");
      out.write("                <h1 class=\"sp-center\">Rede global construída para escalar exponencialmente</h1>\n");
      out.write("                <h2 class=\"sp-center\">10 Tbps de capacidade e 117 data centers</h2>\n");
      out.write("                <div class=\"mapa\">\n");
      out.write("                    <img src=\"imagens/mapa.jpg\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <div class=\"pessoal\">\n");
      out.write("            <div class=\"sub-pessoal\">\n");
      out.write("                <h1 class=\"sp-center\">Fazemos a Internet funcionar da maneira que deveria para qualquer coisa online</h1>\n");
      out.write("                <h3 class=\"sp-center\">A Cloudflare acelera e protege milhões de sites, APIs, serviços SaaS e outras propriedades conectadas à Internet. Nossa tecnologia Anycast permite que nossos benefícios se escalem com cada servidor que adicionamos à nossa crescente rede de data centers.</h3>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"postagens\">\n");
      out.write("\n");
      out.write("                <h1 class=\"sp-center\" style=\"margin-top: 45px; text-align: center;\">\n");
      out.write("                    <button class=\"btn-post\" type=\"button\">Deseja postar? Clique aqui</button>\n");
      out.write("                </h1>\n");
      out.write("\n");
      out.write("                <form autocomplete=\"off\"  action=\"./busca.jsp\" method=\"get\" enctype=\"multipart/form-data\">\n");
      out.write("                    <input class=\"busca\" type=\"text\" name=\"busca\" placeholder=\"Buscar Posts...\" value=\"\">\n");
      out.write("                </form>\n");
      out.write("                ");
  Consultas c = new Consultas();

                    String user = String.valueOf((request.getSession()).getAttribute("usuario"));
                    int id = c.idUser(user);
                    ArrayList<postagens> post = c.post(id);

                    for (int i = 0; i < post.size(); i++) {
      out.write("\n");
      out.write("                <div class=\"post\">\n");
      out.write("\n");
      out.write("                    ");
postagens p = post.get(i);
      out.write("\n");
      out.write("\n");
      out.write("                    <h2>");
      out.print( p.getTitulo());
      out.write("</h2>\n");
      out.write("                    <p>");
      out.print( p.getTexto());
      out.write("</p>\n");
      out.write("\n");
      out.write("                    ");
if (!p.getFile().equals("")) {
                        String ext = p.getFile().substring(p.getFile().lastIndexOf("."));
      out.write("\n");
      out.write("                    ");
if (ext.equals(".jpg") || ext.equals(".png")) {
      out.write("\n");
      out.write("                    <img src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.print(p.getFile());
      out.write("\" width=\"60%\" height=\"20%\">\n");
      out.write("                    ");
} else if (ext.equals(".mp4") || (ext.equals(".webm")) || (ext.equals(".ogg"))) {
      out.write(" \n");
      out.write("                    <video width=\"60%\" height=\"20%\" controls>\n");
      out.write("                        <source src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.print(p.getFile());
      out.write("\" type=\"video/mp4\">\n");
      out.write("                        <source src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.print(p.getFile());
      out.write("\" type=\"video/webm\">\n");
      out.write("                        <source src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.print(p.getFile());
      out.write("\" type=\"video/ogg\">\n");
      out.write("                    </video> \n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-----------------------------------------AREA DE POSTAGEM------------------------------------------------------------------>\n");
      out.write("        <div class=\"tela-post sumido\">\n");
      out.write("            <div class=\"container-post\">\n");
      out.write("                <form autocomplete=\"off\"  action=\"./form\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                    ");

                        Consultas c2 = new Consultas();
                        String user2 = String.valueOf((request.getSession()).getAttribute("usuario"));
                        int id2 = c2.idUser(user2);
                    
      out.write("\n");
      out.write("                    <input type=\"hidden\" name=\"id\" value=\"");
      out.print(id);
      out.write("\">\n");
      out.write("                    <div><input class=\"titulo\" type=\"text\" name=\"titulo\" placeholder=\"Título\" value=\"\"></div>\n");
      out.write("                    <div><textarea class=\"dadosI\" name=\"texto\" maxlength=\"255\" placeholder=\"Escreva Aqui...\" value=\"\"></textarea></div>\n");
      out.write("                    <div><input class=\"files\" type=\"file\" name=\"arquivos\"></div>\n");
      out.write("                    <div><input class=\"postar\" type=\"submit\" name=\"postar\" value=\"Postar\"></div>\n");
      out.write("                    <div class=\"close\"><span>Fechar</span></div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-----------------------------------------AREA DE POSTAGEM------------------------------------------------------------------>\n");
      out.write("\n");
      out.write("        <div class=\"foot\"></div>\n");
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html> ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
