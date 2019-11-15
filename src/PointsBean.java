import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PointsBean implements Serializable {
    private List <Point> points;
    public PointsBean (){
        points = new ArrayList<>();
    }
    public PointsBean(List<Point> points){
        this.points = points;
    }

    public void setPointList(List<Point> points){
        this.points = points;
    }

    public List<Point> getPointList(){
        return this.points;
    }
}
