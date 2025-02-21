package G1.SCP.envolturas.SAC.service;

import G1.SCP.envolturas.SAC.model.ProductRawMaterial;
import G1.SCP.envolturas.SAC.repository.ProductRawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRawMaterialService implements IProductRawMaterial {

    @Autowired
    private ProductRawMaterialRepository productRawMaterialRepository;

    @Override
    public List<ProductRawMaterial> listProductRawMaterial() {
        return productRawMaterialRepository.findAll();
    }

    @Override
    public void addProductRawMaterial(ProductRawMaterial productRawMaterial) {
        productRawMaterialRepository.save(productRawMaterial);
    }

    @Override
    public ProductRawMaterial getProductRawMaterialById(Integer id) {
        return productRawMaterialRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProductRawMaterialById(Integer id) {
        productRawMaterialRepository.deleteById(id);
    }
}
