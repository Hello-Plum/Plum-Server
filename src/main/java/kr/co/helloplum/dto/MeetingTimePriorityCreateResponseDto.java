package kr.co.helloplum.dto;

import java.time.LocalDateTime;
import kr.co.helloplum.domain.MeetingTimePriority;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MeetingTimePriorityCreateResponseDto {

    private String id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int priority;

    public static MeetingTimePriorityCreateResponseDto of(MeetingTimePriority meetingTimePriority) {
        return new MeetingTimePriorityCreateResponseDto(
                meetingTimePriority.get_id(),
                meetingTimePriority.getName(),
                meetingTimePriority.getStartTime(),
                meetingTimePriority.getEndTime(),
                meetingTimePriority.getPriority()
        );
    }
}
