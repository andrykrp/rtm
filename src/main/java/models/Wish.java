package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Wish {
    @Id
    @SequenceGenerator(name = "SEQ_WISH", sequenceName = "SEQ_WISH", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_WISH")
    private Long id;
    private String name;
    private String description;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "WISH_REGION", joinColumns = {
            @JoinColumn(name = "REGION_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "WISH_ID",
                    nullable = false, updatable = false) })
    private List<Region> regions;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "CONSUMER_ID")
    private Consumer consumer;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
}
