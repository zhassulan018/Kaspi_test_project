package controller;

import entity.Client;
import model.ClientModel;
import service.IINCheckerService;
import utility.DataValidation;
import utility.MessageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

@WebServlet("/client")
public class ClientController extends HttpServlet {
    private Client populate(HttpServletRequest request){
        Client client = new Client();
        client.setIin(Long.parseLong(request.getParameter("iin")));
        client.setBirthday(Date.valueOf(request.getParameter("birthday")));
        client.setDepartmentGiven(request.getParameter("given_department"));
        client.setExpenditure(Long.parseLong(request.getParameter("expenditure")));
        client.setFirstname(request.getParameter("firstname"));
        client.setLastname(request.getParameter("lastname"));
        client.setFathername(request.getParameter("fathername"));
        client.setSex(request.getParameter("sex"));
        client.setDocumentNumber(Long.parseLong(request.getParameter("document_number")));
        client.setPhone(request.getParameter("phone"));
        client.setGivenDate(Date.valueOf(request.getParameter("given_date")));
        client.setUntilDate(Date.valueOf(request.getParameter("outofdate")));
        client.setSalary(Long.parseLong(request.getParameter("salary")));
        return client;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/Client.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(checkWrongInput(request.getParameter("iin"),request.getParameter("birthday"),request.getParameter("given_department"),request.getParameter("expenditure"),
                request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("fathername"),request.getParameter("sex"),request.getParameter("document_number"),
                request.getParameter("phone"),request.getParameter("given_date"),request.getParameter("outofdate"),request.getParameter("salary"))){
            MessageUtil.setErrorMessage("Заполните все поля",request);
            request.getServletContext().getRequestDispatcher("/jsp/Client.jsp").forward(request,response);
        }else if(!checkPhoneNumber(request.getParameter("phone"))){
            MessageUtil.setErrorMessage("Неверный номер телефона",request);
            request.getServletContext().getRequestDispatcher("/jsp/Client.jsp").forward(request,response);
        } else if(!IINCheckerService.checkIinCorrectness(request.getParameter("iin"),request.getParameter("birthday"),request.getParameter("sex"))){
            MessageUtil.setErrorMessage("Неверный ИИН",request);
            request.getServletContext().getRequestDispatcher("/jsp/Client.jsp").forward(request,response);
        }else {
            Client client = populate(request);
            Client dbClient = ClientModel.findByIin(client.getIin());
            if (dbClient == null) {
                try {
                    ClientModel.save(client);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    ClientModel.update(client);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            HttpSession session = request.getSession();
            session.setAttribute("iin", client.getIin());
            response.sendRedirect("/credit");

        }

    }

    public boolean checkWrongInput(String q,String w,String e,String r, String t, String y,String u ,String i,String o,String p,String a,String s,String d){
        return DataValidation.isNull(q) ||DataValidation.isNull(w)
                || DataValidation.isNull(e) || DataValidation.isNull(r)
                || DataValidation.isNull(t) || DataValidation.isNull(y)
                || DataValidation.isNull(u) || DataValidation.isNull(i)
                || DataValidation.isNull(o) || DataValidation.isNull(p)
                || DataValidation.isNull(a) || DataValidation.isNull(s)
                || DataValidation.isNull(d);
    }
    String[] arrPhone = {"(700)","(701)","(702)","(703)","(704)","(705)","(706)","(707)","(708)","(709)",
                         "(747)","(750)","(751)","(760)","(761)","(762)","(763)","(764)","(771)","(775)",
                         "(776)","(777)","(778)"};

    public boolean checkPhoneNumber(String phone){
        for(int i = 0 ; i < arrPhone.length; i++){
            if(phone.contains(arrPhone[i])) return true;
        }
        return false;
    }
}
