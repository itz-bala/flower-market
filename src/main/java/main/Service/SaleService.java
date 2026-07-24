package main.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.Entity.Flower;
import main.Entity.Sale;
import main.Repository.FlowerRepository;
import main.Repository.SaleRepository;

@Service
public class SaleService {
	
	
	@Autowired
    private SaleRepository saleRepository;
	
	@Autowired
	private FlowerRepository flowerRepository;

	public Sale saveSale(Sale sale) {

	    Flower flower = flowerRepository
	            .findByFlowerName(sale.getFlowerName())
	            .orElseThrow(() -> new RuntimeException("Flower Not Found"));

	    if (flower.getStockQuantity() < sale.getQuantity()) {

	        throw new RuntimeException("Insufficient Stock");

	    }

	    sale.setPrice(flower.getPrice());

	    sale.setTotalAmount(flower.getPrice() * sale.getQuantity());

	    sale.setSaleDate(LocalDate.now());

	    flower.setStockQuantity(
	            flower.getStockQuantity() - sale.getQuantity());

	    flowerRepository.save(flower);

	    return saleRepository.save(sale);

	}


    public List<Sale> getAllSales(){

        return saleRepository.findAll();

    }
    
    
    
    public Double getTotalRevenue() {
        return saleRepository.getTotalRevenue();
    }

    public Long getTotalSales() {
        return saleRepository.count();
    }


}
