package nokia.internship.packettracer.service;
import nokia.internship.packettracer.model.Graph;
import nokia.internship.packettracer.model.User;
import nokia.internship.packettracer.repo.GraphRepo;
import nokia.internship.packettracer.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphService {

    private final GraphRepo graphRepo;
    private final UserRepo userRepository;
    private UserService userService;

    @Autowired
    public GraphService(GraphRepo graphRepo, UserRepo userRepository, UserService userService) {
        this.graphRepo = graphRepo;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public List<Graph> findAllGraphs(Long id){
        return graphRepo.findAllById(id);
    }

    public Graph addGraph(Graph graph, Integer userId) {
        User user = userService.findUser(userId);
        System.out.println("your user is " + user );
        graph.setUser(user);
        System.out.println("the graph is : " + graph );
        return graphRepo.save(graph);
    }
}
