package item;


import base.Item;

public class Book extends Item {
    public int pages;
    public Book(String name, int pages) {
        super(name);
        this.pages = pages;
    }

}
