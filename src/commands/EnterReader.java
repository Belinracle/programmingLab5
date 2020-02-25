package commands;

import java.util.Scanner;

public class EnterReader {
    public EnterReader(){
    }
    public Long readLong(Long max,Long min,String name){
        System.out.print("Введите значение типа Long "+name);
        if(max!=Long.MAX_VALUE){ System.out.print("  Максимальное значение=" +max); }
        if (min!=Long.MIN_VALUE) {System.out.println("  Минимальное значение= "+ min);}
        Scanner scan=new Scanner(System.in);
        String enteredValue=scan.nextLine().trim();
        try{
        if (!enteredValue.isEmpty()){
            long result=Long.parseLong(enteredValue);
            if (result>max){
                System.out.println("Введенное значение больше допустимого максимума ");
                readLong(max,min,name);
            }
            else if (result<min){
                System.out.println("Введенное значение меньше допустимого минимума");
                readLong(max,min,name);
            }
            else return result;
            return null;
        }
        else {readLong(max,min,name);
        return null;}}
        catch (NumberFormatException e){
            System.out.println("Неверный тип введенных данных");
            readLong(max,min,name);
            return null;
        }
    }
    public Float readFloat(Float max,Float min,String name){
        System.out.print("Введите значение типа Float "+name);
        if(max!=Float.MAX_VALUE){ System.out.print("  Максимальное значение=" +max); }
        if (min!=Float.MIN_VALUE) {System.out.println("  Минимальное значение= "+ min);}
        Scanner scan=new Scanner(System.in);
        String enteredValue=scan.nextLine().trim();
        try{
            if (!enteredValue.isEmpty()){
                float result=Float.parseFloat(enteredValue);
                if (result>max){
                    System.out.println("Введенное значение больше допустимого максимума ");
                    readFloat(max,min,name);
                }
                else if (result<min){
                    System.out.println("Введенное значение меньше допустимого минимума");
                    readFloat(max,min,name);
                }else{
                scan.close();
                return result;}
                return null;
            }
            else {readFloat(max,min,name);
                return null;}}
        catch (NumberFormatException e){
            System.out.println("Неверный тип введенных данных");
            readFloat(max,min,name);
            return null;
        }
    }
    public Integer readInteger(Integer max,Integer min,String name){
        System.out.print("Введите значение типа Integer "+name);
        if(max!=Integer.MAX_VALUE){ System.out.print("  Максимальное значение=" +max); }
        if (min!=Integer.MIN_VALUE) {System.out.println("  Минимальное значение= "+ min);}
        Scanner scan=new Scanner(System.in);
        String enteredValue=scan.nextLine().trim();
        try{
            if (!enteredValue.isEmpty()){
                int result=Integer.parseInt(enteredValue);
                if (result>max){
                    System.out.println("Введенное значение больше допустимого максимума ");
                    readInteger(max,min,name);
                }
                else if (result<min){
                    System.out.println("Введенное значение меньше допустимого минимума");
                    readInteger(max,min,name);
                }else{
                    scan.close();
                    return result;}
                return null;
            }
            else {readInteger(max,min,name);
                return null;}}
        catch (NumberFormatException e){
            System.out.println("Неверный тип введенных данных");
            readInteger(max,min,name);
            return null;
        }
    }
    public String readString(String name ,boolean ableBeNull){
        System.out.println("Введите "+name);
        Scanner scan=new Scanner(System.in);
        String result="";
        if (ableBeNull){
            System.out.println("Введенное вами значение можеть быть null, за null принимается пустая строка");
            result=result+scan.nextLine().trim();
            return  result;
        }
        else{
            result=result+scan.nextLine().trim();
            if (result.isEmpty()) readString(name,false);
            else return result;
        }
        return null;
    }
}
