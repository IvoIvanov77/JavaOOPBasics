package encapsulation.exercise.shopping_spree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Shop {

    private Map<String, Person> buyers;
    private Map<String, Product> products;

    Shop() {
        this.buyers = new LinkedHashMap<>();
        this.products = new HashMap<>();
    }

    void prepareShopping(String persons, String products){
        populateBuyers(persons);
        populateProducts(products);
    }

    void doShopping(String line){
        String[] input = line.split(" ");
        String buyerName = input[0];
        String productName = input[1];
        Person person = this.buyers.get(buyerName);
        Product product = this.products.get(productName);

        if(person.hasEnoughMoneyToBay(product)){
            person.addProduct(product);
            System.out.println(String.format("%s bought %s",
                    person.getName(), product.getProductName()));
        }else {
            System.out.println(String.format("%s can't afford %s",
                    person.getName(), product.getProductName()));
        }
    }

    private void populateBuyers(String line){
        String[] input = line.split(";");
        for (String s : input) {
            String[] keyValue = s.split("=");
            String name = keyValue[0];
            double money = Double.parseDouble(keyValue[1]);
            Person person = new Person(name, money);
            this.buyers.put(person.getName(), person);
        }
    }

    private void populateProducts(String line){
        String[] input = line.split(";");
        for (String s : input) {
            String[] keyValue = s.split("=");
            String name = keyValue[0];
            double price = Double.parseDouble(keyValue[1]);
            Product product = new Product(name, price);
            this.products.put(product.getProductName(), product);
        }
    }

    void print(){
        this.buyers.values().forEach(System.out::println);
    }
}
