package nokia.internship.packettracer.repo;

import nokia.internship.packettracer.model.Graph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraphRepo extends JpaRepository<Graph, Long> {
}
