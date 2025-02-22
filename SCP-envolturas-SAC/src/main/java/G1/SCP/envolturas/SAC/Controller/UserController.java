package G1.SCP.envolturas.SAC.Controller;

import G1.SCP.envolturas.SAC.model.*;
import G1.SCP.envolturas.SAC.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/")
    public String Home(HttpSession session){
        User user =(User)session.getAttribute("userlogged");
        if(user==null){
            return "redirect:/login";
        }
        return "Home";
    }

    @GetMapping("/create")
    public String prueba(Model model,ProductionOrder productionOrder,HttpSession session){
        User user =(User)session.getAttribute("userlogged");
        if(user==null){
            return "redirect:/login";
        }
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
    public String listProductionOrder(Model model,Product product,HttpSession session){
        User user =(User)session.getAttribute("userlogged");
        if(user==null){
            return "redirect:/login";
        }
        model.addAttribute("productionOrders",productionOrderService.listProductionOrder());
        return "ListProductionOrder";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "LoginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session,Model model){
        System.out.println(user.toString());
        Optional<User> userFounded = userService.findByEmail(user.getEmail());
        var pass = user.getPwd();
        if(userFounded.isPresent()){
            System.out.println(userFounded.get());
            if (userFounded.get().getPwd().equals(pass)){
                session.setAttribute("userlogged",userFounded.get());
                System.out.println("Success");
                    return"redirect:/";
            }else {
                System.out.println("Invalid Pass");
                model.addAttribute("error","Invalid Pass");
            }
        }else {
            System.out.println("User Not Found");
            model.addAttribute("error","Usuario no encontrado");
        }
        return "LoginForm";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        productionOrderService.deleteProductionOrderById(id);
        return ResponseEntity.ok("Orden eliminada");
    }

    @GetMapping("/editForm/{id}")
    public String editOrderForm(@PathVariable Integer id, Model model,HttpSession session) {
        User user =(User)session.getAttribute("userlogged");
        if(user==null){
            return "redirect:/login";
        }
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

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
