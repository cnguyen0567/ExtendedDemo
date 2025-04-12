package com.example.extendeddemo.admin.model;


public class OrderItems {
	/* Fields */
	private Integer orderItemId;
	private Integer orderId;
	private Integer productId;
	private String productTitle;
	private String productDescription;
	private String productCode;
	private String productImg;
	private String productCategory;
	private Integer price;
	private Integer quantity;
	private Integer totalPrice;
	
	/*Constructor*/
	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderItems(Integer orderItemId, Integer orderId, Integer productId, String productTitle,
			String productDescription, String productCode, String productImg, String productCategory, Integer price,
			Integer quantity, Integer totalPrice) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.productId = productId;
		this.productTitle = productTitle;
		this.productDescription = productDescription;
		this.productCode = productCode;
		this.productImg = productImg;
		this.productCategory = productCategory;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	/*Getters and Setters*/

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/* To String */
	@Override
	public String toString() {
		return "OrderItems [orderItemId=" + orderItemId + ", orderId=" + orderId + ", productId=" + productId
				+ ", productTitle=" + productTitle + ", productDescription=" + productDescription + ", productCode="
				+ productCode + ", productImg=" + productImg + ", productCategory=" + productCategory + ", price="
				+ price + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}
	

}
