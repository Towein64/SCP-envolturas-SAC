package G1.SCP.envolturas.SAC.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // ✅ Evita la recursión infinita
public class ProductRawMaterial {
    @EmbeddedId
    ProductRawMaterialId id;
    @ManyToOne
    @MapsId("product")
    @JoinColumn(name = "product_id",nullable = false)
    Product product;

    @ManyToOne
    @MapsId("rawMaterial")
    @JoinColumn(name = "raw_material_id",nullable = false)
    RawMaterial rawMaterial;

    @Column(nullable = false)
    Integer quantity;
}
