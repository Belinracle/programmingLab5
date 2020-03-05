package factories;

import java.io.*;

/**
 * класс отвечающий за работу с ID
 */
public class IDFactory {
    private static long counter;
    private BufferedReader reader;
    private String path;
    public IDFactory(String path) throws IOException {
        this.path=path;
        reader = new BufferedReader(new FileReader(path));
        counter= Long.parseLong(reader.readLine());
    }

    /**
     * метод для получения ID и увеличивания счетчика
     */

    static long createID(){
        return ++counter;
    }

    /**
     * метод для получения текущего ID
     * используется при сохранении коллекции
     */
    public static long getCurrentID(){
        return counter;
    }

    /**
     * метод для записи текущего значения ID в файл для хранения
     * @param id
     * @throws FileNotFoundException
     */
    public void write(String id) throws FileNotFoundException {
        PrintWriter writerID = new PrintWriter(path);
        writerID.write(id);
        writerID.close();
    }
}
