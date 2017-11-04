package inheritance.exercises.online_radio_database.exceptios;

public class InvalidSongSecondsException extends InvalidSongLengthException{

    public InvalidSongSecondsException() {
        super("Song seconds should be between 0 and 59.");
    }
}
