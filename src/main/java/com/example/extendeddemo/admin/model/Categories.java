package com.example.extendeddemo.admin.model;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Categories {
	/* fields */
	private static final Logger Logger = LogManager.getLogger(Categories.class);
	private Integer categoryId;
	private String categoryName;
	private String categoryDescription;
	private String categoryImageUrl;
	private Integer active;
	private LocalDate addedOn;
	
	/* Constructor */
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categories(Integer categoryId, String categoryName, String categoryDescription, String categoryImageUrl,
			Integer active, LocalDate addedOn) {
		super();
		Logger.info("Adding a messaage to the command line");
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryImageUrl = categoryImageUrl;
		this.active = active;
		this.addedOn = addedOn;
	}
	
	
	/* Getters and Setters */
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public String getCategoryImageUrl() {
		return categoryImageUrl;
	}
	public void setCategoryImageUrl(String categoryImageUrl) {
		this.categoryImageUrl = categoryImageUrl;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public LocalDate getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(LocalDate addedOn) {
		this.addedOn = addedOn;
	}
	
	/* To String */ 
	@Override
	public String toString() {
		return "Categories [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", categoryImageUrl=" + categoryImageUrl + ", active=" + active + ", addedOn="
				+ addedOn + "]";
	}
	
	
	
	
}
