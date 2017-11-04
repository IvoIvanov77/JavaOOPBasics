package inheritance.exercises.online_radio_database.exceptios;

public class InvalidSongMinutesException extends InvalidSongLengthException {

    public InvalidSongMinutesException() {
        super("Song minutes should be between 0 and 14.");
    }
}
