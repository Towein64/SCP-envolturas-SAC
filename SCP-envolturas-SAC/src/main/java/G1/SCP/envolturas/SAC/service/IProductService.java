package G1.SCP.envolturas.SAC.service;


import G1.SCP.envolturas.SAC.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> listProduct();
    public void addProduct(Product product);
    public Product getProductById(Integer id);
    public void deleteProductById(Integer id);
}
