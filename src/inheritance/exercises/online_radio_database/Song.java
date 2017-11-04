package inheritance.exercises.online_radio_database;

import inheritance.exercises.online_radio_database.exceptios.InvalidArtistNameException;
import inheritance.exercises.online_radio_database.exceptios.InvalidSongMinutesException;
import inheritance.exercises.online_radio_database.exceptios.InvalidSongNameException;
import inheritance.exercises.online_radio_database.exceptios.InvalidSongSecondsException;

class Song {

    private String artistName;
    private String songName;
    private Integer minutes;
    private Integer seconds;

    Song(String artistName, String songName, Integer minutes, Integer seconds) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }



    private void setArtistName(String artistName) {
        if(artistName.length() < 3 || artistName.length() > 20){
            throw new InvalidArtistNameException();
        }
        this.artistName = artistName;
    }


    private void setSongName(String songName) {
        if(songName.length() < 3 || songName.length() > 30){
            throw new InvalidSongNameException();
        }
        this.songName = songName;
    }

    Integer getMinutes() {
        return minutes;
    }

    private void setMinutes(Integer minutes) {
        if(minutes < 0 || minutes > 14){
            throw new InvalidSongMinutesException();
        }
        this.minutes = minutes;
    }

    Integer getSeconds() {
        return seconds;
    }

    private void setSeconds(Integer seconds) {
        if(seconds < 0 || seconds > 59){
            throw new InvalidSongSecondsException();
        }
        this.seconds = seconds;
    }


}
