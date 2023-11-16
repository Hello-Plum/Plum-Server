package kr.co.helloplum.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kr.co.helloplum.domain.Meeting;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MeetingGetResponseDto {
    private String id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String place;
    private String placeDetail;
    private String host;
    private String password;
    private String info;
    private boolean confirmed;
    private boolean period;
    private Set<Integer> selectedWeek;

    public static MeetingGetResponseDto of(Meeting meeting) {
        return new MeetingGetResponseDto(
                meeting.get_id(),
                meeting.getName(),
                meeting.getStartDate(),
                meeting.getEndDate(),
                meeting.getPlace(),
                meeting.getPlaceDetail(),
                meeting.getHost(),
                meeting.getPassword(),
                meeting.getInfo(),
                meeting.isConfirmed(),
                !meeting.getStartDate().equals(meeting.getEndDate()),
                convertDateToWeekNumber(meeting.getStartDate(), meeting.getEndDate())
        );
    }

    private static Set<Integer> convertDateToWeekNumber(LocalDate startDate, LocalDate endDate) {
        Set<Integer> weekNumbers = new HashSet<>();
        for (LocalDate date = startDate; date.isBefore(endDate) || date.equals(endDate); date = date.plusDays(1)) {
            weekNumbers.add(date.getDayOfWeek().getValue() - 1);
        }
        return weekNumbers;
    }
}
