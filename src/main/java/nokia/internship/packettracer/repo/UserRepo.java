package nokia.internship.packettracer.repo;

import nokia.internship.packettracer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserById(Integer id);
}
