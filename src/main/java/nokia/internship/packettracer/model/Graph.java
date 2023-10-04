package nokia.internship.packettracer.model;

import jakarta.persistence.*;

import java.util.ArrayList;


@Entity
@Table(name = "graphs")
public class Graph {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "graph", cascade = CascadeType.ALL)
    private ArrayList<Node> nodes;

    @OneToMany(mappedBy = "graph", cascade = CascadeType.ALL)
    private ArrayList<Edge> edges;

    public Graph(){}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }


}
