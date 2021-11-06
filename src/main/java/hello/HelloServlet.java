package hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.lang.StringBuffer; // inverter o nome

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String msg = "";
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Alô, ";
                break;
            case "en":
                msg = "Hello, ";
                break;
            case "fr":
                msg = "Bonjour, ";
                break;
            case "hv":
                msg = "Aloha, ";
                break;
            case "it":
                msg = "Ciao, ";
                break;
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
          msg = msg+nome+"!";


        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = "";
        String msg2= "";

        Calendar c1 = Calendar.getInstance();
        int hora = c1.get(Calendar.HOUR_OF_DAY);

        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                if (hora > 6 && hora < 12) {
                    msg = "Alô, Bom dia ";
//                    msg = "Alô, Bom dia "+String.valueOf(hora);
                    break;
                } else if (hora > 12 && hora <18){
                    msg = "Alô, Boa tarde ";
                    break;
                }else {
                    msg = "Alô, Boa noite ";
                    break;
                }
            case "en":
                if (hora > 6 && hora < 12) {
                    msg = "Hello, Good Morning ";
                    break;
                } else if (hora > 12 && hora <18){
                    msg = "Hello, Good Afternoon ";
                    break;
                }else {
                    msg = "Hello, Good Night ";
                    break;
                }
            case "fr":
                if (hora > 6 && hora < 12) {
                    msg = "Salut, Bonjour ";
                    break;
                } else if (hora > 12 && hora <18){
                    msg = "Salut, Bon après-midi ";
                    break;
                }else {
                    msg = "Salut, bonne nuit ";
                    break;
                }
            case "de":
                if (hora > 6 && hora < 12) {
                    msg = "Hallo, Guten Morgen ";
                    break;
                } else if (hora > 12 && hora <18){
                    msg = "Hallo, Guten Tag ";
                    break;
                }else {
                    msg = "Hallo, Gute Natch ";
                    break;
                }
            case "hv":
                if (hora > 6 && hora < 12) {
                    msg = "Aloha, kakahiaka ";
                    break;
                } else if (hora > 12 && hora <18){
                    msg = "Aloha, Awakea ";
                    break;
                }else {
                    msg = "Aloha, Ahiahi ";
                    break;
                }
            case "it":
                if (hora > 6 && hora < 12) {
                    msg = "Ciao, Buon giorno ";
                    break;
                } else if (hora > 12 && hora <18){
                    msg = "Ciao, Buon pomeriggio ";
                    break;
                }else {
                    msg = "Ciao, Buona Notte ";
                    break;
                }
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
//adicionando funcionalidade, inverter o nome:

//        String palavra = "Teste";
        String palavra = nome;
        StringBuffer sb = new StringBuffer(palavra);
        String nomeInvert = sb.reverse().toString();

//        System.out.println(palavraInvertida);

// adicionando o tratamento que o usuario selecionar, recebe parametro trat

        String trat = request.getParameter("trat");
        if (trat==null)
            trat = "nh";

        switch (trat){
            case "sr":
                if (lang.equals("pt")) {
                    msg2 = "Senhor ";
                    break;
                } else if (lang.equals("en")) {
                    msg2 = "Mister ";
                    break;
                } else if (lang.equals("fr")){
                    msg2 = "Monsieur ";
                    break;
                } else if (lang.equals("de")){
                    msg2 = "Herr ";
                    break;
                } else if (lang.equals("hv")){
                    msg2 = "Mesye ";
                    break;
                }else {
                    msg2 = "Sig ";
                    break;
                }
            case "sa":
                if (lang.equals("pt")) {
                    msg2 = "Senhora ";
                    break;
                } else if (lang.equals("en")) {
                    msg2 = "Madam ";
                    break;
                } else if (lang.equals("fr")){
                    msg2 = "Madame ";
                    break;
                } else if (lang.equals("de")){
                    msg2 = "Gnädige Frau ";
                    break;
                } else if (lang.equals("hv")){
                    msg2 = "Madam ";
                    break;
                }else {
                    msg2 = "Signora ";
                    break;
                }
            case "nh":
                msg2="";
                break;
        }
        // ===================final da adicao
        // ===================add msg2 na saudação final;

       // msg = msg+""+msg2+" "+nome+"!"+nomeInvert;
        msg = msg+""+msg2+" "+nome+"!";


        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
