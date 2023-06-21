package demo.vn.btdemo.repository;

import demo.vn.btdemo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity ,Integer> {

}
