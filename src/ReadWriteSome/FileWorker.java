package ReadWriteSome;

import java.io.*;
import java.util.Collection;
import Collection.CollectionShellInterface;
import Parsers.Parser;
import Parsers.ParserCSV;

public class FileWorker implements ReadWrite{
    CollectionShellInterface cal;
    BufferedReader reader;
    String path;
    public FileWorker(String path, CollectionShellInterface cal) throws FileNotFoundException {
        this.cal=cal;
        this.path=path;
        File myFile = new File(path);
        reader = new BufferedReader(new FileReader(path));
    }
    @Override
    public void read() throws FileNotFoundException {
        Parser parser = new ParserCSV(cal);
        System.out.println("1");
        parser.deSer(path);
        System.out.println("2");
    }

    @Override
    public void write() throws IOException {
        Parser parser = new ParserCSV(cal);
        OutputStream  os = new FileOutputStream(path);
        Writer osr = new OutputStreamWriter(os);
        osr.write(parser.ser());
        osr.close();
    }
}
