package kr.co.helloplum.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

@Document(collection = "meeting_time_priority")
@Getter
public class MeetingTimePriority {

	@Id
	private String _id;
	private String meetingId;
	private String name;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private int priority;

	@Builder
	public MeetingTimePriority(String meetingId, String name, LocalDateTime startTime, LocalDateTime endTime, int priority) {
		Assert.notNull(name, "name must not be null");
		Assert.notNull(startTime, "startTime must not be null");
		Assert.notNull(endTime, "endTime must not be null");
		Assert.notNull(priority, "priority must not be null");

		this.meetingId = meetingId;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.priority = priority;
	}
}
