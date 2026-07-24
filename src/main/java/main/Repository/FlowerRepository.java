package main.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import main.Entity.Flower;

public interface FlowerRepository  extends JpaRepository<Flower,Long>{
	
	
	 @Query("SELECT COALESCE(SUM(f.stockQuantity),0) FROM Flower f")
	    Integer getTotalStock();

	    @Query("SELECT COUNT(f) FROM Flower f WHERE f.stockQuantity <= f.minimumStock")
	    Long getLowStockCount();
	    
	    
	    List<Flower> findByFlowerNameContainingIgnoreCase(String flowerName);
	    
	    
	    
	    Optional<Flower> findByFlowerName(String flowerName);

}
