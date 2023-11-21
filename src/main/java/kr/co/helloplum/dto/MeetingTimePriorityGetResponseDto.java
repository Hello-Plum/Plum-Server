package kr.co.helloplum.dto;

import java.time.LocalDateTime;
import kr.co.helloplum.converter.IdxToDateTimeConverter;
import kr.co.helloplum.domain.MeetingTimePriority;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MeetingTimePriorityGetResponseDto {

    private String id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int startTimeIdx;
    private int endTimeIdx;
    private int priority;

    public static MeetingTimePriorityGetResponseDto of(MeetingTimePriority meetingTimePriority) {
        return new MeetingTimePriorityGetResponseDto(
                meetingTimePriority.get_id(),
                meetingTimePriority.getName(),
                meetingTimePriority.getStartTime(),
                meetingTimePriority.getEndTime(),
                IdxToDateTimeConverter.revert(meetingTimePriority.getStartTime(), IdxToDateTimeConverter.START),
                IdxToDateTimeConverter.revert(meetingTimePriority.getEndTime(), IdxToDateTimeConverter.END),
                meetingTimePriority.getPriority()
        );
    }
}
