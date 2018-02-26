package exam_preparation.nfs;

import exam_preparation.nfs.controllers.CarManager;
import exam_preparation.nfs.models.Cars.Car;
import exam_preparation.nfs.models.Cars.PerformanceCar;
import exam_preparation.nfs.models.Cars.ShowCar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ivaylo on 11/5/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CarManager manager = new CarManager();

        String line;

        while (true){
            if("Cops Are Here".equalsIgnoreCase(line = reader.readLine())){
                break;
            }

            manager.run(line);
        }

    }
}
