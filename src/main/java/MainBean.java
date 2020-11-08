import lombok.Getter;
import lombok.Setter;

import javax.faces.annotation.ManagedProperty;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name = "data", eager = true)
@ApplicationScoped
@Getter
@Setter
public class MainBean implements Serializable {
    double x = 0;
    double y = 0;
    double r = 1;
    ArrayList<Double> List = new ArrayList();
    @ManagedProperty(value = "#{DbBean}")
    DB db=new DB();

    public void submit() {
        System.out.println("==============================");
        List.add(x);
        System.out.println(List);
        db.pushInDB(x, y, r, getResult());

    }

    public boolean getResult() {
        return сheckSquare(x, y, r) || сheckQuarterCircle(x, y, r) || сheckTriangle(x, y, r);
    }

    private boolean сheckSquare(double x, double y, double r) {
        return x >= -r && x <= 0 && y >= 0 && y <= r / 2;
    }

    private boolean сheckQuarterCircle(double x, double y, double r) {
        return (x <= 0) && (y <= 0) && ((x * x + y * y) <= r * r);
    }

    private boolean сheckTriangle(double x, double y, double r) {
        return x >= 0 && x <= r && y >= 0 && y <= r / 2 && (y <= -x / 2 + r / 2);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setR(int r) {
        this.r = r;
    }

}
