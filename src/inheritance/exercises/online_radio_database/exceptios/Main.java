package inheritance.exercises.online_radio_database.exceptios;

import inheritance.exercises.online_radio_database.Playlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Playlist playlist = new Playlist();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            playlist.addSong(reader.readLine());
        }

        System.out.println(playlist);
    }
}
