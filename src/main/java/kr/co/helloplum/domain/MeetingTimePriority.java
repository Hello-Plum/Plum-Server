package kr.co.helloplum.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;

@Document(collection = "meeting_time_priority")
@Getter
@Builder
public class MeetingTimePriority {

	@Id
	private String _id;
	private String meetingId;
	private String name;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private int priority;

}
