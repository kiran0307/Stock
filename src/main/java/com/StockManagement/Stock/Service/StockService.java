package com.StockManagement.Stock.Service;

import java.util.List;

import com.StockManagement.Stock.Model.StockMgt;

public interface StockService {
	
	public List<StockMgt> getStocks();
	public StockMgt getStock(int stockId);
	public StockMgt addStock(StockMgt stock);
	public List<StockMgt> addStocks(List<StockMgt> stocks);
//	public StockMgt updateStock(StockMgt stock);
//	public String deleteStock(int stockId);
}
