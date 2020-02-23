package factories;

import MovieClasses.Location;
import MovieClasses.Person;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MoviePersonFactory {
    Scanner sc = new Scanner(System.in);
    MoviePersonFactory(){
    }
    public Person createMoviePerson(){
        Person pers = new Person();
        pers.setPersonName(persNameFact());
        pers.setPersonWeight(persWeightFact());
        pers.setPassportID(persPassIDFact());
        pers.setLocation(setPersLocation());
        sc.close();
        return pers;
    }
    public String persNameFact(){
        System.out.println("Введите имя Сценариста Фильма");
        String name=sc.nextLine();
        if (name.isEmpty()){
            System.out.println("Имя не может быть пустым");
            persNameFact();
            return null;
        }
        else return name;
    }
    public String persPassIDFact(){
        System.out.println("Введите его паспортный идентификатор");
        String buf = sc.nextLine();
        if (buf.isEmpty()) {
            System.out.println("Паспортный идентификатор не может быть пустым");
            persPassIDFact();
            return null;
        }
        return buf;
    }
    public int persWeightFact() {
        System.out.println("Введите его вес(Integer) ");
        try {
            int i = sc.nextInt();
            sc.nextLine();
            return i;
        } catch (InputMismatchException e) {
            System.out.println("Ты что ебобо, тип неправильный, давай по новой");
            sc.nextLine();
            persWeightFact();
            return 0;
        }
    }


    public Location setPersLocation(){
        System.out.println("Заполните поля локации проживания сценариста фильма ");
        Location loc = new Location(setLocationName(),setLocationX(),setLocationY(),setLocFloat());
        return loc;
    }
    public long setLocationX(){
        System.out.println("Установите координату Х(Long)");
        try {
            Long l = sc.nextLong();
            sc.nextLine();
            return l;
        }
        catch (InputMismatchException e){
            System.out.println("Ты что ебобо, тип неправильный, давай по новой");
            sc.nextLine();
            setLocationX();
            return 0;
        }
    }
    public int setLocationY(){
        System.out.println("Установите координату У(Integer)");
        try{
            int i=sc.nextInt();
            sc.nextLine();
            return i;
        }catch(InputMismatchException e){
            System.out.println("Ты что ебобо, тип неправильный, давай по новой");
            sc.nextLine();
            setLocationY();
            return 0;
        }
    }
    public Float setLocFloat(){
        System.out.println("Установите координату Z(Float)");
        try{
            Float f = sc.nextFloat();
            sc.nextLine();
            return f;
        }catch(InputMismatchException e) {
            sc.nextLine();
            System.out.println("Ты что ебобо, тип неправильный, давай по новой");
            setLocFloat();
            return 0f;
        }
    }
    public String setLocationName(){
        System.out.println("Установите название этого места");
        String str = sc.nextLine();
        if(!str.isEmpty())
            return str;
        else {
            setLocationName();
            return null;
        }
    }
}
