package nokia.internship.packettracer.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "nodes")
public class Node {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int idInGraph;
    private int x; // x-coordinate
    private int y; // y-coordinate
    private String name;
    private String url;
    @ManyToOne
    @JoinColumn(name = "graph_id")
    @JsonIgnore
    private Graph graph;

    public Node(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public int getIdInGraph() {
        return idInGraph;
    }

    public void setIdInGraph(int idInGraph) {
        this.idInGraph = idInGraph;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", idInGraph=" + idInGraph +
                ", x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
