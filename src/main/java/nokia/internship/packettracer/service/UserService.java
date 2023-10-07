package nokia.internship.packettracer.service;

import nokia.internship.packettracer.exception.UserNotFoundException;
import nokia.internship.packettracer.model.Graph;
import nokia.internship.packettracer.model.User;
import nokia.internship.packettracer.repo.GraphRepo;
import nokia.internship.packettracer.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final GraphRepo graphRepo;

    @Autowired
    public UserService(UserRepo userRepo, GraphRepo graphRepo) {
        this.userRepo = userRepo;
        this.graphRepo = graphRepo;
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User findUser(Integer id) {
        return userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User by Id " + id + "Not found"));
    }
}
