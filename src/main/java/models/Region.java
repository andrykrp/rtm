package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Region {
    @Id
    @SequenceGenerator(name = "SEQ_REGION", sequenceName = "SEQ_REGION", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REGION")
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region parentRegion;
    @OneToMany(mappedBy = "parentRegion", cascade = CascadeType.ALL)
    private List<Region> childRegions;

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

    public Region getParentRegion() {
        return parentRegion;
    }

    public void setParentRegion(Region parentRegion) {
        this.parentRegion = parentRegion;
    }

    public List<Region> getChildRegions() {
        return childRegions;
    }

    public void setChildRegions(List<Region> childRegions) {
        this.childRegions = childRegions;
    }
}
