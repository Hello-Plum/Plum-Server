package kr.co.helloplum.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;

@Document(collection = "meeting_confirmed")
@Getter
@Builder
public class MeetingConfirmed {

	@Id
	private String _id;
	private String meetingId;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private List<String> participants;

}
