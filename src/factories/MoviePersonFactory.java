package factories;

import MovieClasses.Location;
import MovieClasses.Person;

import java.io.*;

/**
 * Класс реализующий создание полностью готового и заполненного экземпляра Person
 */

public class MoviePersonFactory {
    private BufferedReader scan;
    private boolean script;
    public MoviePersonFactory(){InputStream inputStream = System.in;
        scan = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Конструктор, использующийся для работы с скриптом
     * @param scan
     */
    public MoviePersonFactory(BufferedReader scan){
        this.scan=scan;
        script=true;
    }

    public Person createMoviePerson() throws IOException {
        Person pers = new Person();
        persNameFact(pers);
        persWeightFact(pers);
        persPassIDFact(pers);
        pers.setLocation(setPersLocation());
        return pers;
    }
    private void persNameFact(Person pers) {
        String result = "";
        if (!script) System.out.println("Введите имя сценариста");
        try {
            while (result.isEmpty()) {
                result = scan.readLine().trim();
                if (result.isEmpty()) {
                    if (!script) System.out.println("Введите непустую строку");
                }
            }
            pers.setPersonName(result);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    private void persPassIDFact(Person pers) throws IOException{
        String result = "";
        if(!script)System.out.println("Введите pass ID");
        while (result.isEmpty()) {
            result = scan.readLine().trim();
            if (result.isEmpty()) {
                if(!script)System.out.println("Введите непустую строку");
            }
        }
        pers.setPassportID(result);
    }
    private void persWeightFact(Person pers) {
        Integer result = null;
        if(!script)System.out.println("Введите вес(Integer)");
        while (result == null) {
            try {
                int i = Integer.parseInt(scan.readLine().trim());
                if (i>0) {
                    result = i;
                } else {
                    System.out.println("Неверный ввод. Повторите");
                }
            } catch (NullPointerException | NumberFormatException | IOException e) {
                if(!script)System.out.println("Неверный ввод. Повторите");
            }
        }
        pers.setWeight(result);
    }


    private Location setPersLocation() throws IOException {
        if(!script)System.out.println("Заполните поля локации проживания сценариста фильма ");
        Location loc = new Location();
        setLocationName(loc);
        setLocationX(loc);
        setLocationY(loc);
        setLocFloat(loc);
        return loc;
    }
    private void setLocationX(Location loc) {
        Long result = null;
        if(!script)System.out.println("введите X(Long)");
        while (result == null) {
            try {
                result = Long.parseLong(scan.readLine().trim());
            } catch (NullPointerException | NumberFormatException |IOException e) {
                if(!script)System.out.println("Неверный ввод. Повторите");
            }
        }
        loc.setX(result);
    }
    private void setLocationY(Location loc) {
        Integer result = null;
        if(!script)System.out.println("введите Y(Integer)");
        while (result == null) {
            try {
                result = Integer.parseInt(scan.readLine().trim());
            } catch (NullPointerException | NumberFormatException | IOException e) {
                if(!script)System.out.println("Неверный ввод. Повторите");
            }
        }
        loc.setY(result);
    }

    private void setLocationName(Location loc) throws IOException  {
        if(!script)System.out.println("Введите название локации(может быть null)");
            String entered = scan.readLine().trim();
            loc.setName(entered);
    }
    private void setLocFloat(Location loc) {
        Float result = null;
        if(!script)System.out.println("введите Z(Float)(не более 7 значащих цифр)");
        while (result == null) {
            try {
                String str=scan.readLine().trim();
                if ((str.length() - str.replaceAll("\\d+", "").length())>7){
                    System.out.println("Сказано же 7");
                    throw new NumberFormatException();
                }
                result = Float.parseFloat(str);
            } catch (NullPointerException | NumberFormatException | IOException e) {
                if(!script)System.out.println("Неверный ввод. Повторите");
            }
        }
        loc.setZ(result);
    }

}
