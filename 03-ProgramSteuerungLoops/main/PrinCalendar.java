package main;

public class PrinCalendar {
    // Draws a calendar month given the start day of the month
    public static void main(String[] args) {

        int firstDay = 3, noOfDays = 31;
        int noOfRows = (noOfDays + firstDay - 1) / 7 + 1;
        System.out.println("Mo Di Mi Do Fr Sa So");

        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < 7; col++) {
                int day = row * 7 + col + 1 - firstDay;
                // First week of the month. Add spaces until first day of the month --> day is positive
                if (day > noOfDays || day <= 0) {
                    System.out.print("   ");
                // add 2 spaces for single digit
                } else if (day < 10) {
                    System.out.print(day + "  ");
                // add 1 space for 2 digits
                } else {
                    System.out.print(day + " ");
                }
            }
            System.out.println();
        }
    }
}

