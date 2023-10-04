package nokia.internship.packettracer.repo;

import nokia.internship.packettracer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
