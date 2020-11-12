package Login;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class dangnhap {

    public static void main(String[] args) throws IOException {
        System.out.println("Dang nhap");
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();
        try {

            FileInputStream file = new FileInputStream("C:\\Users\\HP\\Documents\\Login\\" + username + ".txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e);

        }
    }
}
