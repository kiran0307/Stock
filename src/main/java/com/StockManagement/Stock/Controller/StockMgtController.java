package com.StockManagement.Stock.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StockManagement.Stock.Model.StockMgt;
import com.StockManagement.Stock.Service.StockService;

@RestController
@RequestMapping("/stocks")
public class StockMgtController {

    @Autowired
    private StockService stockService;

    // Get the Stocks
    @GetMapping
    public List<StockMgt> getStocks() {
        try {
            return this.stockService.getStocks();
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            throw new RuntimeException("Error retrieving stocks: " + e.getMessage(), e);
        }
    }

    // Get stock by Id
    @GetMapping("/{stockId}")
    public StockMgt getStock(@PathVariable String stockId) {
        try {
            return this.stockService.getStock(Integer.parseInt(stockId));
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            throw new RuntimeException("Error retrieving stock: " + e.getMessage(), e);
        }
    }

    // Add stock or stocks
    @PostMapping("/add")
    public ResponseEntity<?> addStockOrStocks(@RequestBody List<StockMgt> stocks) {
        try {
            if (stocks.isEmpty()) {
                return ResponseEntity.badRequest().body("Stock list cannot be empty");
            }

            if (stocks.size() == 1) {
                StockMgt addedStock = stockService.addStock(stocks.get(0));
                return ResponseEntity.ok(addedStock);
            } else {
                List<StockMgt> addedStocks = stockService.addStocks(stocks);
                return ResponseEntity.ok(addedStocks);
            }
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error adding stock(s): " + e.getMessage());
        }
    }
}
