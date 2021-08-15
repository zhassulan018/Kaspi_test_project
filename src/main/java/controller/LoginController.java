package controller;
import entity.User;
import model.UserModel;
import utility.MessageUtil;
import utility.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet{
    private User populate(HttpServletRequest request){
        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        return user;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = populate(req);
        User dbUser = UserModel.findByLogin(user.getLogin());
        if(dbUser.getPassword().equals(PasswordUtil.generateSecurePassword(user.getPassword()))){
            HttpSession session = req.getSession();
            session.setAttribute("user", dbUser);
            resp.sendRedirect("/search");
        }else{
            MessageUtil.setErrorMessage("Неправильный логин или пароль!", req);
            getServletContext().getRequestDispatcher("/jsp/Login.jsp").forward(req,resp);
        }


    }
}
