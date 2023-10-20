package nokia.internship.packettracer.repo;

import nokia.internship.packettracer.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepo extends JpaRepository<Node, Integer> {
}
