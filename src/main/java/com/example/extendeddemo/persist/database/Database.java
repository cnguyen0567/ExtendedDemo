package com.example.extendeddemo.persist.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Database {
	/* Field - note field is static so that can use it from the class and not requiring
	 * to instanitize (can't since we made it private)
	 * */
	private static final Logger logger = LogManager.getLogger(Database.class);
	private static final Database db = new Database();
	private Connection connection;
	
	/* Constructor - note that it's private to avoid people making multiple (unneeded) connection*/
	private Database() {
		
	}
	
	public static Database getInstance() { //Using this to instantanitize instead
		return db;
	}
	
	private void connect() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "root";
			String password = "Database=2025";
			String url = "jdbc:mysql://localhost/estore";
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			logger.error("Issue with DB", e); //Replace e.printstacktrace with logger
			//e.printStackTrace();
			
		}
	}
	
	public Connection getConnection() {
		if(connection == null || isClosed(connection)) {
			connect();
		}
		return connection;
	}
	
	private boolean isClosed(Connection connection) {
		try {
			return connection == null || connection.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}
	
	public int executeUpdate(PreparedStatement preparedStatement) {
		int result = 0;
		try {
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("Error when executing Database.executeUpdate ", e);
		}
		return result;
	}
}
