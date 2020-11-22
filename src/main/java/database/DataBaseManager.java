package database;

import models.PointQ;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseManager {
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orbis";
	private static final String USER = "s283230";
	private static final String PASS = "gvi699";
	private static final String TABLE_NAME = "POINTS";

	static {
		System.out.println("Connection to Oracle JDBC");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver") ;
			System.out.println("Oracle JDBC Driver successfully connected");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle JDBC Driver is not found. Include it in your library path");
			e.printStackTrace();
		}
	}

	private Connection connection;

	public DataBaseManager() {
		this(DB_URL, USER, PASS);
	}

	public DataBaseManager(String dbUrl, String usr, String pass) {
		try {
			connection = DriverManager.getConnection(dbUrl, usr, pass);
		} catch (SQLException e) {
			System.out.println("Connection to database failed " + dbUrl);
			e.printStackTrace();
		}
	}

	public ArrayList<PointQ> getCollectionFromDataBase() throws SQLException {
		PreparedStatement statement = connection.prepareStatement("select * from " + TABLE_NAME);
		ResultSet resultSet = statement.executeQuery();
		ArrayList<PointQ> collection = new ArrayList<>();
		while (resultSet.next()) {
			PointQ point = new PointQ(
					resultSet.getDouble("x"),
					resultSet.getDouble("y"),
					resultSet.getDouble("r"),
					resultSet.getString("res"));
			collection.add(point);
		}
		return collection;
	}

	public void addPoint(double x, double y, double r, String result) {
		try {
			PreparedStatement statement = connection.prepareStatement("insert into " + TABLE_NAME +
					" values (?, ?, ?, ?)");
			statement.setDouble(1, x);
			statement.setDouble(2, y);
			statement.setDouble(3, r);
			statement.setString(4, result);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeAllPoints() {
		try {
			PreparedStatement statement = connection.prepareStatement("delete from " + TABLE_NAME);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
