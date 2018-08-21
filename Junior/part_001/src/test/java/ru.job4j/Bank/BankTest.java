package ru.job4j.Bank;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class BankTest Решение задачи: Пик посетителей в банке
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 18.08.2018
 */
public class BankTest {

    /**
     * test with 1 visit, without cross
     */
    @Test
    public void whenOneVisit() {
        List<Bank.Visit> visits = Arrays.asList(new Bank.Visit(time(8, 10), time(8, 20)));
        assertThat(new Bank().max(visits), is(Arrays.asList(new Bank.Info(1, time(8, 10), time(8, 20)))));
    }

    /**
     * test cross 2 visits
     */
    @Test
    public void whenCrossTwoVisit() {
        List<Bank.Visit> visits = Arrays.asList(new Bank.Visit(time(8, 10), time(8, 50)),
                new Bank.Visit(time(8, 30), time(9, 15)));
        assertThat(new Bank().max(visits), is(Arrays.asList(new Bank.Info(2, time(8, 30), time(8, 50)))));
    }

    /**
     * test cross 3 visits
     */
    @Test
    public void whenCrossThreeVisit() {
        List<Bank.Visit> visits = Arrays.asList(new Bank.Visit(time(8, 10), time(8, 50)),
                new Bank.Visit(time(8, 30), time(9, 15)),
                new Bank.Visit(time(8, 30), time(8, 45)));
        assertThat(new Bank().max(visits), is(Arrays.asList(new Bank.Info(3, time(8, 30), time(8, 45)))));
    }

    /**
     * test cross 4 visits
     */
    @Test
    public void whenCrossMaxFourVisit() {
        List<Bank.Visit> visits = Arrays.asList(new Bank.Visit(time(8, 10), time(8, 50)),
                new Bank.Visit(time(8, 30), time(9, 15)),
                new Bank.Visit(time(8, 30), time(8, 45)),
                new Bank.Visit(time(14, 10), time(14, 30)),
                new Bank.Visit(time(14, 11), time(14, 19)),
                new Bank.Visit(time(14, 12), time(14, 34)),
                new Bank.Visit(time(14, 18), time(14, 50)));
        assertThat(new Bank().max(visits), is(Arrays.asList(new Bank.Info(4, time(14, 18), time(14, 19)))));
    }

    /**
     * test cross 5 visits
     */
    @Test
    public void whenCrossMaxFiveVisit() {
        List<Bank.Visit> visits = Arrays.asList(new Bank.Visit(time(8, 10), time(8, 50)),
                new Bank.Visit(time(8, 30), time(9, 15)),
                new Bank.Visit(time(8, 30), time(8, 45)),
                new Bank.Visit(time(14, 10), time(14, 30)),
                new Bank.Visit(time(14, 11), time(14, 19)),
                new Bank.Visit(time(14, 12), time(14, 34)),
                new Bank.Visit(time(14, 13), time(14, 44)),
                new Bank.Visit(time(14, 18), time(14, 50)));
        assertThat(new Bank().max(visits), is(Arrays.asList(new Bank.Info(5, time(14, 18), time(14, 19)))));
    }

    /**
     * test cross 6 visits
     */
    @Test
    public void whenCrossMaxSixVisit() {
        List<Bank.Visit> visits = Arrays.asList(new Bank.Visit(time(8, 10), time(8, 50)),
                new Bank.Visit(time(8, 30), time(9, 15)),
                new Bank.Visit(time(8, 30), time(8, 45)),
                new Bank.Visit(time(14, 10), time(14, 30)),
                new Bank.Visit(time(14, 11), time(14, 19)),
                new Bank.Visit(time(14, 12), time(14, 34)),
                new Bank.Visit(time(14, 13), time(14, 44)),
                new Bank.Visit(time(14, 18), time(14, 50)),
                new Bank.Visit(time(16, 2), time(16, 36)),
                new Bank.Visit(time(16, 13), time(16, 38)),
                new Bank.Visit(time(16, 17), time(16, 34)),
                new Bank.Visit(time(16, 23), time(16, 54)),
                new Bank.Visit(time(16, 23), time(16, 33)),
                new Bank.Visit(time(16, 25), time(16, 35)));
        assertThat(new Bank().max(visits), is(Arrays.asList(new Bank.Info(6, time(16, 25), time(16, 33)))));
    }

    /**
     * test cross 4 visits with duplicates
     */
    @Test
    public void whenCrossMaxFourVisitWithDuplicates() {
        List<Bank.Visit> visits = Arrays.asList(new Bank.Visit(time(8, 10), time(8, 50)),
                new Bank.Visit(time(8, 30), time(9, 15)),
                new Bank.Visit(time(8, 30), time(8, 45)),
                new Bank.Visit(time(14, 10), time(14, 30)),
                new Bank.Visit(time(14, 10), time(14, 19)),
                new Bank.Visit(time(14, 10), time(14, 30)),
                new Bank.Visit(time(14, 10), time(14, 31)));
        assertThat(new Bank().max(visits), is(Arrays.asList(new Bank.Info(4, time(14, 10), time(14, 19)))));
    }

    /**
     * test cross 3 elements in the middle
     */
    @Test
    public void whenCrossMaxThreeVisitsInTheMiddle() {
        List<Bank.Visit> visits = Arrays.asList(new Bank.Visit(time(8, 10), time(8, 50)),
                new Bank.Visit(time(8, 30), time(9, 15)),
                new Bank.Visit(time(8, 30), time(8, 45)),
                new Bank.Visit(time(14, 10), time(14, 30)),
                new Bank.Visit(time(14, 10), time(14, 45)),
                new Bank.Visit(time(15, 10), time(15, 38)),
                new Bank.Visit(time(15, 14), time(15, 48)),
                new Bank.Visit(time(15, 20), time(15, 35)),
                new Bank.Visit(time(16, 14), time(16, 48)),
                new Bank.Visit(time(16, 14), time(16, 48)),
                new Bank.Visit(time(17, 14), time(17, 48)));
        assertThat(new Bank().max(visits), is(Arrays.asList(new Bank.Info(3, time(15, 20), time(15, 35)))));
    }

    /**
     * test cross 3 elements in the begin with duplicates
     */
    @Test
    public void whenCrossMaxThreeVisitsInTheBeginWithDuplicates() {
        List<Bank.Visit> visits = Arrays.asList(new Bank.Visit(time(8, 30), time(8, 45)),
                new Bank.Visit(time(8, 30), time(8, 45)),
                new Bank.Visit(time(8, 30), time(8, 45)),
                new Bank.Visit(time(14, 10), time(14, 30)),
                new Bank.Visit(time(15, 10), time(15, 38)),
                new Bank.Visit(time(15, 20), time(15, 35)),
                new Bank.Visit(time(16, 14), time(16, 48)),
                new Bank.Visit(time(16, 14), time(16, 48)),
                new Bank.Visit(time(17, 14), time(17, 48)));
        assertThat(new Bank().max(visits), is(Arrays.asList(new Bank.Info(3, time(8, 30), time(8, 45)))));
    }

    private long time(int hour, int minute) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2000);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
}