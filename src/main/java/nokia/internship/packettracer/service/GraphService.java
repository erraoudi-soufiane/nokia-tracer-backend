package nokia.internship.packettracer.service;
import nokia.internship.packettracer.exception.GraphNotFoundException;
import nokia.internship.packettracer.model.Edge;
import nokia.internship.packettracer.model.Graph;
import nokia.internship.packettracer.model.Node;
import nokia.internship.packettracer.model.User;
import nokia.internship.packettracer.repo.EdgeRepo;
import nokia.internship.packettracer.repo.GraphRepo;
import nokia.internship.packettracer.repo.NodeRepo;
import nokia.internship.packettracer.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GraphService {

    private final GraphRepo graphRepo;
    private final NodeRepo nodeRepo;
    private final EdgeRepo edgeRepo;
    private UserService userService;

    @Autowired
    public GraphService(GraphRepo graphRepo, UserRepo userRepository, NodeRepo nodeRepo, EdgeRepo edgeRepo, UserService userService) {
        this.graphRepo = graphRepo;
        this.nodeRepo = nodeRepo;
        this.edgeRepo = edgeRepo;
        this.userService = userService;
    }

    public List<Graph> findAllGraphs(Integer id){
        return graphRepo.findAllById(id);
    }

    public Graph addGraph(Graph graph, Integer userId) {

        Graph firstGraph = new Graph();
        firstGraph.setId(graph.getId());
        firstGraph.setName(graph.getName());

        User user = userService.findUser(userId);
        firstGraph.setUser(user);

        // saving the graph without nodes and edges to get the graph-id
        graphRepo.save(firstGraph);

        // saving the nodes
        List<Node> nodes =new ArrayList<>();
        graph.getNodes().forEach(node -> {
            node.setGraph(firstGraph);
            nodes.add(node);
        });
        firstGraph.setNodes(nodes);
        graphRepo.save(firstGraph);

        // saving the edges
        Graph secondGraph = graphRepo.findById(firstGraph.getId()).orElseThrow(
                () -> new GraphNotFoundException("Graph by Id " + firstGraph.getId()+ "Not found")
        ); // retrieving the saved graph

        List<Edge> edges =new ArrayList<>();
        graph.getEdges().forEach(edge -> {
            edge.setGraph(firstGraph);
            secondGraph.getNodes().forEach(node -> {
                if (node.getIdInGraph()==edge.getSourceNode().getIdInGraph()) edge.setSourceNode(node);
            });
            secondGraph.getNodes().forEach(node -> {
                if (node.getIdInGraph()==edge.getTargetNode().getIdInGraph()) edge.setSourceNode(node);
            });
            edges.add(edge);
        });
        secondGraph.setEdges(edges);
        Graph thirdGraph =graphRepo.save(secondGraph);

        // retrieving the edges for test
        Graph DBgraph = graphRepo.findById(firstGraph.getId()).orElseThrow(
                () -> new GraphNotFoundException("Graph by Id " + firstGraph.getId()+ "Not found")
        );
        System.out.println(DBgraph);
        return thirdGraph;

    }


    public Graph updateGraph(Graph updatedGraph, Integer id) {

        Graph existingGraph = graphRepo.findById(updatedGraph.getId()).orElseThrow(() -> new GraphNotFoundException("Graph by Id " + updatedGraph.getId() + "Not found"));
        existingGraph.setName(updatedGraph.getName());
        existingGraph.getNodes().clear();
        existingGraph.getEdges().clear();
        updatedGraph.getEdges().forEach(edge -> {edge.setGraph(existingGraph);existingGraph.getEdges().add(edge);});
        updatedGraph.getNodes().forEach(node -> {node.setGraph(existingGraph);existingGraph.getNodes().add(node);});

;
        return graphRepo.save(existingGraph);
    }

    public void deleteGraph(Integer graphId) {
        graphRepo.deleteById(graphId);
    }
}
