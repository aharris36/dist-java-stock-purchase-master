package edu.wctc.stockpurchase.controller;

import com.github.fge.jsonpatch.JsonPatch;
import edu.wctc.stockpurchase.entity.StockPurchase;
import edu.wctc.stockpurchase.service.StockPurchaseService;
import edu.wctc.stockpurchase.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stockpurchases")
public class StockPurchaseController {

    private final StockPurchaseService stockPurchaseService;

    @Autowired
    public StockPurchaseController(StockPurchaseService stockPurchaseService) {
        this.stockPurchaseService = stockPurchaseService;
    }

    @GetMapping
    public List<StockPurchase> getAllTeams() {
        return stockPurchaseService.findAll();
    }

    @GetMapping("/{id}")
    public StockPurchase findById(int id) {
        return stockPurchaseService.findById(id);
    }

    @PostMapping
    public StockPurchase createStockPurchase(@RequestBody StockPurchase purchase){
        return stockPurchaseService.createPurchase(purchase);
    }

    @PutMapping
    public StockPurchase editStockPurchase(@RequestBody StockPurchase purchase){
        return stockPurchaseService.updatePurchase(purchase);
    }

    @DeleteMapping("/{id}")
    public String deletePurchase(@PathVariable int purchaseId){
        stockPurchaseService.deletePurchase(purchaseId);
        return "Successfully deleted team with ID " + purchaseId;
    }

    @PatchMapping("/{teamId}")
    public StockPurchase patchTeam(@PathVariable int purchaseId, @RequestBody JsonPatch patch) {
        return stockPurchaseService.patchTeam(purchaseId, patch);
    }

}
