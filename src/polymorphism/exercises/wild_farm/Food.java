package polymorphism.exercises.wild_farm;

public abstract class Food {

    private Integer quantity;

    public Food(Integer quantity) {
        this.quantity = quantity;
    }

    Integer getQuantity() {
        return quantity;
    }
}
