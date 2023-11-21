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
	MEETING_GET_SUCCESS(OK, "회의 조회 성공"),
	MEETING_POST_OWNER_CHECK_SUCCESS(OK, "방장 확인 성공"),

	// meeting time priority
	MEETING_TIME_PRIORITY_CREATE_SUCCESS(CREATED, "회의 시간 우선순위 생성 성공"),
	MEETING_TIME_PRIORITIES_GET_SUCCESS(OK, "종합일정표 조회 성공");


	private final HttpStatus status;
	private final String message;
}
