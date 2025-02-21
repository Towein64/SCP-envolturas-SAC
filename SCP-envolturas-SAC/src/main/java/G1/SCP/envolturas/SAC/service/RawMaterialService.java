package G1.SCP.envolturas.SAC.service;

import G1.SCP.envolturas.SAC.model.RawMaterial;
import G1.SCP.envolturas.SAC.repository.RawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialService implements IRawMaterialService{

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    @Override
    public List<RawMaterial> listRawMaterial() {
        return rawMaterialRepository.findAll();
    }

    @Override
    public void addRawMaterial(RawMaterial rawMaterial) {
        rawMaterialRepository.save(rawMaterial);
    }

    @Override
    public RawMaterial getRawMaterialById(Integer id) {
        return rawMaterialRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRawMaterialById(Integer id) {
        rawMaterialRepository.deleteById(id);
    }
}
