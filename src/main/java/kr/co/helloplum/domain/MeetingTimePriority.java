package kr.co.helloplum.domain;

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
	public MeetingTimePriority(Meeting meeting, String name, LocalDateTime startTime, LocalDateTime endTime) {
		Assert.notNull(meeting, "meeting must not be null");
		Assert.notNull(name, "name must not be null");
		Assert.notNull(startTime, "startTime must not be null");
		Assert.notNull(endTime, "endTime must not be null");
		Assert.isTrue(startTime.isBefore(endTime), "startTime must be before endTime");
		Assert.isTrue(startTime.isAfter(meeting.getStartDate().atStartOfDay()), "startTime must be after Meeting.startDate");
		Assert.isTrue(endTime.isBefore(meeting.getEndDate().plusDays(1).atStartOfDay()), "endTime must be before Meeting.endDate");

		this.meetingId = meeting.get_id();
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}
