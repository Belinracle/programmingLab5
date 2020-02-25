package commands;

import Collection.DequeMovieCollection;
import Parsers.Parser;
import Parsers.ParserCSV;
import ReadWriteSome.FileWorker;
import ReadWriteSome.ReadWrite;
import factories.IDFactory;

import java.io.IOException;

public class ControlUnit {
    Command add;
    Command show;
    Command help;
    CommandFetch cf;
    DequeMovieCollection dmc;
    InfoCommand info;
    UpdateIDCommand update;
    SaveCommand save;
    ParserCSV parserCSV;
    LoadCommand load;
    public ControlUnit(CommandFetch cf) throws IOException { //TODO передавать реализацию CommandFetch
        this.cf = cf;
        dmc= new DequeMovieCollection();
        EnterReader enterReader = new EnterReader();
        FileWorker fw= new FileWorker("C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//Save.txt",dmc);
        add = new AddCommand(dmc, cf, enterReader);
        show = new ShowCommand(dmc, cf);
        info= new InfoCommand(cf,dmc);
        help = new HelpCommand(cf, "C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//SomeFile.txt");
        update = new UpdateIDCommand(cf,dmc);
        IDFactory idFac = new IDFactory("C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//IdContainer.txt");
        save= new SaveCommand(fw,idFac,cf);
        load = new LoadCommand(cf, fw ,dmc);
    }
    public void process(String str) throws IOException {
        try{
            cf.run(str);
        }catch (NullPointerException e){
            System.out.println("Неизвестная команда, для получения информации по доступным командам, введите Help");
        }
    }
}
