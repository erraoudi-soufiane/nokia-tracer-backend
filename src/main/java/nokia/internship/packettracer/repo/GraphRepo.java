package nokia.internship.packettracer.repo;

import nokia.internship.packettracer.model.Graph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GraphRepo extends JpaRepository<Graph, Long> {
    List<Graph> findAllById(Long id);
}
