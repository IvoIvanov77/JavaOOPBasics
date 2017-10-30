package encapsulation.exercise.shopping_spree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person {

    private String name;
    private double money;
    private List<Product> bag;

    public Person(String name, double money) {
        this.bag = new ArrayList<>();
        this.setName(name);
        this.setMoney(money);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    void addProduct(Product product){
        this.bag.add(product);
        this.money -= product.getPrice();
    }

    boolean hasEnoughMoneyToBay(Product product){
        return this.getMoney() >= product.getPrice();
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.getName(),
                this.bag.isEmpty() ? "Nothing bought" :
                this.bag.stream()
                        .map(Product::getProductName)
                        .collect(Collectors.joining(", ")));

    }
}
