import java.util.List;

public class Main {
    public static void main(String[] args) {
        SongStore ss = new SongStore(3);
        ss.addSong("kgf", "user1");
        ss.addSong("barbie", "user1");
        ss.addSong("oppeneimer", "user1");
        ss.addSong("kgf2", "user1");
        List<String> songs = ss.recentSongs("user1");
        System.out.println(songs);
    }
}