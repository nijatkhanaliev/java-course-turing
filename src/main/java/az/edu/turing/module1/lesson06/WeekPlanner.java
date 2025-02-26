package az.edu.turing.module1.lesson06;

import java.util.Scanner;

public class WeekPlanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] schedule = createSchedule();
        boolean isExit = false;

        while (!isExit) {
            System.out.println("Enter day of week");
            String day = sc.nextLine().trim();

            if (day.startsWith("change")) {
                day = day.substring(7).trim();
                if (isDayExist(day, schedule) == null) {
                    System.out.println("Sorry, i do not understand yoy. Please try again.");
                    continue;
                }
                System.out.println("Enter new task for " + day);
                String task = sc.nextLine().trim();
                changeTask(day, task, schedule);

                continue;
            }

            if (day.equalsIgnoreCase("exit")) {
                isExit = true;
                continue;
            }

            String task = isDayExist(day.toLowerCase(), schedule);
            System.out.println(task == null ? "Sorry,i do not understand you. Please try again." : task);
        }
        sc.close();
    }

    public static void changeTask(String day, String newTask, String[][] schedule) {
        for (String[] sc : schedule) {
            if (day.equalsIgnoreCase(sc[0])) {
                sc[1] = newTask;
            }
        }
    }

    public static String isDayExist(String day, String[][] schedule) {
        for (String[] sc : schedule) {
            if (day.equalsIgnoreCase(sc[0])) {
                return sc[1];
            }
        }

        return null;
    }

    public static String[][] createSchedule() {
        String[][] schedule = new String[7][2];
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do home work";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses; watch a film";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "read a book";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "do exercise";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "go shopping";
        schedule[5][0] = "Friday";
        schedule[5][1] = "play football";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "play guitar";

        return schedule;
    }

}
