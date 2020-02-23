package factories;

import MovieClasses.Location;
import MovieClasses.Person;

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
//        sc.close();
        return pers;
    }
    public String persNameFact(){
        System.out.println("Введите имя Сценариста Фильма");
        return sc.nextLine();
    }
    public String persPassIDFact(){
        System.out.println("Введите его паспортный идентификатор");
        String buf = sc.nextLine();
        return buf;
    }
    public int persWeightFact(){
        System.out.println("Введите его вес ");
        int i = sc.nextInt();
        sc.nextLine();
        return i;
    }
    public Location setPersLocation(){
        System.out.println("Заполните поля локации проживания сценариста фильма ");
        Location loc = new Location(setLocationName(),setLocationX(),setLocationY(),setLocFloat());
        return loc;
    }
    public long setLocationX(){
        System.out.println("Установите координату Х(Long)");
        return sc.nextLong();
    }
    public int setLocationY(){
        System.out.println("Установите координату У(Integer)");
        return sc.nextInt();
    }
    public Float setLocFloat(){
        System.out.println("Установите координату Z(Float)");
        return sc.nextFloat();
    }
    public String setLocationName(){
        System.out.println("Установите название этого места");
        return sc.nextLine();
    }

}
