package nokia.internship.packettracer.model;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Graph> graphs;

    public User(){}
    public User(Integer id, String username, String email, String password, Long id1, String username1, String email1, String password1, List<Graph> graphs) {
        setGraphs(graphs);
        setEmail(email);
        setId(id);
        setPassword(password);
        setUsername(username);
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<Graph> getGraphs() {
        return graphs;
    }

    public void setGraphs(List<Graph> graphs) {
        for(Graph graph : graphs){
            this.addGraph(graph);
        }
    }

    public void addGraph(Graph graph){
        if (graphs == null){
            graphs = new ArrayList<>();
        }
        graphs.add(graph);
        graph.setUser(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +

                '}';
    }
}
