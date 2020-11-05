
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean(name = "MainBean", eager = true)
@ApplicationScoped
public class MainBean implements Serializable {
    int x;
    int y;

    public void SetParam(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println(x);
    }
    public int GetResult(){
        return x;
    }

}
