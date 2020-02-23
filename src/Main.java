import Collection.DequeMovieCollection;
import commands.AddCommand;
import commands.Command;
import commands.CommandFetch;
import commands.ShowCommand;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        CommandFetch cf = new CommandFetch();
        DequeMovieCollection dequeMovieCollection = new DequeMovieCollection();
        Command add = new AddCommand(dequeMovieCollection, cf);
        Command show = new ShowCommand(dequeMovieCollection, cf);
        while(true) {
            try {
                System.out.println("введите команду");
                cf.run(scan.nextLine());
            }
            catch(NullPointerException e) {
                System.out.println("Нет такой команды, для просмотра информации о доступных командах введите Info");
            }
        }
    }
}
