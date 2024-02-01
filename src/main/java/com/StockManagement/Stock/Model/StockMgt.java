package com.StockManagement.Stock.Model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import lombok.Data;



@Entity
public class StockMgt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stock_id")
    private int stockId;
    private int typeId;
    private int productId;
    private String typeName;
    private String productName;
    private int productPrice;
    private int stockCountReceived;
    private int currentStockCount; //we will get this value from StoreManagement
    
    
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getStockCountReceived() {
		return stockCountReceived;
	}
	public void setStockCountReceived(int stockCountReceived) {
		this.stockCountReceived = stockCountReceived;
	}
	public int getCurrentStockCount() {
		return currentStockCount;
	}
	public void setCurrentStockCount(int currentStockCount) {
		this.currentStockCount = currentStockCount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(stockCountReceived, currentStockCount, productId, productName, productPrice, stockId,
				typeId, typeName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockMgt other = (StockMgt) obj;
		return stockCountReceived == other.stockCountReceived && currentStockCount == other.currentStockCount
				&& productId == other.productId && Objects.equals(productName, other.productName)
				&& productPrice == other.productPrice && stockId == other.stockId && typeId == other.typeId
				&& Objects.equals(typeName, other.typeName);
	}
	public StockMgt(int stockId, int typeId, int productId, String typeName, String productName, int productPrice,
			int stockCountReceived, int currentStockCount) {
		super();
		this.stockId = stockId;
		this.typeId = typeId;
		this.productId = productId;
		this.typeName = typeName;
		this.productName = productName;
		this.productPrice = productPrice;
		this.stockCountReceived = stockCountReceived;
		this.currentStockCount = currentStockCount;
	}
	
	
	public StockMgt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
