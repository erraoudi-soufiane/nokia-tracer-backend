package nokia.internship.packettracer.controller;

import nokia.internship.packettracer.model.Graph;
import nokia.internship.packettracer.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/graph")
public class GraphResource {
    private final GraphService graphService;

    @Autowired
    public GraphResource(GraphService graphService) {
        this.graphService = graphService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Graph>> getAllGraphs() {
        List<Graph> graphs = graphService.findAllGraphs();
        return new ResponseEntity<>(graphs, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Graph> addGraph(@RequestBody Graph graph) {
        Graph newGraph = graphService.addGraph(graph);
        return new ResponseEntity<>(graph, HttpStatus.CREATED);
    }
}
