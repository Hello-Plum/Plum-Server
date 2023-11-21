package kr.co.helloplum.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class IdxToDateTimeConverter {

    private static final int TIME_PREFIX = 7;
    public static final int START = 0;
    public static final int END = 1;

    public static LocalDateTime convert(int idx, LocalDate startDate, int timeFlag) {
        int dayIdx = idx / 34;
        int timeIdx = idx % 34;

        int plusDay = (dayIdx + 1) - startDate.getDayOfWeek().getValue();
        if (plusDay < 0) plusDay += 7;

        return startDate.atStartOfDay()
                .plusDays(plusDay)
                .plusHours(TIME_PREFIX)
                .plusMinutes((timeIdx + timeFlag) * 30L);
    }
}
