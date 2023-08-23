package ra.run;

import color.Color;
import ra.entity.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookImp {
    static List<Book> bookList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            System.out.println("************** Menu **************");
            System.out.println("1. Nhập thông tin các sách");
            System.out.println("2. In thông tin các sách ra file demo.txt");
            System.out.println("3. Đọc file demo.txt và in ra các sách có giá trong khoảng 10000 đến 20000");
            System.out.println("4. Thoát");
            try {
                System.out.println("Sự lựa chọn của bạn là : ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        inputBook();
                        break;
                    case 2:
                        BookImp.writeBookToFile(bookList);
                        break;
                    case 3:
                        // in ra các sách có giá trong khoảng 10000 đến 20000
                        List<Book> bookListRead = readBookFromFile();
                        if (bookListRead != null){
                            for (Book book : bookListRead) {
                                if (book.getPrice()>=10000 && book.getPrice()<=20000){
                                    System.out.println(book);
                                }
                            }
                        }else {
                            System.err.println("File chưa có dữ liệu");
                        }
                        readBookFromFile();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-4");
                }
            }catch (NumberFormatException nfe){
                System.err.println("Dữ liệu không phải là số, vui lòng nhập lại");
            }catch (Exception ex){

            }
        }while (true);
    }
    // 1. Nhập thông tin các sách
    public static void inputBook(){
        try {
            System.out.print("Nhập vào số sách muốn nhập : ");
            int numBook = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numBook; i++) {
                Book book = new Book();
                book.inputData(scanner, bookList);
                bookList.add(book);
                System.out.println("----------------------------");
            }
        }catch (NumberFormatException nfe) {
            System.err.println("Dữ liệu không phải là số, vui lòng nhập lại");
        }catch (Exception ex){
            System.err.println("Đã xảy ra lỗi trong quá trình xử lý vui lòng nhập lại");
        }
    }
    // 2. In thông tin các sách ra file demo.txt"
    public static void writeBookToFile(List<Book> bookList){
        //2.1. Khởi tạo đối tượng file để làm việc với file - tương đối
        File file = new File("demo.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            //2.2. Khởi tạo đối tượng FileOutputStream từ file - Checked Excetion
            fos = new FileOutputStream(file);
            //2.3. Khởi tạo đối tượng ObjectOutputStream từ fos
            oos = new ObjectOutputStream(fos);
            //2.4. Sử dụng writeObject để ghi object ra file
            oos.writeObject(bookList);
            //2.5. Đẩy dữ liệu từ Stream xuống file
            oos.flush();
        }catch (FileNotFoundException ex1){
            System.err.println("File không tồn tại");
        }catch (IOException ex2){
            System.err.println("Lỗi khi ghi dữ liệu ra file");
        }catch (Exception ex){
            System.err.println("Xảy ra lỗi trong quá trình ghi dữ liệu ra file");
        }finally {
            // 2.6.Đóng các stream
            try {
                if (oos != null){
                    oos.close();
                }
                if (fos != null){
                    fos.close();
                }
            }catch (IOException ex1){
                System.err.println("Xảy ra lỗi khi đóng các stream");
            }catch (Exception ex2){
                System.err.println("Xảy ra lỗi trong quá trình đóng các stream");
            }
        }
    }
    // 3.Đọc file demo.txt
    public static List<Book> readBookFromFile(){
        //1. Khởi tạo đối tượng File
        File file = new File("demo.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Book> bookListRead = null;
        try {
            //2. Khởi tạo đối tượng FileInputStream
            fis = new FileInputStream(file);
            //3. Khởi tạo đối tượng ObjectInputStream
            ois = new ObjectInputStream(fis);
            //4. Đọc dữ liệu object từ file (readObject())
            bookListRead = (List<Book>) ois.readObject();
        }catch (FileNotFoundException ex1){
            System.err.println("File không tồn tại");
        }catch (IOException ex2){
            System.err.println("Lỗi khi đọc dữ liệu từ file");
        }catch (Exception ex){
            System.err.println("Xảy ra lỗi trong quá trình đọc dữ liệu từ file");
        }finally {
            //6. Đóng các stream
            try {
                if (fis != null){
                    fis.close();
                }
                if (ois != null){
                    ois.close();
                }
            }catch (IOException ex1){
                System.err.println("Xảy ra lỗi khi đóng các stream");
            }catch (Exception ex){
                System.err.println("Xảy ra lỗi trong quá trình đóng các stream");
            }
        }
        return bookListRead;
    }
}
