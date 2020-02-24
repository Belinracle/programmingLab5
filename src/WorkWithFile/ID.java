package WorkWithFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ID implements FileWorker {
    Scanner readerID;
    String filename;
    public ID(String fileName) throws IOException {
        this.filename=fileName;
        Path path = Paths.get(fileName);
        readerID = new Scanner(path);
    }
    @Override
    public String read() {
        return readerID.next();
    }

    @Override
    public void write(String id) throws FileNotFoundException {
        PrintWriter writerID = new PrintWriter(filename);
        writerID.write(id);
        writerID.close();
    }
}