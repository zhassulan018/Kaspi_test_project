package controller;

import entity.Application;
import entity.Credit;
import model.ApplicationModel;
import service.CreditResultService;
import utility.DataValidation;
import utility.MessageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/credit")
public class CreditController extends HttpServlet {
    private Credit populate(HttpServletRequest request){
        Credit credit = new Credit();
        credit.setTotalSum(Double.parseDouble(request.getParameter("money")));
        credit.setTerm(request.getParameter("term"));
        credit.setPercentage(request.getParameter("percentage"));

        return credit;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/Credit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(checkInputs(req.getParameter("money"),req.getParameter("term"),req.getParameter("percentage"))){
            MessageUtil.setErrorMessage("Заполните все поля",req);
            req.getServletContext().getRequestDispatcher("/jsp/Credit.jsp").forward(req,resp);
        }else {
            populate(req);
            boolean res = CreditResultService.creditResult(Double.valueOf(req.getParameter("month_payment")).longValue(),
                    (Long) req.getSession().getAttribute("iin"));

            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);

            Application application = new Application();
            application.setDate(date);
            application.setTotalMoney(Double.valueOf(req.getParameter("money")).longValue());
            application.setTerm(Integer.parseInt(req.getParameter("term")));
            application.setIin((Long) req.getSession().getAttribute("iin"));

            if(res){
                application.setStatus("Одобрена");
                try {
                    ApplicationModel.save(application);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                application.setStatus("Отказано");
                try {
                    ApplicationModel.save(application);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        resp.sendRedirect("/search");
    }

    private boolean checkInputs(String money, String term, String percentage){
        return DataValidation.isNull(money) || DataValidation.isNull(term) ||DataValidation.isNull(percentage);
    }
}
