package G1.SCP.envolturas.SAC.service;

import G1.SCP.envolturas.SAC.model.Rol;
import G1.SCP.envolturas.SAC.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements IRolService{

    @Autowired
    private RolRepository rolRepository;

    @Override
    public void addRol(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public List<Rol> listRols() {
        return rolRepository.findAll();
    }

    @Override
    public Rol getRolById(Integer id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRolById(Integer id) {
        rolRepository.deleteById(id);
    }
}
