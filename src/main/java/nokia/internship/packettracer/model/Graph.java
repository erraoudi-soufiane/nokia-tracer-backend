package nokia.internship.packettracer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;


@Entity
@Table(name = "graphs")
public class Graph {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;
    private String name;

    @OneToMany(mappedBy = "graph", cascade = CascadeType.ALL)
    private List<Node> nodes;
    @OneToMany(mappedBy = "graph", cascade = CascadeType.ALL)
    private List<Edge> edges;

    public Graph() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNodes() {
        return nodes != null ? nodes : Collections.emptyList();
    }


    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }


    @Override
    public String toString() {
        return "Graph{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}
