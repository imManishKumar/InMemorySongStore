import jdk.jfr.StackTrace;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class songTest {
    SongStore store = new SongStore(3);


    @Test
    public void singleUser() {

        store.addSong("Kgf", "User1");
        store.addSong("barbie", "User1");
        store.addSong("kgf2", "User1");
        List<String> songs = store.recentSongs("User1");
        assertEquals(songs, Arrays.asList("Kgf", "barbie", "kgf2"));
    }

    //testcase exceeding capacity
    @Test
    public void singleUserExceedingCapacity() {

        store.addSong("kgf1", "User1");
        store.addSong("barbie", "User1");
        store.addSong("oppenheimer", "User1");
        store.addSong("Top Gun", "User1");
        store.addSong("Marshmallow", "User1");
        List<String> songs = store.recentSongs("User1");
        assertEquals(songs, Arrays.asList("oppenheimer", "Top Gun", "Marshmallow"));
    }

    @Test
    public void multiUser(){
        store.addSong("kgf1","user1");
        store.addSong("Top Gun", "user2");
        List<String> songs = store.recentSongs("user1");
        assertEquals(songs, Arrays.asList("kgf1"));
        //uncomment the below code to get latest song from user2 and comment the above two lines
//        List<String> songs = store.recentSongs("user2");
//        assertEquals(songs, Arrays.asList("Top Gun"));

    }

    @Test
    public void multiUserExceedingCapacity(){
        store.addSong("kgf1", "User1");
        store.addSong("barbie", "User1");
        store.addSong("oppenheimer", "User1");
        store.addSong("Top Gun", "User1");
        store.addSong("Marshmallow", "User1");
        store.addSong("Bahubali", "user2");
        store.addSong("Mission Impossible", "user2");
        store.addSong("James Bond", "user2");
        store.addSong("Top Gun", "user2");
        store.addSong("Baywatch", "user2");
        List<String> songs = store.recentSongs("User1");
        assertEquals(songs, Arrays.asList("oppenheimer", "Top Gun", "Marshmallow"));
        //uncomment the below code to get latest song from user2 and comment the above two lines
//        List<String> songs = store.recentSongs("user2");
//        assertEquals(songs, Arrays.asList("James Bond", "Top Gun", "Baywatch"));

    }


}