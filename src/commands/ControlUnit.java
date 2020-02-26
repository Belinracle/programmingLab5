package commands;

import Collection.DequeMovieCollection;
import Parsers.Parser;
import Parsers.ParserCSV;
import ReadWriteSome.FileWorker;
import ReadWriteSome.ReadWrite;
import factories.IDFactory;

import java.io.IOException;

public class ControlUnit {
    private CommandFetch cf;
    public ControlUnit(CommandFetch cf) throws IOException { //TODO передавать реализацию CommandFetch
        this.cf = cf;
        DequeMovieCollection dmc = new DequeMovieCollection();
        FileWorker fw= new FileWorker("C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//Save.txt", dmc);
        Command add = new AddCommand(dmc, cf);
        Command show = new ShowCommand(dmc, cf);
        Command info = new InfoCommand(cf, dmc);
        Command help = new HelpCommand(cf, "C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//SomeFile.txt");
        Command update = new UpdateIDCommand(cf, dmc);
        IDFactory idFac = new IDFactory("C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//IdContainer.txt");
        Command save = new SaveCommand(fw, idFac, cf);
        Command load = new LoadCommand(cf, fw, dmc);
        Command remFirst = new RemoveFirstComman(dmc, cf);
        Command removeID = new Remove_by_idCommand(cf, dmc);
        Command clear = new ClearCommand(dmc, cf);
        Command exit = new ExitCommand(cf);
        Command addIfMax = new AddIfMaxCommand(dmc,cf);
        Command addIfMin = new AddIfMinCommand(dmc,cf);
        Command removeSc = new RemoveAllByScCommand(dmc,cf);
    }
    public void process(String str) throws IOException {
        try{
            cf.run(str);
        }catch (NullPointerException e){
            System.out.println("Неизвестная команда, для получения информации по доступным командам, введите Help");
        }
    }
}
