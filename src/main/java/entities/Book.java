package entities;

import java.util.Date;

public abstract class Book {
    private String title;
    private String author;
    private String ID;
    private float price;
    private Publisher publisher;
    private Date releaseDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Book() {
    }

    public Book(String title, String author, String ID, float price, Publisher publisher, Date releaseDate) {
        this.title = title;
        this.author = author;
        this.ID = ID;
        this.price = price;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ID='" + ID + '\'' +
                ", price=" + price +
                ", publisher=" + publisher.getName() +
                ", releaseDate=" + releaseDate +
                '}';
    }

    public abstract String getClassType();

    public boolean validate(){
        boolean result = true;
        if (this.ID == ""){
            System.out.println("ID trống");
            result = false;
        }
        if (this.title == ""){
            System.out.println("Tiêu đề trống");
            result = false;
        }
        if (this.author == ""){
            System.out.println("Tác giả trống");
            result = false;
        }
        if (this.price <= 0){
            System.out.println("giá âm hoặc bằng 0");
            result = false;
        }
        return result;
    }
}
