import java.util.ArrayList;
import java.util.Scanner;

class Song {
    private String artistName;
    private String songTitle;
    private int yearReleased;
    private int playCount;

    public Song(String artistName, String songTitle, int yearReleased, int playCount) {
        this.artistName = artistName;
        this.songTitle = songTitle;
        this.yearReleased = yearReleased;
        this.playCount = playCount;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public int getPlayCount() {
        return playCount;
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Song> songList = new ArrayList<>();

        while (true) {
            System.out.println("Music Streaming Application");
            System.out.println("1. Add a Song");
            System.out.println("2. Remove a Song");
            System.out.println("3. List All Songs");
            System.out.println("4. Print Songs Over a Given Number of Plays");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Add a new song
                    System.out.print("Enter Artist Name: ");
                    String artistName = scanner.nextLine();
                    System.out.print("Enter Song Title: ");
                    String songTitle = scanner.nextLine();
                    System.out.print("Enter Year Released: ");
                    int yearReleased = scanner.nextInt();
                    System.out.print("Enter Play Count: ");
                    int playCount = scanner.nextInt();

                    Song newSong = new Song(artistName, songTitle, yearReleased, playCount);
                    songList.add(newSong);

                    System.out.println("Song added successfully!");
                    break;

                case 2:
                    // Remove a song (you need to implement this feature)
                    System.out.print("Enter the title or artist name of the song to remove: ");
                    String search = scanner.nextLine();
                    removeSongByTitleOrArtist(songList, search);
                    break;

                case 3:
                    // List all songs
                    listAllSongs(songList);
                    break;

                case 4:
                    // List songs over a given number of plays (you need to implement this feature)
                    System.out.print("Enter the minimum play count: ");
                    int minPlayCount = scanner.nextInt();
                    listSongsOverPlayCount(songList, minPlayCount);
                    break;

                case 5:
                    // Exit the application
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }

    private static void listAllSongs(ArrayList<Song> songList) {
        for (Song song : songList) {
            System.out.println("Artist: " + song.getArtistName());
            System.out.println("Title: " + song.getSongTitle());
            System.out.println("Year Released: " + song.getYearReleased());
            System.out.println("Play Count: " + song.getPlayCount());
            System.out.println();
        }
    }

    // Implement the removeSongByTitleOrArtist method to remove a song by title or artist name
    private static void removeSongByTitleOrArtist(ArrayList<Song> songList, String search) {
    Song songToRemove = null;

    for (Song song : songList) {
        if (song.getSongTitle().equalsIgnoreCase(search) || song.getArtistName().equalsIgnoreCase(search)) {
            songToRemove = song;
            break; // Exit the loop as we've found a matching song
        }
    }

    if (songToRemove != null) {
        songList.remove(songToRemove); // Remove the song
        System.out.println("Song '" + songToRemove.getSongTitle() + "' by " + songToRemove.getArtistName() + " has been removed.");
    } else {
        System.out.println("No songs matching the search string were found.");
    }
}

private static void listSongsOverPlayCount(ArrayList<Song> songList, int minPlayCount) {
    boolean foundSongs = false;

    System.out.println("Songs with more than " + minPlayCount + " plays:");

    for (Song song : songList) {
        if (song.getPlayCount() > minPlayCount) {
            System.out.println("Artist: " + song.getArtistName());
            System.out.println("Title: " + song.getSongTitle());
            System.out.println("Year Released: " + song.getYearReleased());
            System.out.println("Play Count: " + song.getPlayCount());
            System.out.println();
            foundSongs = true;
        }
    }

    if (!foundSongs) {
        System.out.println("No songs with more than " + minPlayCount + " plays found.");
    }
}






}
