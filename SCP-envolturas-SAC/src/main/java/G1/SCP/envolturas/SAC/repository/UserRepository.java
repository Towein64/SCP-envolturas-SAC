package G1.SCP.envolturas.SAC.repository;

import G1.SCP.envolturas.SAC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
}
