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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    @OneToMany(mappedBy = "graph", cascade = CascadeType.ALL)
    private List<Node> nodes;

    @OneToMany(mappedBy = "graph", cascade = CascadeType.ALL)
    private List<Edge> edges;


    public Graph(User user, String name, List<Node> nodes, List<Edge> edges){
        this.user = user;
        this.name = name;
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
        this.user = user;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
