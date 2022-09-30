import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        checkLeapYear(2022); //создаём сначала psv + нужный нам глагол (camelCase), далее задаём параметры.
        getDeviceLink(0, 2011);
        int deliveryDays = calculateDeliveryDays(60);
        System.out.println("Потребуется дней " + deliveryDays);
    }

    private static void getDeviceLink(int osType, int manufacturingYear) {
        //Вспомним задание 2 по условным операторам, где нам необходимо было предложить пользователю облегченную версию приложения.
        //Напишите метод, куда подаются два параметра: тип операционной системы (ОС) ( 0 — iOS или 1 — Android) и год выпуска устройства.
        //Если устройство старше текущего года, предложите ему установить lite-версию (облегченную версию).
        //Текущий год можно получить таким способом:
        //int currentYear = LocalDate.now().getYear();
        //Или самим задать значение вручную, введя в переменную числовое значение.
        //В результате программа должна выводить в консоль в зависимости от исходных данных, какую версию приложения
        // (обычную или lite) и для какой ОС (Android или iOS) нужно установить пользователю.
        if (osType != 1 && osType != 0) {
            throw new IllegalArgumentException("Wrong OS type");
        }
        int currentYear = LocalDate.now().getYear();
        if (manufacturingYear > currentYear) {
            throw new IllegalArgumentException("Wrong manufacturing year");
        }
        String osString = osType == 0 ? "iOS" : "Android";
        String versionString = manufacturingYear > 2015 ? "full" : "lite";
        System.out.printf("Установите %s версию для %s по ссылке%n", versionString, osString);
    }

    private static void checkLeapYear(int year) {
        //Реализуйте метод, который получает в качестве параметра год, а затем проверяет,
        //является ли он високосным, и выводит результат в консоль.
        //*Эту проверку вы уже реализовывали в задании по условным операторам.*
        //Теперь проверку нужно обернуть в метод и использовать год, который приходит в виде параметра.
        //Результат программы выведите в консоль. Если год високосный, то должно быть выведено “*номер года —* високосный год”.
        //Если год не високосный, то, соответственно: “*номер года —* не **високосный год”.
       if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
           System.out.println(year + " is leap year");
       } else {
           System.out.println(year + " is not leap year");
       }
    }
    public static int calculateDeliveryDays(int deliveryDistance) {
        //Наша задача — доработать код, а именно написать метод, который на вход принимает дистанцию и возвращает итоговое количество дней доставки.
        if (deliveryDistance <= 20) {
            return 1;
        } else {
            return (int) Math.round((double) deliveryDistance / 40) + 1;
        }
    }




}