package entities;

import java.util.Date;

public class ChildBook extends Book{
    public ChildBook() {
    }

    @Override
    public String getClassType() {
        return "ChildBook";
    }

    public ChildBook(String title, String author, String ID, float price, Publisher publisher, Date releaseDate) {
        super(title, author, ID, price, publisher, releaseDate);
    }
}
