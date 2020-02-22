package commands;

import Collection.CollectionShellInterface;

public class InfoCommand implements Command {
    private CollectionShellInterface T;
    public InfoCommand(CollectionShellInterface T,CommandFetch cf){
        this.T=T;
        cf.addCommand("Info",this);
    }
    @Override
    public void execute(String str) {
        System.out.println(T.toString());
    }
}
