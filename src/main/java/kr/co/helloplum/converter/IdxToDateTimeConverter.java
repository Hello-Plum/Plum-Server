package kr.co.helloplum.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class IdxToDateTimeConverter {

    private static final int TIME_PREFIX = 7;
    public static final int START = 0;
    public static final int END = 1;

    public static LocalDateTime convert(int idx, LocalDate startDate, int timeFlag) {
        int dayIdx = idx / 34;  // 0~6
        int timeIdx = idx % 34; // 0~33

        return startDate.atStartOfDay()
                .plusDays(dayIdx)
                .plusHours(TIME_PREFIX)
                .plusMinutes((timeIdx + timeFlag) * 30L);
    }
}
