package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import oracle.jdbc.*;

@Getter
@Setter
@AllArgsConstructor
public class PointQ {
	private double x;
	private double y;
	private double r;
	private String result;
}
