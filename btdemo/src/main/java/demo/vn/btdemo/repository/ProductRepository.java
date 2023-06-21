package demo.vn.btdemo.repository;

import demo.vn.btdemo.entities.ProductEntity;
import demo.vn.btdemo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
}
