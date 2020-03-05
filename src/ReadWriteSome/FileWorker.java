package ReadWriteSome;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.Collection;
import Collection.CollectionShellInterface;
import Parsers.Parser;
import Parsers.ParserCSV;

/**
 * класс реализующий интерфейс ReadWrite для работы именно с файлами и именно в формате CSV
 */
public class FileWorker implements ReadWrite{
    private CollectionShellInterface cal;
    private String path;
    public FileWorker(String path, CollectionShellInterface cal) {
        this.cal=cal;
        this.path=path;
    }
    @Override
    public void read(){
        try {
            Parser parser = new ParserCSV(cal);
            parser.deSer(path);
            System.out.println("Коллекция загружена");
        }catch ( FileNotFoundException e){
            System.out.println("Такого файла нет, будет загружена пустая коллекция");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
