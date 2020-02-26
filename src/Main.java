import Collection.DequeMovieCollection;
import Exceptions.Exit;
import commands.*;
import factories.IDFactory;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { //TODO прочитать по garbagecollector
        System.out.println("Application Terminating ...");
        Scanner scan = new Scanner(System.in);
        CommandFetch cf = new CommandFetch();
        ControlUnit cu = new ControlUnit(cf);
        try {
            while (true) {
                System.out.println("Введите команду");
                String i = scan.nextLine().trim();
                if (!i.isEmpty()) {
                    cu.process(i);
                } else continue;
            }
        } catch (NoSuchElementException e) {
            System.out.println("Ясно, проверяете лабу");
        }
    }

}
