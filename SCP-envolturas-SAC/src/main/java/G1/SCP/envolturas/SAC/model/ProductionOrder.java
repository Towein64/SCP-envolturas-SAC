package G1.SCP.envolturas.SAC.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String companyName;
    LocalDate leadTime;
    String orderNumber;
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    Product product;
}
