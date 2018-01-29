import java.util.List;
import java.util.Optional;

/*
 * Two Solutions are mentioned below
 */
class S28Artists_ThrowExceptionInsteadOfReturningNull {
    //This solution is general and will work with any Java version.
    private final List<Artist> artists;
    public S28Artists_ThrowExceptionInsteadOfReturningNull(List<Artist> artists) {
        this.artists = artists;
    }
    public Artist getArtist(int index) {
        if ((index < 0) || (index >= artists.size()))
            throw new IllegalArgumentException(index + " doesn't correspond to an Artist");
        return artists.get(index);
    }
    public String getArtistName(int index) {
        return getArtist(index).getName(); //Throw exception if invalid index.
    }
}

public class S28Artists {
    //Solution that uses Java 8.
    //For previous Java versions, Guava library can be used. It contains Optional class with equivalent functionality.
    private final List<Artist> artists;
    public S28Artists(List<Artist> artists) {
        this.artists = artists;
    }
    public Optional<Artist> getArtist(int index) {
        if ((index < 0) || (index >= artists.size())) { return Optional.empty(); }
        return Optional.of(artists.get(index));
    }
    public String getArtistName(int index) {
        Optional<Artist> artist = getArtist(index);
        return artist.map(Artist::getName).orElse("unknown");
    }
}
