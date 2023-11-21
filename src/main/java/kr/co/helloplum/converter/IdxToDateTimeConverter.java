package kr.co.helloplum.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class IdxToDateTimeConverter {

    private static final int TIME_PREFIX = 7;
    private static final int NUMBER_OF_TIME_BLOCKS = 34;
    private static final int SIZE_OF_TIME_BLOCK = 30;
    public static final int START = 0;
    public static final int END = 1;

    public static LocalDateTime convert(int idx, LocalDate startDate, int timeFlag) {
        int dayIdx = idx / NUMBER_OF_TIME_BLOCKS;
        int timeIdx = idx % NUMBER_OF_TIME_BLOCKS;

        int plusDay = (dayIdx + 1) - startDate.getDayOfWeek().getValue();
        if (plusDay < 0) plusDay += 7;

        return startDate.atStartOfDay()
                .plusDays(plusDay)
                .plusHours(TIME_PREFIX)
                .plusMinutes((long) (timeIdx + timeFlag) * SIZE_OF_TIME_BLOCK);
    }

    public static int revert(LocalDateTime dateTime, int timeFlag) {
        int dayIdx = dateTime.getDayOfWeek().getValue() - 1;
        int timeIdx = ((dateTime.getHour() - TIME_PREFIX) * 60 + dateTime.getMinute()) / SIZE_OF_TIME_BLOCK;
        return timeIdx  + (dayIdx * NUMBER_OF_TIME_BLOCKS) - timeFlag;
    }
}
