package nokia.internship.packettracer.service;

import nokia.internship.packettracer.model.Graph;
import nokia.internship.packettracer.repo.GraphRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphService {

    private final GraphRepo graphRepo;
    @Autowired
    public GraphService(GraphRepo graphRepo) {
        this.graphRepo = graphRepo;
    }

    public List<Graph> findAllGraphs(){
        return graphRepo.findAll();
    }

    public Graph addGraph(Graph graph) {
        return graphRepo.save(graph);
    }
}
