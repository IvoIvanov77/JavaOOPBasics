package inheritance.exercises.online_radio_database.exceptios;

public class InvalidSongLengthException extends InvalidSongException{


    public InvalidSongLengthException(String message) {
        super(message);
    }
}
