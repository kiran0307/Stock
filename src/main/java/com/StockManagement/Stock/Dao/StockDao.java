package com.StockManagement.Stock.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StockManagement.Stock.Model.StockMgt;

public interface StockDao extends JpaRepository <StockMgt, Integer>{

}
