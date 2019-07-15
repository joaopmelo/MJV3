package server.crud.acesso;

import server.dao.DaoFactory;
import server.dominio.Acesso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

@WebServlet(name = "InseriAcesso")
public class InseriAcesso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        Acesso acesso = new Acesso();
        acesso.setLogin("usuario");
        acesso.setSenha("123456");
        acesso.setEmail("fulano@gmail.com");
        acesso.setReceberNoticia(true);

        DaoFactory dao = new DaoFactory();

        dao.getAcessoDao().add(acesso);

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Inserir</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Acesso: fulano</h1>");
            out.println("</body>");
            out.println("</html>");

        }
    }
}
