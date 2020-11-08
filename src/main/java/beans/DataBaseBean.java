package beans;

import database.DataBaseManager;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name = "dataBaseBean", eager = true)
@ApplicationScoped
public class DataBaseBean implements Serializable {

	public DataBaseManager db = new DataBaseManager();

	public void addPoint(double x, double y, double r, String result) {
		db.addPoint(x, y, r, result);
	}
}
