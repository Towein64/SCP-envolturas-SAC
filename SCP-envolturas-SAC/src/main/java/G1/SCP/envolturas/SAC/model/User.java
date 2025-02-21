package G1.SCP.envolturas.SAC.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(nullable = false)
    String name;
    @Column(unique = true,nullable = false)
    String email;
    String pwd;
    @ManyToOne
    @JoinColumn(name = "rol_id",nullable = false)
    Rol rol;
}
