package main.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Sale {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String customerName;

	    private String customerPhone;

	    private String flowerName;

	    private Double price;

	    private Integer quantity;

	    private Double totalAmount;

	    private LocalDate saleDate;


}
