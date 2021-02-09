/*
*
* Modified by xbowery on 9/2/2021
*
*/
package demo;

import java.util.Scanner;
import util.*;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your recipient email: ");
        String email = sc.nextLine();
        System.out.print("Enter your email: ");
        String host_email = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        Emailer.sendEmail(email, host_email, password);
        System.out.println("Email sent!");
    }
}
