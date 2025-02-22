package G1.SCP.envolturas.SAC.repository;

import G1.SCP.envolturas.SAC.model.ProductionOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductionOrderRepository extends JpaRepository<ProductionOrder,Integer> {
    @Query("SELECT p.orderNumber FROM ProductionOrder p ORDER BY p.id DESC LIMIT 1")
    String findLastWorkOrderNumber();

    @Modifying
    @Query("DELETE FROM ProductionOrder p WHERE p.orderNumber = :orderNumber")
    void deleteByOrderNumber(@Param("orderNumber") String orderNumber);

    ProductionOrder findByOrderNumber(String orderNumber);
}
