import Collection.DequeMovieCollection;
import commands.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { //TODO прочитать по garbagecollector
        Scanner scan = new Scanner(System.in);
        ControlUnit cu = new ControlUnit();
        ArrayDeque<String> deq=new ArrayDeque<>();
        deq.addLast("1");
        deq.addLast("2");
        System.out.println(deq.getFirst());
        System.out.println(deq.getLast());
        while (true) {
            System.out.println("Введите команду");
            String i = scan.nextLine();
            cu.process(i);
        }

    }
}
