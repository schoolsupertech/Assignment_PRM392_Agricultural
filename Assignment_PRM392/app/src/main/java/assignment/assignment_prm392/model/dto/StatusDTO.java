package assignment.assignment_prm392.model.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "status", schema = "Agricultural")
public class StatusDTO {
    private Long id;

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public StatusDTO setId(Long id) {
        this.id = id;
        return this;
    }

    @Column(name = "name", length = 100)
    public String getName() {
        return name;
    }

    public StatusDTO setName(String name) {
        this.name = name;
        return this;
    }

}