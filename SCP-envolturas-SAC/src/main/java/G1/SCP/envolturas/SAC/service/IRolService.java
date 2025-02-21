package G1.SCP.envolturas.SAC.service;

import G1.SCP.envolturas.SAC.model.Rol;

import java.util.List;

public interface IRolService {
    public void addRol(Rol rol);
    public List<Rol> listRols();
    public Rol getRolById(Integer id);
    public void deleteRolById(Integer id);
}
