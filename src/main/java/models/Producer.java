package models;

import javax.persistence.*;

@Entity
@Table
public class Producer {
    @Id
    @SequenceGenerator(name = "SEQ_PRODUCER", sequenceName = "SEQ_PRODUCER", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCER")
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
