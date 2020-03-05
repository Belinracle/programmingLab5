import commands.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        CommandFetch cf = new CommandFetch();
        ControlUnit cu = null;
        if (args.length > 0) {
            try {
                cu = new ControlUnit(cf, args[0]);
                cu.process("load");
            }
            catch (IOException e) {
                System.out.println("Ошибка открытия файла. Создана пустая коллекция");
            }
        }
        else{
            cu=new ControlUnit(cf,null);
            System.out.println("Файл с коллекцей не указан. Инициализирована пустая коллекция");
        }
            try {
                while (true) {
                    System.out.println("Введите команду");
                    String i = scan.nextLine().trim();
                    try {
                        if (!i.isEmpty()) {
                            cu.process(i);
                        }
                    }catch(StackOverflowError e ){
                        System.out.println("Закончился стек, выполнение прервано");
                        continue;
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println("Ввода больше не будет, сканер принял ислам");
            }
        }
    }

