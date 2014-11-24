package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Consumer {
    @Id
    @SequenceGenerator(name = "SEQ_CONSUMER", sequenceName = "SEQ_CONSUMER", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONSUMER")
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "BOOKMARK", joinColumns = {
            @JoinColumn(name = "OFFER_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "CONSUMER_ID",
                    nullable = false, updatable = false) })
    private Set<Offer> bookmarks;

    @OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL)
    private Set<Wish> wishes;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "CONSUMER_CATEGORY", joinColumns = {
            @JoinColumn(name = "CATEGORY_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "CONSUMER_ID",
                    nullable = false, updatable = false) })
    private Set<Category> categories;

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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<Offer> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(Set<Offer> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public Set<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(Set<Wish> wishes) {
        this.wishes = wishes;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
