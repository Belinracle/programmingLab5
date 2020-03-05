package commands;

import Collection.DequeMovieCollection;
import ReadWriteSome.FileWorker;
import factories.IDFactory;

import java.io.IOException;

/**
 * Класс необходимый для создания экземпляров команд и экземпляра интерфейса с которым нужно будет работать
 */
public class ControlUnit {
    private CommandFetch cf;
    public ControlUnit(CommandFetch cf,String path) throws IOException {
        this.cf = cf;
        DequeMovieCollection dmc = new DequeMovieCollection();
        FileWorker fw= new FileWorker(path, dmc);
        Command add = new AddCommand(dmc, cf);
        Command show = new ShowCommand(dmc, cf);
        Command info = new InfoCommand(cf, dmc);
        Command help = new HelpCommand(cf, "SomeFile.txt");
        Command update = new UpdateIDCommand(cf, dmc);
        IDFactory idFac = new IDFactory("IdContainer.txt");
        Command save = new SaveCommand(idFac, cf,dmc);
        Command load = new LoadCommand(cf, fw, dmc);
        Command remFirst = new RemoveFirstComman(dmc, cf);
        Command removeID = new Remove_by_idCommand(cf, dmc);
        Command clear = new ClearCommand(dmc, cf);
        Command exit = new ExitCommand(cf);
        Command addIfMax = new AddIfMaxCommand(dmc,cf);
        Command addIfMin = new AddIfMinCommand(dmc,cf);
        Command removeSc = new RemoveAllByScCommand(dmc,cf);
        Command coutByMpaaRating = new CountByMpaaRating(dmc,cf);
        Command printAsc = new PrintAscendingCommand(dmc,cf);
        Command execute = new ExecuteScriptCommand(cf,dmc);
    }
    public void process(String str) throws IOException {
            cf.run(str,null);
    }
}
