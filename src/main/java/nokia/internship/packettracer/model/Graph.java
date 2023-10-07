package nokia.internship.packettracer.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "graphs")
public class Graph {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "graph", cascade = CascadeType.ALL)
    private List<Node> nodes;

    @OneToMany(mappedBy = "graph", cascade = CascadeType.ALL)
    private List<Edge> edges;


    public Graph(User user, List<Node> nodes, List<Edge> edges){
        this.user = user;
        this.nodes = nodes;
        this.edges = edges;
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
    }

    @Override
    public String toString() {
        return "Graph{" +
                "id=" + id +
                ", nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}
