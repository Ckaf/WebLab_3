import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean(name = "message", eager = true)
@RequestScoped
public class Result implements Serializable {

}
