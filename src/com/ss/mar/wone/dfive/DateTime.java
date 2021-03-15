package com.ss.mar.wone.dfive;

import java.time.*;

/**
 * Date Time API portion of the assignment
 * @author Mosaab
 */
public class DateTime {
    /**
     * Executes different approaches to finding date and time using Java8
     * @param args
     */
    public static void main(String[] args) {
        DateTime dt = new DateTime();

        // Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
        ZonedDateTime birthday = ZonedDateTime.of(2017, 4, 1,
                5, 23, 15, 234,
                ZoneId.of("America/New_York"));
        System.out.println(birthday);

        // Given a random date, how would you find the date of the previous Thursday?
        LocalDate randomDate = LocalDate.of(2017, 4, 1);
        System.out.println(randomDate.minusWeeks(1));

        // What is the difference between a ZoneId and a ZoneOffset?
        ZoneId nyZone = ZoneId.of("America/New_York");
        ZoneOffset nyOffset = nyZone.getRules().getOffset(LocalDateTime.now());
        System.out.println(nyZone +" offset from UTC is "+ nyOffset);

        // How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?
        // Instant to ZonedDateTime
        Instant now = Instant.now();
        ZonedDateTime zonedNow= now.atZone(nyZone);
        // ZonedDateTime to Instant
        zonedNow.toInstant();

        // Write an example that, for a given year, reports the length of each month within that year.
        dt.printMonthsLength(2019); // non leap year
        dt.printMonthsLength(2020); // leap year

        // Write an example that, for a given month of the current year, lists all of the Mondays in that month.
        dt.printAllMondays(2);

        //Write an example that tests whether a given date occurs on Friday the 13th.
        System.out.println(dt.fridayTheThirteen(LocalDate.of(2021, 8, 13)));
        System.out.println(dt.fridayTheThirteen(LocalDate.of(2021, 7, 13)));
    }

    /**
     * Prints the length of each month of a given year
     * @param year
     */
    private void printMonthsLength(int year) {
        // We know that there are 12 months in a year, so no need to get technical
        for (int i=1; i <= 12; i++) {
            System.out.println(Month.of(i).name() +" has "+ YearMonth.of(year, i).lengthOfMonth() +" days");
        }
    }

    /**
     * Prints all mondays of a given months in the current year
     * @param month
     */
    private void printAllMondays(int month) {
        // Check if month is within range
        if (month > 12 || month < 1) {
            // We can throw an exception, depending on how we want to handle it
            System.err.print("Must specify a month within the year.");
            return;
        }

        // Get the month object
        YearMonth monthObj = YearMonth.of(Year.now().getValue(), month);

        int day = 1;
        while (day < monthObj.lengthOfMonth()) {
            // Get the day in a localdate object
            LocalDate givenDay = monthObj.atDay(day);
            if (DayOfWeek.MONDAY == givenDay.getDayOfWeek()) {
                System.out.println(givenDay.toString());
                day += 7;
            } else {
                day++;
            }
        }
    }

    /**
     * Checks whether a certain date occurs on Friday the 13th
     * @param date localdate object
     * @return true or false
     */
    private boolean fridayTheThirteen(LocalDate date) {
        return (DayOfWeek.FRIDAY == date.getDayOfWeek() && 13 == date.getDayOfMonth());
    }
}
