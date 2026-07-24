package main.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Flower {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String flowerName;

	    private String category;

	    private Double price;

	    private Integer stockQuantity;
	    
	    private Integer minimumStock;

	    private String supplier;

	    private LocalDate addedDate;

}
