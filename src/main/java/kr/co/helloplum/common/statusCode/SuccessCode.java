package kr.co.helloplum.common.statusCode;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessCode {

	// meeting
	MEETING_CREATE_SUCCESS(CREATED, "회의 생성 성공"),
	MEETING_GET_SUCCESS(OK, "회의 조회 성공");


	private final HttpStatus status;
	private final String message;
}
