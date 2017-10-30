package encapsulation.exercise.class_box_data_validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //length, width and height
        double l = Double.parseDouble(reader.readLine());
        double w = Double.parseDouble(reader.readLine());
        double h = Double.parseDouble(reader.readLine());

        try {
            Box box = new Box(l, w, h);
            System.out.println(box);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}
