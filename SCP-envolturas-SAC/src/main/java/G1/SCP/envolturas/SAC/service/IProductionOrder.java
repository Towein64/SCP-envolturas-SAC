package G1.SCP.envolturas.SAC.service;

import G1.SCP.envolturas.SAC.model.ProductionOrder;

import java.time.LocalDate;
import java.util.List;

public interface IProductionOrder {
    public List<ProductionOrder> listProductionOrder();
    public void addProductionOrder(ProductionOrder productionOrder);
    public ProductionOrder productionOrderGetbyId(Integer id);
    public void deleteProductionOrderById(Integer id);
    public ProductionOrder createProductionOrder(Integer productId, String companyName, LocalDate deliveryDate);
    public String generateNextOrder(String lastOrderNumber);
    public void deleteByOrderNumber(String orderNumber);
    public ProductionOrder productionOrderGetByOrderNumber(String orderNumber);
    public void updateProductionOrder(ProductionOrder productionOrder);
}
