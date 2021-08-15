package controller;

import entity.Application;
import model.ApplicationModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class SearchController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("applications",new ArrayList<>());
        getServletContext().getRequestDispatcher("/jsp/Search.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String iin = req.getParameter("search_bar");
        List<Application> applications = ApplicationModel.findByIIN(iin);
        if(applications.size() == 0){
            resp.sendRedirect("/client");
        }else{
            req.setAttribute("applications", applications);
            req.getServletContext().getRequestDispatcher("/jsp/Search.jsp").forward(req,resp);
        }
    }
}
