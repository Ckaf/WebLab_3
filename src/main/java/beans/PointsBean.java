package beans;

import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;
import java.util.List;


@ManagedBean(name = "pointsBean")
@ApplicationScoped
@Setter
public class PointsBean implements Serializable {
	@Getter
	private int[] x = new int[9];

	@Getter
	private double y;

	@Getter
	private double[] r = new double[12];

	@Getter
	private String result;

	//TODO: finish this

}
