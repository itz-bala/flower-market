package main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.Entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
