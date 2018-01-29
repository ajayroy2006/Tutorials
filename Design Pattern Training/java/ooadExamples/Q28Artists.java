import java.util.List;
import java.util.Objects;

public class Q28Artists {
    private final List<Artist> artists;
    public Q28Artists(List<Artist> artists) {
        this.artists = artists;
    }
    public Artist getArtist(int index) {
        if ((index < 0) || (index >= artists.size())) return null;
        return artists.get(index);
    }
    public String getArtistName(int index) {
        try {
            return getArtist(index).getName();
        } catch (NullPointerException e) {
            return null;
        }
    }
    //Improve the design of this class
}

class Artist {
    private final String name;
    public Artist(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
