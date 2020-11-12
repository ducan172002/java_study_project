package Login;

import java.io.*;
import java.util.Scanner;

public class dangky {
    public static void main(String[] args) throws IOException {
        int Register = 1;
        System.out.println("Chon 1 de dang ky" + "\nChon 2 de dang nhap");
        System.out.println("Ban chon: ");
        Scanner scr = new Scanner(System.in);
        if (Register == scr.nextInt()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Dang ky");
            FileOutputStream file = null;


            System.out.println("Username: ");
            String username = sc.nextLine();
            byte[] a = username.getBytes();

            System.out.println("Password: ");
            String password = sc.nextLine();
            byte[] b = password.getBytes();

            System.out.println("Email: ");
            String email = sc.nextLine();
            byte[] c = email.getBytes();

            System.out.println("Dang ki thanh cong");

            try {
                file = new FileOutputStream("C:\\Users\\HP\\Documents\\Login\\" + username + ".txt");
                DataOutputStream dos = new DataOutputStream(file);
                dos.writeBytes("Username: ");
                file.write(a);
                dos.writeBytes("\nPassword: ");
                file.write(b);
                dos.writeBytes("\nEmail: ");
                file.write(c);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                file.close();
            }
        } else {
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

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                System.out.println(ex);

            }
        }
    }
}
