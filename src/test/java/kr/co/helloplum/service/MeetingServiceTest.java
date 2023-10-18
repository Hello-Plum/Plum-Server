package kr.co.helloplum.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.helloplum.domain.Meeting;

@SpringBootTest
public class MeetingServiceTest {

	@Autowired
	private MeetingService meetingService;

	@Test
	@DisplayName("Save meeting should be success")
	public void saveMeetingShouldBeSuccess() {
		// Meeting meeting = Meeting.builder()
		// 	.name("test meeting")
		// 	.startDate(LocalDate.of(2023, 10, 12))
		// 	.endDate(LocalDate.of(2023, 10, 16))
		// 	.place("online")
		// 	.placeDetail("googleMeeting")
		// 	.host("minjikim")
		// 	.password("pwd")
		// 	.info("info")
		// 	.build();
		//
		// Meeting savedMeeting = meetingService.createMeeting(meeting);
		//
		// assertEquals("test meeting", savedMeeting.getName());

	}
}
