package WorkWithFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileWorker {
    private Scanner readerID;
    public FileWorker() throws IOException {
        String fileName = "C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//IdContainer.txt";
        Path path = Paths.get(fileName);
        readerID = new Scanner(path);

    }
    public long readFileID(){
        return Long.parseLong(readerID.next());
    }
    public void writeFileID(long IDnext) throws FileNotFoundException {
        PrintWriter writerID = new PrintWriter("C://Users//Даниэль//Desktop//Лабораторные//programming//Lab5//IdContainer.txt");
        writerID.write(String.valueOf(IDnext));
        writerID.close();
    }
}
