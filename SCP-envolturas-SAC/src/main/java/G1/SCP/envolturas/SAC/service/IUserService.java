package G1.SCP.envolturas.SAC.service;

import G1.SCP.envolturas.SAC.model.User;

import java.util.List;

public interface IUserService {
    public void addUser(User user);
    public List<User> listUsers();
    public User getUserById(Integer id);
    public void deleteById(Integer id);
}
