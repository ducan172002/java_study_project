package Test;

import com.google.gson.Gson;
import java.io.*;
import java.text.ParseException;
import java.util.Scanner;

public class File1 {
    public static void main(String[] args) throws IOException , ParseException {


        System.out.println("Chon 1 de dang ky" + "\nChon 2 de dang nhap");

        Scanner scr = new Scanner(System.in);
        Test.File1.dangnhap dp = new Test.File1.dangnhap();
        Gson gson = new Gson();

        while(10 < 20) {
            System.out.print("Ban chon: ");
            int banchon = scr.nextInt();

            if (banchon == 1) {
                Scanner sc = new Scanner(System.in);

                System.out.println("Dang ky");
                FileOutputStream file = null;

                System.out.print("Username: ");
                dp.username = sc.nextLine();

                System.out.print("Password: ");
                dp.password = sc.nextLine();

                System.out.print("Repassword: ");
                String Repassword = sc.nextLine();
                while (10 < 20) {

                    if(Repassword.equals(dp.password)){
                        break;
                    }
                    if(Repassword != dp.password) {
                        System.out.print("Repassword: ");
                        Repassword = sc.nextLine();
                    }

                }
                System.out.print("Email: ");
                dp.email = sc.nextLine();

                String register = gson.toJson(dp);

                try {
                    file = new FileOutputStream("C:\\Users\\HP\\IdeaProjects\\TestJSON\\src\\" + dp.username + ".json");
                    DataOutputStream dos = new DataOutputStream(file);
                    dos.writeBytes(register);
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    file.close();
                }

                System.out.println("Dang ki thanh cong");

            } else if (banchon == 2){
                System.out.println("Dang nhap");
                Scanner sc = new Scanner(System.in);


                System.out.print("Username: ");
                dp.username = sc.nextLine();

                System.out.print("Password: ");
                dp.password = sc.nextLine();


                try {

                    BufferedReader br = new BufferedReader(
                            new FileReader("C:\\Users\\HP\\IdeaProjects\\TestJSON\\src\\" + dp.username + ".json"));

                    Test.File1.dangnhap countryObj = gson.fromJson(br, Test.File1.dangnhap.class);
                    String user = countryObj.getUsername();
                    String pass = countryObj.getPassword();
                    if(dp.username.equals(user) && dp.password.equals(pass))
                    {
                        System.out.println("Dang nhap thanh cong");
                    }
                    else if(dp.username.equals(user) && dp.password != pass)
                    {
                        System.out.println("Sai mat khau");
                    }

                }
                catch (FileNotFoundException ex) {
                    ex.printStackTrace();

                }

            } else if (banchon == 0)
            {
                System.out.println("Ket thuc chuong trinh");
                break;
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
