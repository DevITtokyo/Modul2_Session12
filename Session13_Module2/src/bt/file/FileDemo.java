//package bt.file;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FileDemo {
//    public static void main(String[] args) {
//        List<Student> listStudent = new ArrayList<>();
//
//    }
//    public static void writeDataToFile(List<Student> listStudent){
//        // 1. Khởi tạo đối tượng file để làm việc với file - tương đối
//        File file = new File("demo.txt");
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            // 2. Khởi tạo đối tượng FileOutputStream từ file - checked exception
//            fos = new FileOutputStream(file);
//            // 3. Khởi tạo dối tượng ObjectInputStream từ fos
//            oos = new ObjectOutputStream(fos);
//
//
//        }catch (FileNotFoundException ex1){
//            System.err.println("File đã tồn tại");
//        }catch (IOException ex2){
//            System.err.println("Lỗi khi ghi dữ liệu ra file");
//        }catch (Exception ex){
//            System.err.println("Xảy ra tro");
//
//        }
//
//    }
//}
