package nokia.internship.packettracer.service;
import nokia.internship.packettracer.model.Graph;
import nokia.internship.packettracer.model.User;
import nokia.internship.packettracer.repo.GraphRepo;
import nokia.internship.packettracer.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nokia.internship.packettracer.exception.UserNotFoundException;

import java.util.List;

@Service
public class GraphService {

    private final GraphRepo graphRepo;
    private final UserRepo userRepository;

    @Autowired
    public GraphService(GraphRepo graphRepo, UserRepo userRepository) {
        this.graphRepo = graphRepo;
        this.userRepository = userRepository;
    }

    public List<Graph> findAllGraphs(Long id){
        return graphRepo.findAllById(id);
    }

    public Graph addGraph(Graph graph, Integer userId) {
        return graphRepo.save(graph);
    }
}
