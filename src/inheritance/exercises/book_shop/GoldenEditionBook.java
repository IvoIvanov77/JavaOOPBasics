package inheritance.exercises.book_shop;

class GoldenEditionBook extends Book {

    GoldenEditionBook(String title, String author, Double price) {
        super(title, author, price);
    }

    @Override
    Double getPrice() {
        return super.getPrice() * 1.3;
    }
}
