package item;


import base.Item;

public class Book extends Item {
    protected String nameOfBook;
    public Book(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }
    Book() {
    }
}
