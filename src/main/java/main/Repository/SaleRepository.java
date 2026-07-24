package main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import main.Entity.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long> {
	
	@Query("SELECT COALESCE(SUM(s.totalAmount),0) FROM Sale s")
	Double getTotalRevenue();

	long count();

}
