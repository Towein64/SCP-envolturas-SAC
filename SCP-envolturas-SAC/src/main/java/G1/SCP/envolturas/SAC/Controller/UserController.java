package G1.SCP.envolturas.SAC.Controller;

import G1.SCP.envolturas.SAC.model.*;
import G1.SCP.envolturas.SAC.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RolService rolService;

    @Autowired
    private ProductRawMaterialService productRawMaterialService;

    @Autowired
    private ProductionOrderService productionOrderService;

    @Autowired
    private ProductService productService;

    @GetMapping("/create")
    public String prueba(Model model,ProductionOrder productionOrder){
//        ProductionOrder prueba = new ProductionOrder();
//        prueba.setCompanyName("FisiSAC");
//        prueba.setLeadTime(LocalDate.now());
//        Product product = productService.getProductById(1);
//        prueba.setProduct(product);
//        productionOrderService.addProductionOrder(productionOrderService.createProductionOrder(1,prueba.getCompanyName(),prueba.getLeadTime()));
        model.addAttribute("productionOrder", new ProductionOrder());
        model.addAttribute("products", productService.listProduct());
        return "ProductionOrderForm";
    }

    @PostMapping("/create")
    public String createProductionOrder(@ModelAttribute ProductionOrder productionOrder) {
        productionOrderService.addProductionOrder(productionOrderService.createProductionOrder(productionOrder.getProduct().getId(),productionOrder.getCompanyName(),productionOrder.getLeadTime()));
        return "redirect:/listProductionOrder";
    }

    @GetMapping("/listProductionOrder")
    public String listProductionOrder(Model model,Product product){
        model.addAttribute("productionOrders",productionOrderService.listProductionOrder());
        return "ListProductionOrder";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "LoginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user){
        System.out.println(user.toString());
        User userLog = userService.findByEmail(user.getEmail());
        System.out.println(userLog);
        if(userLog.getPwd().equals(user.getPwd())){
            return "redirect:/listProductionOrder";
        }
        return "s";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        productionOrderService.deleteProductionOrderById(id);
        return ResponseEntity.ok("Orden eliminada");
    }

    @GetMapping("/editForm/{id}")
    public String editOrderForm(@PathVariable Integer id, Model model) {
        ProductionOrder productionOrder = productionOrderService.productionOrderGetbyId(id);
        model.addAttribute("products", productService.listProduct());
        if (productionOrder == null) {
            return "redirect:/error"; // O una página de error personalizada
        }

        model.addAttribute("productionOrder", productionOrder);
        return "EditOrderForm"; // Nombre del HTML de edición en Thymeleaf
    }

    @PostMapping("/editForm")
    public String updateOrder(@ModelAttribute ProductionOrder productionOrder) {
        productionOrderService.updateProductionOrder(productionOrder);
        return "redirect:/listProductionOrder"; // Redirigir a la lista después de actualizar
    }



}
