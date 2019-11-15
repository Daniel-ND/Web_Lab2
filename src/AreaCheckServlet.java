import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AreaCheckServlet extends HttpServlet {
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        super.doGet(request, response);
    }*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        double x, y, r;
        try {
            x = Double.parseDouble(request.getParameter("X"));
            y = Double.parseDouble(request.getParameter("Y"));
            r = Double.parseDouble(request.getParameter("R"));

            // добавление нового запроса
            PointsBean bean = getSessionBean(request.getSession());
            List<Point> points = bean.getPointList();
            points.add(new Point(x, y, r, calcRes(x, y, r)));
            bean.setPointList(points);


            // обновление таблицы результатов
            String table = createTable(points);
            PrintWriter out = response.getWriter();
            out.println(table);
            out.flush();
            request.getSession().setAttribute("PointBean", bean);

        } catch (NumberFormatException e) {

        }

    }

    private String createTable(List<Point> points) {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr><th>X</th><th>Y</th><th>R</th><th>Result</th></tr>");
        for (Point point : points) {
            String x = String.valueOf(point.getX());
            String y = String.valueOf(point.getY());
            sb.append("<tr>");
            sb.append("<td>").append(x, 0, Math.min(x.length(), 5)).append("</td>");
            sb.append("<td>").append(y, 0, Math.min(y.length(), 5)).append("</td>");
            sb.append("<td>").append(point.getR()).append("</td>");
            sb.append("<td>").append(point.getRes()).append("</td>");
            sb.append("</tr>");
        }

        return sb.toString();
    }

    boolean calcRes(double x, double y, double r){
        if (x >= 0 && y >= 0) {
            if (y <= r / 2.0 && x <= r) return true;
        }

        if (x >= 0 && y <= 0){
            if (y - 2.0 * x + r >= 0) return true;
        }

        if (x <= 0 && y <= 0){
            if (Math.pow(x, 2.0) + Math.pow(y, 2.0) <= Math.pow(r/2.0, 2.0)) return true;
        }
        return false;
    }
    private PointsBean getSessionBean(HttpSession session){
        PointsBean bean = (PointsBean) session.getAttribute("PointBean");
        if (bean == null){
            bean = new PointsBean();
            session.setAttribute("PointsBean", bean);
        }
        return bean;
    }
}
