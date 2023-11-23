package kr.co.helloplum.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MeetingCreateRequestDto {
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private String place;
	private String placeDetail;
	private String duration;
	private String host;
	private String password;
	private String info;
}
