import javax.faces.annotation.ManagedProperty;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;


@ManagedBean(name = "DbBean", eager = true)
@ApplicationScoped
public class DB implements Serializable {
    public void pushInDB(double x, double y, double r, boolean result) {
        System.out.println(x);
    }
}
