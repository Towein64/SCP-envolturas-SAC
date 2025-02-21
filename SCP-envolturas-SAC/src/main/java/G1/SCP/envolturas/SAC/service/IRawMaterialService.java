package G1.SCP.envolturas.SAC.service;

import G1.SCP.envolturas.SAC.model.ProductRawMaterial;
import G1.SCP.envolturas.SAC.model.RawMaterial;

import java.util.List;

public interface IRawMaterialService {
    public List<RawMaterial> listRawMaterial();
    public void addRawMaterial(RawMaterial rawMaterial);
    public RawMaterial getRawMaterialById(Integer id);
    public void deleteRawMaterialById(Integer id);
}
