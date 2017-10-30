package encapsulation.exercise.shopping_spree;

public class Product {

    private String productName;
    private double price;

    Product(String productName, double price) {
        this.setProductName(productName);
        this.setPrice(price);
    }

    String getProductName() {
        return productName;
    }

    private void setProductName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.productName = name;
    }

    double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if(price < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getProductName();
    }
}
