package inheritance.exercises.online_radio_database.exceptios;

public class InvalidSongNameException extends InvalidSongException{

    public InvalidSongNameException() {
        super("Song name should be between 3 and 30 symbols.");
    }
}
