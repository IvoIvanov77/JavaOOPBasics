package encapsulation.exercise.shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Shop shop = new Shop();
        String persons = reader.readLine();
        String products = reader.readLine();
        try{
            shop.prepareShopping(persons, products);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return;
        }


        String line;
        while (true){
            if("end".equalsIgnoreCase(line = reader.readLine())){
                break;
            }

            shop.doShopping(line);
        }

        shop.print();

    }
}
