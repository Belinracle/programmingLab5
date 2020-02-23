package Exceptions;

public class WrongRangeException extends RuntimeException {
    public WrongRangeException(){
        super("Извините но введенное вами значение должно быть больше 0");
    }
}
