package G1.SCP.envolturas.SAC.repository;

import G1.SCP.envolturas.SAC.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
