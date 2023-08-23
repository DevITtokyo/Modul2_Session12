package ra.entity;

import color.Color;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Book implements Serializable {
    public String bookId;
    public String bookName;
    public float price;

    // Constructor
    public Book() {
    }

    public Book(String bookId, String bookName, float price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
    }

    // Getter and Setter
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // Method
    public void inputData(Scanner scanner, List<Book> bookList) {
        System.out.print("Nhập vào mã sách : ");
        boolean checkId = true;
        do {
            this.bookId = scanner.nextLine();
            boolean isExistId = false;
                for (Book book : bookList) {
                    if (book.bookId.equals(this.bookId)) {
                        isExistId = true;
                        break;
                    }
                }
                if (isExistId) {
                    System.err.println(Color.YELLOW_BACKGROUND + Color.BLACK_BOLD+"Mã sách đã tồn tại vui lòng nhập lại : ");
                }else {
                    break;
                }
        }while (checkId);
        System.out.print("Nhập vào tên sách : ");
        boolean checkName = true;
        do {
            this.bookName = scanner.nextLine();
            boolean isExistName = false;
                for (Book book : bookList) {
                    if (book.bookName.equals(this.bookName)){
                        isExistName = true;
                        break;
                    }
                }
                if (isExistName){
                    System.err.println(Color.YELLOW_BACKGROUND + Color.BLACK_BOLD+"Tên sách đã tồn tại vui lòng nhập lại : ");
                }else {
                    break;
                }
        }while (checkName);
        System.out.print("Nhập vào giá sách : ");
        boolean checkPrice = true;
        do {
            try {
                this.price = Float.parseFloat(scanner.nextLine());
                if (this.price > 0) {
                    break;
                } else {
                    System.err.println("Giá sách phải lớn hơn 0");
                }
            } catch (NumberFormatException nfe) {
                System.err.println(Color.RED_BACKGROUND + Color.BLACK_BOLD +"Dữ liệu không phải là số, vui lòng nhập lại");
            } catch (Exception ex) {
                System.err.println("Đã xảy ra lỗi trong quá trình xử lý vui lòng nhập lại");
            }
        } while (checkPrice);
    }

    @Override
    public String toString() {
        return Color.GREEN_BOLD + "Mã sách: " + Color.PURPLE + bookId + Color.WHITE_BOLD + " -- " + Color.GREEN_BOLD + " Tên sách : " +Color.PURPLE+ bookName +Color.WHITE_BOLD + " -- " + Color.GREEN_BOLD + " Giá: " + Color.PURPLE + price;
    }
}
