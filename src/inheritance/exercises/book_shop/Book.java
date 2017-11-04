package inheritance.exercises.book_shop;

public class Book {

    private String title;
    private String author;
    private Double price;

    Book(String author, String title, Double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    Double getPrice() {
        return price;
    }

    private void setTitle(String title) {
        if(title.length() < 3){
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    private void setAuthor(String author) {
        String[] names = author.split(" ");
        if(names.length > 1 && Character.isDigit(names[1].charAt(0))){
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    private void setPrice(Double price) {
        if(price <= 3){
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "Type: %s\n" +
                "Title: %s\n" +
                "Author: %s\n" +
                "Price: %.1f\n",
                this.getClass().getSimpleName(),
                this.title,
                this.author,
                this.getPrice()
        );
    }

}
