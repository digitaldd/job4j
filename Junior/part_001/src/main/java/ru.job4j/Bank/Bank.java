package ru.job4j.Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Calendar;

/**
 * Class Bank Решение задачи: Пик посетителей в банке
 *
 * @author Mikhail Kochin (digital-dd@mail.ru)
 * @since 18.08.2018
 */
public class Bank {

    public List<Info> max(List<Visit> visits) {
        List<Info> periods = new ArrayList<>();
        List<Info> allPeriods = new ArrayList<>();
        Map<Long, List<Info>> map = new HashMap<>();
        int maxSize = 0;
        long hash = 0;
        for (int i = 0; i < visits.size(); i++) {
            long count = 1;
            for (int j = i; j < visits.size(); j++) {
                if (visits.get(i).out >= visits.get(j).in) {
                    allPeriods.add(new Info(count, visits.get(j).in, visits.get(j).out));
                    count++;
                }
            }
            if (allPeriods.size() >= maxSize) {
                maxSize = allPeriods.size();
                hash = visits.get(i).in;
                map.put(visits.get(i).in, new ArrayList<>(allPeriods));
            }
            allPeriods.clear();
        }
        allPeriods = map.get(hash);
        for (int k = 1, m = 0; k < allPeriods.size(); k++) {
            long start = Math.max(allPeriods.get(m).start, allPeriods.get(k).start);
            long finish = Math.min(allPeriods.get(m).end, allPeriods.get(k).end);
            allPeriods.set(0, new Info(allPeriods.size(), start, finish));
        }
        periods.add(allPeriods.get(0));
        return periods;
    }

    public static class Visit {
        private final long in;
        private final long out;

        public Visit(final long in, final long out) {
            this.in = in;
            this.out = out;
        }
    }

    public static class Info {
        private long max;
        private long start;
        private long end;

        public Info() {
            this(0, 0, 0);
        }

        public Info(long max, long start, long end) {
            this.max = max;
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Info info = (Info) o;

            if (max != info.max) return false;
            if (start != info.start) return false;
            return end == info.end;
        }

        @Override
        public int hashCode() {
            int result = (int) (max ^ (max >>> 32));
            result = 31 * result + (int) (start ^ (start >>> 32));
            result = 31 * result + (int) (end ^ (end >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return "Info{" + "max=" + max + ", start=" + this.toTime(this.start) + ", end=" + this.toTime(this.end) + '}';
        }

        public String toTime(long time) {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(time);
            return String.format("%s:%s", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
        }
    }
}