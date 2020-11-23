package beans;

import database.DataBaseManager;
import lombok.Getter;
import lombok.Setter;
import models.PointQ;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

@ManagedBean(name = "pointsBean")
@ApplicationScoped
@Getter
@Setter
public class PointsBean implements Serializable {
	double x;
	double y;
	double r = 20;
	String script = "location.reload();";
	ArrayList<PointQ> pointsCollection = new ArrayList<>();
	DataBaseManager dataBaseManager = new DataBaseManager();


	public void submit() {
		dataBaseManager.addPoint(x, y, r / 10, getResult(x, y, r / 10));
	}

	public void onload() throws SQLException {
		pointsCollection = dataBaseManager.getCollectionFromDataBase();
	}

	public String getResult(double x, double y ,double r) {
		if (checkRectangle(x, y, r) || checkQuarterCircle(x, y, r) || checkTriangle(x, y, r)) return "Y";
		else return "N";
	}

	private double xx, yy, rr;

	public void submitSuper() {
		dataBaseManager.addPoint(xx, yy, rr, getResult(xx, yy, rr));
	}

	public void clear() {
		dataBaseManager.removeAllPoints();
	}

	private boolean checkRectangle(double x, double y, double r) {
		return x >= -r && x <= 0 && y >= 0 && y <= r / 2;
	}

	private boolean checkQuarterCircle(double x, double y, double r) {
		return (x <= 0) && (y <= 0) && ((x * x + y * y) <= r * r);
	}

	private boolean checkTriangle(double x, double y, double r) {
		return x >= 0 && x <= r && y >= 0 && y <= r / 2 && (y <= -x / 2 + r / 2);
	}
}
