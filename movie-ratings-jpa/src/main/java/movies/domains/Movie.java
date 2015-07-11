package movies.domains;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by prayagupd
 * on 6/23/15.
 */

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = true)
    private String comment;

    @Column(nullable = true)
    private Integer rating;

    @Column(nullable = true)
    private String cover;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="movieArtists", joinColumns = { @JoinColumn(name = "id")}, inverseJoinColumns = { @JoinColumn(name = "artistId") })
    private Set<Artist> artists = new HashSet<>();

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    public void addArtist(Artist bradPitt) {
        this.artists.add(bradPitt);
    }
}
