package G1.SCP.envolturas.SAC.service;

import G1.SCP.envolturas.SAC.model.ProductRawMaterial;

import java.util.List;

public interface IProductRawMaterial {
    public List<ProductRawMaterial> listProductRawMaterial();
    public void addProductRawMaterial(ProductRawMaterial productRawMaterial);
    public ProductRawMaterial getProductRawMaterialById(Integer id);
    public void deleteProductRawMaterialById(Integer id);
}
