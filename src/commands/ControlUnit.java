package commands;

import Collection.DequeMovieCollection;
import Parsers.Parser;
import Parsers.ParserCSV;
import ReadWriteSome.FileWorker;
import ReadWriteSome.ReadWrite;
import factories.IDFactory;

import java.io.IOException;

public class ControlUnit {
    private Command add;
    private Command show;
    private Command help;
    private CommandFetch cf;
    private DequeMovieCollection dmc;
    private InfoCommand info;
    private UpdateIDCommand update;
    private SaveCommand save;
    ParserCSV parserCSV;
    private LoadCommand load;
    private RemoveFirstComman remFirst;
    private Remove_by_idCommand removeID;
    public ControlUnit(CommandFetch cf) throws IOException { //TODO передавать реализацию CommandFetch
        this.cf = cf;
        dmc= new DequeMovieCollection();
        FileWorker fw= new FileWorker("C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//Save.txt",dmc);
        add = new AddCommand(dmc, cf);
        show = new ShowCommand(dmc, cf);
        info= new InfoCommand(cf,dmc);
        help = new HelpCommand(cf, "C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//SomeFile.txt");
        update = new UpdateIDCommand(cf,dmc);
        IDFactory idFac = new IDFactory("C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//IdContainer.txt");
        save= new SaveCommand(fw,idFac,cf);
        load = new LoadCommand(cf, fw ,dmc);
        remFirst = new RemoveFirstComman(dmc,cf);
        removeID=new Remove_by_idCommand(cf,dmc);
    }
    public void process(String str) throws IOException {
        try{
            cf.run(str);
        }catch (NullPointerException e){
            System.out.println("Неизвестная команда, для получения информации по доступным командам, введите Help");
        }
    }
}
