package inheritance.exercises.online_radio_database;

import inheritance.exercises.online_radio_database.exceptios.InvalidSongException;
import inheritance.exercises.online_radio_database.exceptios.InvalidSongLengthException;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<Song> songList;

    public Playlist() {
        this.songList = new ArrayList<>();
    }

    public void addSong(String line){
        String[] input = line.split(";");
        String artistName = input[0];
        String songName = input[1];
        String[] time = input[2].split(":");

        try {
            int minutes = Integer.parseInt(time[0]);
            int seconds = Integer.parseInt(time[1]);

            Song song = new Song(artistName, songName, minutes, seconds);
            this.songList.add(song);
            System.out.println("Song added.");
        }catch (NumberFormatException nfe){
            System.out.println("Invalid song length.");
        }catch (InvalidSongException ise){
            System.out.println(ise.getMessage());
        }
    }

    private long getTotalSeconds() {
        int total = 0;
        for (Song song : songList) {
            total += song.getMinutes() * 60 + song.getSeconds();
        }
        return total;
    }

    private String totalTimeToString(){
        long totalTime = getTotalSeconds();

        long hours = totalTime / 3600;
        long minutes = (totalTime % 3600) / 60;;
        long seconds = totalTime % 60;


        return String.format("%dh %dm %ds", hours, minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format(
                "Songs added: %d\n" +
                "Playlist length: %s\n",
                this.songList.size(),
                this.totalTimeToString()
        );
    }
}


