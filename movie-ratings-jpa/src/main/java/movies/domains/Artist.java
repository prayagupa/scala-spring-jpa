package movies.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by prayagupd
 * on 6/23/15.
 */

@Entity
public class Artist {

    @Id
    @GeneratedValue
    private Integer artistId;

    @Column
    private String name;

    @Column(nullable = true)
    private Integer rating;

    @Column(nullable = true)
    private String movieCharacter;

    public Artist(){}

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getMovieCharacter() {
        return movieCharacter;
    }

    public void setMovieCharacter(String movieCharacter) {
        this.movieCharacter = movieCharacter;
    }
}
