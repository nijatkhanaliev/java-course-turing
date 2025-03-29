package az.edu.turing.module2.lesson06;

import com.sun.net.httpserver.Request;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
       Instant startDate = Instant.now();
       doSmth();
       Instant endDate = Instant.now();

        System.out.println(Duration.between(startDate,endDate).toMillis());

    }

    public static void doSmth() throws IOException {
        URL url = new URL("https://www.google.com");

       HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       connection.setRequestMethod("GET");

       int code = connection.getResponseCode();
        System.out.println(code);
       connection.disconnect();
    }

}

class DatePractice{
    public static void practiceDate() throws ParseException {
        Date date = new Date();
        long millis = System.currentTimeMillis() + date.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("EEE-MMM-yyyy"); // pattern
        System.out.println(sdf.format(date)); // date to string

        Date dateParsed = sdf.parse("tue-mar-2025"); // string to date

        date.setTime(millis);

        System.out.println(dateParsed);
        System.out.println(date);
    }
}

class LocalDatePractice{

    public static void practiceLocalDate(){
        System.out.println(LocalDate.ofYearDay(2025,35));

        System.out.println(LocalDate.now(ZoneId.of("America/New_York")));

        System.out.println(LocalDate.parse("12-10-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        System.out.println(LocalDate.of(2011,8,14).format(DateTimeFormatter.ofPattern("EEE-MMM-yyyy")));

    }

}

class LocalTimePractice{
    public static void practiceLocalTime(){
        System.out.println(LocalTime.now(ZoneId.of("UTC")));

        System.out.println(LocalTime.parse("14,58,21.3242",DateTimeFormatter.ofPattern("HH,mm,ss.SSSS")));


        LocalTime localTime = LocalTime.now();

        LocalTime localTime2 = LocalTime.now().plusHours(4); // add hour to current hour

        localTime = localTime.withHour(4); // replace hour with given hour

        System.out.println(localTime2);

        System.out.println(localTime);
    }

}

class LocalDateTimePractice{
    public static void practice(){
        LocalDateTime localDateTime = LocalDateTime.of(2020,10,21,14,24,45,475);

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEE-MMM-yyyy")));
        System.out.println(LocalDateTime.parse("16-10-2024 16:40:45",DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.out.println(LocalDateTime.now());
        System.out.println(localDateTime);

        System.out.println(LocalDateTime.now().plus(4, ChronoUnit.YEARS));
    }
}