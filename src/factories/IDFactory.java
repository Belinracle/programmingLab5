package factories;

import java.io.*;
import java.util.Scanner;

public class IDFactory { //TODO подумать , нужно ли передавать путь файла в конструктор
    private static long counter;
    BufferedReader reader;
    String path;
    public IDFactory(String path) throws IOException {
        this.path=path;
        reader = new BufferedReader(new FileReader(path));
        counter= Long.parseLong(reader.readLine());
    }
    public static long createID() throws IOException {
        return ++counter;
    }
    public static long getCurrentID(){
        return counter;
    }
    public void write(String id) throws FileNotFoundException {
        PrintWriter writerID = new PrintWriter(path);
        writerID.write(id);
        writerID.close();
    }
}
