package com.StockManagement.Stock.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StockManagement.Stock.Dao.StockDao;
import com.StockManagement.Stock.Model.StockMgt;



@Service
public class StockServiceImplement implements StockService {
	@Autowired
	private StockDao stockdao;
		
	
	//Get the List of All Stocks	
	@Override
	public List<StockMgt> getStocks() 
	{
		return stockdao.findAll();	
	}
	
	
	@Override
	public StockMgt getStock(int stockId) 
	{
	    return stockdao.findById(stockId).orElse(null);
	}

	
	//Add Stock to the StockManagement
	@Override
	public StockMgt addStock(StockMgt stock) 
	{
		stockdao.save(stock);
		return stock;
	}
	
	@Override
	public List<StockMgt> addStocks(List<StockMgt> stocks) {
	    List<StockMgt> savedStocks = stockdao.saveAll(stocks);
	    return savedStocks;
	}
	
}
