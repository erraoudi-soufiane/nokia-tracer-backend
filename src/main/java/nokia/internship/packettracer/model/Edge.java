package nokia.internship.packettracer.model;


import jakarta.persistence.*;

@Entity
@Table(name = "edges")
public class Edge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define the relationship between Edge and Graph entities.
    @ManyToOne
    @JoinColumn(name = "graph_id")
    private Graph graph;

    @ManyToOne
    @JoinColumn(name = "source_node_id")
    private Node sourceNode;

    @ManyToOne
    @JoinColumn(name = "target_node_id")
    private Node targetNode;

    public Edge() {

    }
}
