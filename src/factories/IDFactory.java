package factories;

import WorkWithFile.FileWorker;

import java.io.*;
import java.util.Scanner;

public class IDFactory { //TODO подумать , нужно ли передавать путь файла в конструктор
    private FileWorker iof;
    private long ID;
    private static long counter;
    public IDFactory() throws IOException {
        iof = new FileWorker();
        ID=iof.readFileID();
        counter=ID;
    }
    public static long createID() throws IOException {
        return ++counter;
    }
    public static long getCurrentID(){
        return counter;
    }
}
