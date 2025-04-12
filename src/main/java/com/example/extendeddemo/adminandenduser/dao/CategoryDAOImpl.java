package com.example.extendeddemo.adminandenduser.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.extendeddemo.admin.model.Categories;
import com.example.extendeddemo.persist.database.Database;

public class CategoryDAOImpl implements ICategoryDAO {

	/* Fields: */
	private Database db = Database.getInstance();
	private static Logger logger = LogManager.getLogger(CategoryDAOImpl.class);

	/* Methods: */

	@Override
	public Categories get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categories> getAll() { // Note how the generic T from the generic IDAO is now replaced with specific
										// implementation based on the specific DAO interface requirement
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Categories object) {
		// TODO Auto-generated method stub
		System.out.println("Starting save/insert sql statement:");
		// SQL query placeholder to insert Categories object into the database
		String insertCategoriesSql = "INSERT INTO Categories (categoryName, categoryDescription, categoryImageUrl, active, addedOn) VALUES (?, ?, ?, ?, ?)";
		
		try (Connection connection = db.getConnection();
				PreparedStatement ps = connection.prepareStatement(insertCategoriesSql)) { // tryWResource is a try
																							// statement that declares
																							// >= resourexe and the
																							// resource obj must be
																							// closed after the prog is
																							// finished. this
																							// trywResource will close
																							// the obj
																							// work for anything that
																							// extend the autoclosable
																							// the class constructor
																							// already create the db, so
																							// can just call it here
			// Set values
			ps.setString(1, object.getCategoryName());
			ps.setString(2, object.getCategoryDescription());
			ps.setString(3, object.getCategoryImageUrl());
			ps.setInt(4, object.getActive());
			java.sql.Date sqlDate = Date.valueOf(object.getAddedOn()); // Convert java.util.LocalDate to sql date before
																		// setting
			ps.setDate(5, sqlDate);

			// Actual attempt to send to db
			int sucessOrFail = db.executeUpdate(ps);

			if (sucessOrFail == 1) {
				logger.info("Successfully processed " + object + " to db"); // the "object" should call the toString
																			// method ofthe Categories class
			} else {
				logger.info("Error executing CategoryDAOImpl.save ");
			}

		} catch (SQLException e) {
			logger.error("Error executing CategoryDAOImpl.save", e);
		}

	}

	@Override
	public void update(Categories object) {
		// TODO Auto-generated method stub
		System.out.println("Starting update sql statement:");
		// validation to make sure that the category ID exists
		
		// SQL query to update Categories object into the database
		String updateSql = "UPDATE categories SET categoryName = ?, categoryDescription = ?, categoryImageUrl = ?,active = ?, addedOn = ?  WHERE categoryId = ?";
		
		try (Connection connection = db.getConnection();
				PreparedStatement ps = connection.prepareStatement(updateSql)){
			
			// Set parameters for the Categories update
			ps.setString(1, object.getCategoryName());
			ps.setString(2, object.getCategoryDescription());
			ps.setString(3, object.getCategoryImageUrl());
			ps.setInt(4, object.getActive());
			
				// Convert java.util.LocalDate to java.sql.Date
			java.sql.Date sqlDate = Date.valueOf(object.getAddedOn());
			
			ps.setDate(5, sqlDate);
			ps.setInt(6, object.getCategoryId());
			
			
			 db.executeUpdate(ps);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SQL Exception occurred: ");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
