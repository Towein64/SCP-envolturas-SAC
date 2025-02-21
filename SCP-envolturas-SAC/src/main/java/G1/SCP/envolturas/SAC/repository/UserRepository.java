package G1.SCP.envolturas.SAC.repository;

import G1.SCP.envolturas.SAC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
