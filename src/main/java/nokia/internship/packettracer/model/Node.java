package nokia.internship.packettracer.model;


import jakarta.persistence.*;


@Entity
@Table(name = "nodes")
public class Node {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int x; // x-coordinate
    private int y; // y-coordinate
    private String name;
    private String url;
    @ManyToOne
    @JoinColumn(name = "graph_id")
    private Graph graph;

    public Node(){}

    public Node(int id, String name, String url, int x, int y) {
        setId(id);
        setName(name);
        setUrl(url);
        setX(x);
        setY(y);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
