package edu.wctc.stockpurchase.service;

import edu.wctc.stockpurchase.entity.StockPurchase;
import edu.wctc.stockpurchase.repo.StockPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockPurchaseService {
    private final StockPurchaseRepository stockPurchaseRepository;

    @Autowired
    public StockPurchaseService(StockPurchaseRepository stockPurchaseRepository) {
        this.stockPurchaseRepository = stockPurchaseRepository;
    }

    public List<StockPurchase> findAll() {
        List<StockPurchase> list = new ArrayList<>();
        stockPurchaseRepository.findAll().forEach(list::add);
        return list;
    }
}
