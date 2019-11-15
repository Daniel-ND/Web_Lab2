import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ControllerServlet extends HttpServlet {
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        super.doGet(request, response);
    }*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String x, y, r;
        x = request.getParameter("X");
        y = request.getParameter("Y");
        r = request.getParameter("R");

       if (checkParam(x, y, r)){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/check");
            rd.forward(request, response);
       }
       else {
           RequestDispatcher rd = getServletContext().getRequestDispatcher("/no_param.jsp");
           request.setAttribute("message", "Некорректно заданы аргументы");
           rd.forward(request, response);
       }
    }

    private boolean checkParam(String x, String y, String r) {
        if (x == null || y == null || r == null) {
            return false;
        } else {
            try {
                double dx, dy, dr;
                dx = Double.parseDouble(x);
                dy = Double.parseDouble(y);
                dr = Double.parseDouble(r);
            } catch (Exception e) {
                return false;
            }

        }
        return true;
    }
}
