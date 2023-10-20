package nokia.internship.packettracer.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "edges")
public class Edge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String idInGraph;

    // Define the relationship between Edge and Graph entities.
    @ManyToOne
    @JoinColumn(name = "graph_id")
    @JsonIgnore
    private Graph graph;

    @ManyToOne
    @JoinColumn(name = "source_node_id")
    private Node sourceNode;

    @ManyToOne
    @JoinColumn(name = "target_node_id")
    private Node targetNode;

    public Edge() {
    }


    public Node getTargetNode() {
        return targetNode;
    }

    public void setTargetNode(Node targetNode) {
        this.targetNode = targetNode;
    }

    public Node getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(Node sourceNode) {
        this.sourceNode = sourceNode;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdInGraph() {
        return idInGraph;
    }

    public void setIdInGraph(String idInGraph) {
        this.idInGraph = idInGraph;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "id=" + id +
                ", idInGraph='" + idInGraph + '\'' +
                ", sourceNode=" + sourceNode +
                ", targetNode=" + targetNode +
                '}';
    }
}
