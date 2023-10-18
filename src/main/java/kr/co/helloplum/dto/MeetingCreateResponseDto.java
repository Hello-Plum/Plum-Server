package kr.co.helloplum.dto;

import java.time.LocalDate;

import kr.co.helloplum.domain.Meeting;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MeetingCreateResponseDto {
	private String id;

	public static MeetingCreateResponseDto of(Meeting meeting) {
		return new MeetingCreateResponseDto(meeting.get_id());
	}
}
