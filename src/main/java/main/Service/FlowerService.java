package main.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.Entity.Flower;
import main.Repository.FlowerRepository;

@Service
public class FlowerService {

	
	@Autowired
	private FlowerRepository flowerRepository;
	
	
	
	public Flower saveFlower(Flower flower) {
        flower.setAddedDate(LocalDate.now());
        return flowerRepository.save(flower);
    }

    public List<Flower> getAllFlowers() {
        return flowerRepository.findAll();
    }
    
    
    
    public Flower getFlowerById(Long id) {
        return flowerRepository.findById(id).orElse(null);
    }

    public void deleteFlower(Long id) {
        flowerRepository.deleteById(id);
    }
    
    
    
    public long getTotalFlowers() {
        return flowerRepository.count();
    }

    public int getTotalStock() {
        Integer total = flowerRepository.getTotalStock();
        return total == null ? 0 : total;
    }

    public long getLowStockCount() {
        return flowerRepository.getLowStockCount();
    }

    public double getInventoryValue() {

        return flowerRepository.findAll()
                .stream()
                .mapToDouble(f -> f.getPrice() * f.getStockQuantity())
                .sum();
    }
    
    public List<Flower> searchFlowers(String flowerName) {
        return flowerRepository.findByFlowerNameContainingIgnoreCase(flowerName);
    }
    
    
    
    
    public void updateStock(Long id, Integer quantity) {

        Flower flower = flowerRepository.findById(id).orElse(null);

        if (flower != null) {

            flower.setStockQuantity(quantity);

            flowerRepository.save(flower);
        }
    }
}
