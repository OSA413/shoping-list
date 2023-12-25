package osa413.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import osa413.recipes.entity.Product;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

}