package home.work;


import java.time.LocalDateTime;

        import java.time.format.DateTimeFormatter;
public class Format {

    public static void main(String args[]){

        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYYY/MM/dd HH:mm:SS");
        LocalDateTime now= LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

}

