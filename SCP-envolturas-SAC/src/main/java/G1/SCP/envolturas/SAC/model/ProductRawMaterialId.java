package G1.SCP.envolturas.SAC.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRawMaterialId {
    private Integer product;
    private Integer rawMaterial;
}
