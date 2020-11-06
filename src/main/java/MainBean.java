import lombok.Getter;
import lombok.Setter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean(name = "data", eager = true)
@ApplicationScoped
@Getter
@Setter
public class MainBean implements Serializable {
    int x;
    int y;
    int r;

    public void result(int x, int y, int r) {
    	//DO SOMETHING
    }
}
