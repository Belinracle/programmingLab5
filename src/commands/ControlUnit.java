package commands;

import Collection.DequeMovieCollection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class ControlUnit {
    Command add;
    Command show;
    Command help;
    CommandFetch cf;
    DequeMovieCollection dmc;
    InfoCommand info;
    UpdateIDCommand update;
    public ControlUnit() throws IOException { //TODO передавать реализацию CommandFetch
        cf = new CommandFetch();
        dmc= new DequeMovieCollection();
        add = new AddCommand(dmc, cf);
        show = new ShowCommand(dmc, cf);
        info= new InfoCommand(cf,dmc);
        help = new HelpCommand(cf, "C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//SomeFile.txt");
        update = new UpdateIDCommand(cf,dmc);
    }
    public void process(String str) throws IOException {
        try{
            cf.run(str);
        }catch (NullPointerException e){
            System.out.println("Неизвестная команда, для получения информации по доступным командам, введите Help");
        }
    }
}
