import entities.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Publisher publiser1 = new Publisher("0001", "NXB Tre", "161B Lý Chính Thắng, Phường Võ Thị Sáu, Quận 3 , TP. Hồ Chí Minh", "(84.028) 38437450");
        Publisher publiser2 = new Publisher("0002", "NXB Giao Duc", "Số 81 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội", "024.38220801");
        List<Publisher> listPublishers = new ArrayList<>();
        listPublishers.add(publiser1);
        listPublishers.add(publiser2);
        List<Book> listBooks = new ArrayList<>();

        listBooks.add(new ChildBook("Sách giáo khoa cho trẻ nhỏ tập 1", "Bùi Quang Cơ", "001", 30000f, publiser2, new Date()));
        listBooks.add(new ChildBook("Sách giáo khoa cho trẻ nhỏ tập 2", "Nguyễn Kim", "002", 32000f, publiser1, new Date()));
        listBooks.add(new ChildBook("Sách giáo khoa cho trẻ nhỏ tập 3", "Bùi Quang Cơ", "003", 35000f, publiser2, new Date()));

        System.out.println("Chào mừng bạn đến với nhà sách UIT");
        System.out.println("**********************************");
        System.out.println("1. Nhập sách mới");
        System.out.println("2. Xem danh sách sách đang có trong thư viện");
        System.out.println("3. Thống kê sách theo tác giả");
        System.out.println("4. Thống kê theo nhà xuất bản");
        System.out.println("5. Thống kê theo thể loại");
        System.out.println("6. Thoát chương trình");
        Scanner dataIn = new Scanner(System.in);
        while (true) {
            System.out.println("Xin mời bạn chọn chức năng: ");
            int choice;
            try {
                choice = Integer.parseInt(dataIn.nextLine());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai chức năng vui lòng nhập lại");
                continue;
            }
            switch (choice) {
                case 1:
                    //method nhap sach
                    inputBook(listBooks, listPublishers);
                    break;
                case 2:
                    listDisplay(listBooks);
                    break;
                case 3:
                    //method thong ke tac gia
                    getAuthors(listBooks);
                    break;
                case 4:
                    //method thong ke nha xuat ban
                    getPublishers(listBooks);
                    break;
                case 5:
                    //method thong ke theo the loai
                    getTypes(listBooks);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Chức năng bạn nhập hiện không tồn tại");
                    break;
            }
            System.out.println("Bạn có muốn tiếp tục");
            System.out.println("1. Có   2. Không");
            try {
                choice = Integer.parseInt(dataIn.nextLine());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai chức năng vui lòng nhập lại");
                continue;
            }
            if (choice == 1) {
                continue;
            } else {
                System.exit(0);
            }
        }
    }

    public static void listDisplay(List<Book> listBooks) {
        for (Book book : listBooks) {
            System.out.println(book.toString());
        }
    }

    public static void inputBook(List<Book> listBooks, List<Publisher> listPublishers) {
        Scanner dataIn = new Scanner(System.in);
        System.out.println("Loại sách muốn nhập");
        System.out.println("1. Sách thiếu nhi");
        System.out.println("2. Truyện tranh");
        System.out.println("3. Sách văn học");
        System.out.println("4. Tiểu thuyết");

        while (true) {
            int choice;
            try {
                choice = Integer.parseInt(dataIn.nextLine());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai số");
                continue;
            }
            Book bookInput = new Book() {
                public String getClassType() {
                    return "Book";
                }
            };
            switch (choice) {
                case 1:
                    bookInput = new ChildBook();
                    break;
                case 2:
                    bookInput = new Comic();
                    break;
                case 3:
                    bookInput = new Literature();
                    break;
                case 4:
                    bookInput = new Novel();
                    break;
            }
            System.out.println("Nhập ID sách");
            String ID = dataIn.nextLine();
            System.out.println("Nhập tên sách");
            String title = dataIn.nextLine();
            System.out.println("Nhập tác giả");
            String author = dataIn.nextLine();
            System.out.println("Nhập giá tiền");
            float price;
            try {
                price = Float.parseFloat(dataIn.nextLine());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai chức năng vui lòng nhập lại");
                continue;
            }
            System.out.println("Chọn nhà xuất bản");
            for (Publisher publisher : listPublishers) {
                System.out.println(publisher.toString());
            }
            try {
                choice = Integer.parseInt(dataIn.nextLine());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai số");
                continue;
            }
            Publisher publisher = listPublishers.get(choice - 1);
            String pattern = "dd/MM/yyyy";
            System.out.println("Nhập ngày xuất bản");
            System.out.println("Ngày nhập có dạng " + pattern);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date dateRelease;
            try {
                dateRelease = simpleDateFormat.parse(dataIn.nextLine());
            } catch (Exception e) {
                System.out.println("Ngày định dạng sai mời nhập lại");
                continue;
            }
            bookInput.setID(ID);
            bookInput.setTitle(title);
            bookInput.setAuthor(author);
            bookInput.setPrice(price);
            bookInput.setPublisher(publisher);
            bookInput.setReleaseDate(dateRelease);
            listBooks.add(bookInput);
            System.out.println("Xong!!!");
            System.out.println("Bạn muốn tiếp tục nhập sách hay trở về màn hình chính");
            System.out.println("1. Có   2. Trờ về trang chính");
            try {
                choice = Integer.parseInt(dataIn.nextLine());
            } catch (Exception e) {
                System.out.println("Bạn nhập sai số");
            }
            if (choice == 1) {
                continue;
            } else {
                return;
            }
        }
    }

    public static void getAuthors(List<Book> listBooks) {
        HashMap<String, Integer> listAuthors = new HashMap<String, Integer>();
        for (Book book : listBooks) {
            if (listAuthors.containsKey(book.getAuthor())) {
                listAuthors.put(book.getAuthor(), listAuthors.get(book.getAuthor()) + 1);
            } else {
                listAuthors.put(book.getAuthor(), 1);
            }
        }
        for (String author : listAuthors.keySet()) {
            System.out.println(author + " có số sách là: " + listAuthors.get(author));
        }
    }

    public static void getPublishers(List<Book> listBooks) {
        HashMap<String, Integer> listPublishers = new HashMap<String, Integer>();
        for (Book book : listBooks) {
            if (listPublishers.containsKey(book.getPublisher().getName())) {
                listPublishers.put(book.getPublisher().getName(), listPublishers.get(book.getPublisher().getName()) + 1);
            } else {
                listPublishers.put(book.getPublisher().getName(), 1);
            }
        }
        for (String publisher : listPublishers.keySet()) {
            System.out.println(publisher + " có số sách là: " + listPublishers.get(publisher));
        }
    }

    public static void getTypes(List<Book> listBooks) {
        HashMap<String, Integer> listTypes = new HashMap<String, Integer>();
        for (Book book : listBooks) {
            if (listTypes.get(book.getClassType()) == null) {
                listTypes.put(book.getClassType(), 1);
            } else {
                listTypes.put(book.getClassType(), listTypes.get(book.getClassType()) + 1);
            }
        }

        for (String publisher : listTypes.keySet()) {
            System.out.println(publisher + " có số sách là: " + listTypes.get(publisher));
        }
    }
}