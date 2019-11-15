import java.io.Serializable;

public class Point implements Serializable {
    private double x, y, r;
    private boolean res;

    public Point (){
        x = y = r = 0;
        res = false;
    }

    public Point (double x, double y, double r, boolean res){
        this.x = x;
        this.r = r;
        this.y = y;
        this.res = res;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public boolean getRes() {
        return res;
    }

    public void setRes(boolean result) {
        this.res = result;
    }
}
