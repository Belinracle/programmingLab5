package factories;


import WorkWithFile.ID;

import java.io.*;
import java.util.Scanner;

public class IDFactory { //TODO подумать , нужно ли передавать путь файла в конструктор
    private ID iof;
    private long ID;
    private static long counter;
    public IDFactory(ID fw) throws IOException {
        counter= Long.parseLong(fw.read());
    }
    public static long createID() throws IOException {
        return ++counter;
    }
    public static long getCurrentID(){
        return counter;
    }
}
