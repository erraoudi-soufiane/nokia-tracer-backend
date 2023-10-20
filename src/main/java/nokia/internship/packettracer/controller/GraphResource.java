package nokia.internship.packettracer.controller;

import nokia.internship.packettracer.model.Graph;
import nokia.internship.packettracer.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user/{id}/graph")
public class GraphResource {
    private final GraphService graphService;

    @Autowired
    public GraphResource(GraphService graphService) {
        this.graphService = graphService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Graph>> getAllGraphs(@PathVariable("id") Integer id) {
        List<Graph> graphs = graphService.findAllGraphs(id);
        return new ResponseEntity<>(graphs, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Graph> addGraph(@RequestBody Graph graph, @PathVariable("id") Integer id) {
        Graph newGraph = graphService.addGraph(graph, id);
        return new ResponseEntity<>(graph, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Graph> updateGraph(@RequestBody Graph updatedGraph, @PathVariable("id") Integer id){
        Graph newUpdatedGraph = graphService.updateGraph(updatedGraph,id);
        return new ResponseEntity<>(updatedGraph,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{graphId}")
    public void deleteGraph(@PathVariable Integer graphId) {
        graphService.deleteGraph(graphId);
    }

}
