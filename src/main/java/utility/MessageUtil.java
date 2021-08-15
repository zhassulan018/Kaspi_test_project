package utility;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
    public static void setErrorMessage(String msg, HttpServletRequest request) {
        request.setAttribute("error", msg);
    }

    public static String getErrorMessage(HttpServletRequest request) {
        String val = (String) request.getAttribute("error");
        if (val == null) {
            return "";
        } else {
            return val;
        }
    }
}
