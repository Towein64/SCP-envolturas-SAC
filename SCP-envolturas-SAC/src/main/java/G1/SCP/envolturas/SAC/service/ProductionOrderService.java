package G1.SCP.envolturas.SAC.service;

import G1.SCP.envolturas.SAC.model.Product;
import G1.SCP.envolturas.SAC.model.ProductionOrder;
import G1.SCP.envolturas.SAC.repository.ProductRepository;
import G1.SCP.envolturas.SAC.repository.ProductionOrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductionOrderService implements IProductionOrder{

    @Autowired
    private ProductionOrderRepository productionOrderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductionOrder> listProductionOrder() {
        return productionOrderRepository.findAll();
    }

    @Override
    public void addProductionOrder(ProductionOrder productionOrder) {
        productionOrderRepository.save(productionOrder);
    }

    @Override
    public ProductionOrder productionOrderGetbyId(Integer id) {
        return productionOrderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProductionOrderById(Integer id) {
        productionOrderRepository.deleteById(id);
    }

    @Override
    public ProductionOrder createProductionOrder(Integer productId, String companyName, LocalDate deliveryDate) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("Producto no encontrado"));

        String lastOrderNumber = productionOrderRepository.findLastWorkOrderNumber();
        String newOrderNumber = generateNextOrder(lastOrderNumber);

        ProductionOrder order = new ProductionOrder();
        order.setCompanyName(companyName);
        order.setLeadTime(deliveryDate);
        order.setOrderNumber(newOrderNumber);
        order.setProduct(product);
        return productionOrderRepository.save(order);
    }

    @Override
    public String generateNextOrder(String lastOrderNumber) {
        if(lastOrderNumber==null){
            return "PO-0001";
        }
        int lastNumber = Integer.parseInt(lastOrderNumber.replace("PO-",""));
        int nextNumber = lastNumber + 1;
        return String.format("PO-%04d",nextNumber);
    }

    @Override
    @Transactional
    public void deleteByOrderNumber(String orderNumber) {
        productionOrderRepository.deleteByOrderNumber(orderNumber);
    }

    @Override
    public ProductionOrder productionOrderGetByOrderNumber(String orderNumber) {
        return productionOrderRepository.findByOrderNumber(orderNumber);
    }

    @Override
    public void updateProductionOrder(ProductionOrder productionOrder) {
        productionOrderRepository.save(productionOrder);
    }
}
