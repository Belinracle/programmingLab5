package collection;

import java.util.Scanner;

public class UserInterface {
    private Scanner scan;
    public UserInterface(){
        Scanner scan = new Scanner(System.in);
    }
    public Scanner read(){
        return scan;
    }
}