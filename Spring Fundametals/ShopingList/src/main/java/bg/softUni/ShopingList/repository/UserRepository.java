package bg.softUni.ShopingList.repository;

import bg.softUni.ShopingList.model.entity.User;
import bg.softUni.ShopingList.model.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}
