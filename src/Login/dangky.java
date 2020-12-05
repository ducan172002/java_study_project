package Login;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class dangky {
    public static void main(String[] args) throws IOException {
        int Register = 1;

        System.out.println("Chon 1 de dang ky" + "\nChon 2 de dang nhap");
        System.out.println("Ban chon: ");
        Scanner scr = new Scanner(System.in);
        dangnhap dp = new dangnhap();
        Gson gson = new Gson();

        if (Register == scr.nextInt()) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Dang ky");
            FileOutputStream file = null;

            System.out.print("Username: ");
            dp.username = sc.nextLine();

            System.out.print("Password: ");
            dp.password = sc.nextLine();

            System.out.print("Repassword: ");
            String Repassword = sc.nextLine();
            do{
                System.out.print("Repassword: ");
                Repassword = sc.nextLine();
            }
            while(dp.password == Repassword);

            System.out.print("Email: ");
            dp.email = sc.nextLine();

            String register = gson.toJson(dp);
            System.out.println("Dang ki thanh cong");

            try {
                file = new FileOutputStream("C:\\Users\\HP\\Documents\\Login\\" + dp.username + ".txt");
                DataOutputStream dos = new DataOutputStream(file);
                dos.writeBytes(register);
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

    static class dangnhap {
        String username;
        String password;
        String email;

        public dangnhap() {
        }

        public dangnhap(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
