package inheritance.exercises.online_radio_database.exceptios;

public class InvalidSongException extends RuntimeException{

    public InvalidSongException(String message) {
        super(message);
    }
}
