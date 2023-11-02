package kr.co.helloplum.dto;

import java.time.LocalDate;
import kr.co.helloplum.domain.Meeting;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MeetingGetResponseDto {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String place;
    private String placeDetail;
    private String host;
    private String password;
    private String info;
    private boolean isConfirmed;

    public static MeetingGetResponseDto of(Meeting meeting) {
        return new MeetingGetResponseDto(
                meeting.get_id(),
                meeting.getStartDate(),
                meeting.getEndDate(),
                meeting.getPlace(),
                meeting.getPlaceDetail(),
                meeting.getHost(),
                meeting.getPassword(),
                meeting.getInfo(),
                meeting.isConfirmed()
        );
    }
}
