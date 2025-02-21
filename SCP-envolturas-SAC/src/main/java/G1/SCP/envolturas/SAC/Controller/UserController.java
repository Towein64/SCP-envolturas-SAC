package G1.SCP.envolturas.SAC.Controller;

import G1.SCP.envolturas.SAC.model.ProductRawMaterial;
import G1.SCP.envolturas.SAC.model.Rol;
import G1.SCP.envolturas.SAC.model.User;
import G1.SCP.envolturas.SAC.service.ProductRawMaterialService;
import G1.SCP.envolturas.SAC.service.RolService;
import G1.SCP.envolturas.SAC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RolService rolService;

    @Autowired
    private ProductRawMaterialService productRawMaterialService;

    @GetMapping("/")
    public List<ProductRawMaterial> prueba(){
        return productRawMaterialService.listProductRawMaterial();
    }
}
