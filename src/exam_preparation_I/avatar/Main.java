package exam_preparation_I.avatar;

import exam_preparation_I.avatar.controllers.WarManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        WarManager manager = new WarManager();

        while (true){
            if("quit".equalsIgnoreCase(line = reader.readLine())){
                manager.printWars();
                break;
            }
            manager.run(line);
        }
    }
}
