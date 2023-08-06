import java.util.*;
public class SongStore {
    private int capacity;
    private Map<String, List<String>> userSongs;

    //constructor
    public SongStore(int capacity){
        if(capacity>0) {
            this.capacity = capacity;
        }
        else{
            System.out.println("Capacity should be greater than 0");
        }
        this.userSongs = new HashMap<String, List<String>>();
    }

    //method to add song
    public void addSong(String song, String user){
        List<String> songs = userSongs.get(user);
        if(songs == null){
            songs = new ArrayList<String>();
            userSongs.put(user,songs);
        }
        else if(songs.size()>= capacity){
            songs.remove(0);
        }
        songs.add(song);
    }
    public List<String> recentSongs(String user){
        List<String> recSongs = userSongs.get(user);
        if(recSongs == null){
            return new ArrayList<String>();
        }
        return recSongs;
    }

}