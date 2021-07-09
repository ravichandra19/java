package com.htc.LoadAndUnload.entity;

public class Product 
{
	private int ProductId;
	private String ProductName;
	private double ProductPrice;
	private String ProductType;
	public Product(int productId, String productName, double productPrice, String productType) {
		super();
		ProductId = productId;
		ProductName = productName;
		ProductPrice = productPrice;
		ProductType = productType;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}
	public String getProductType() {
		return ProductType;
	}
	public void setProductType(String productType) {
		ProductType = productType;
	}
	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", ProductPrice=" + ProductPrice
				+ ", ProductType=" + ProductType + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ProductId;
		result = prime * result + ((ProductName == null) ? 0 : ProductName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(ProductPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((ProductType == null) ? 0 : ProductType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (ProductId != other.ProductId)
			return false;
		if (ProductName == null) {
			if (other.ProductName != null)
				return false;
		} else if (!ProductName.equals(other.ProductName))
			return false;
		if (Double.doubleToLongBits(ProductPrice) != Double.doubleToLongBits(other.ProductPrice))
			return false;
		if (ProductType == null) {
			if (other.ProductType != null)
				return false;
		} else if (!ProductType.equals(other.ProductType))
			return false;
		return true;
	}
	
}
