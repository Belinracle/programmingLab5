package commands;

import Collection.DequeMovieCollection;
import WorkWithFile.ID;
import WorkWithFile.Parser;
import factories.IDFactory;

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
    ID  id;
    SaveCommand save;
    Parser parser;
    LoadCommand load;
    public ControlUnit(CommandFetch cf) throws IOException { //TODO передавать реализацию CommandFetch
        this.cf = cf;
        id= new ID("C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//IdContainer.txt");
        dmc= new DequeMovieCollection();
        parser = new Parser("C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//Save.txt",dmc);
        add = new AddCommand(dmc, cf);
        show = new ShowCommand(dmc, cf);
        info= new InfoCommand(cf,dmc);
        help = new HelpCommand(cf, "C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//SomeFile.txt");
        update = new UpdateIDCommand(cf,dmc);
        save= new SaveCommand(parser,id,cf,dmc);
        load = new LoadCommand(cf,parser,dmc);
        IDFactory idFac = new IDFactory(id);
    }
    public void process(String str) throws IOException {
        try{
            cf.run(str);
        }catch (NullPointerException e){
            System.out.println("Неизвестная команда, для получения информации по доступным командам, введите Help");
        }
    }
}
