package kr.co.helloplum.controller;

import java.time.LocalDate;

import kr.co.helloplum.dto.MeetingGetResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.helloplum.common.statusCode.SuccessCode;
import kr.co.helloplum.domain.Meeting;
import kr.co.helloplum.dto.ApiResponse;
import kr.co.helloplum.dto.MeetingCreateRequestDto;
import kr.co.helloplum.dto.MeetingCreateResponseDto;
import kr.co.helloplum.service.MeetingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/meeting")
@Slf4j
public class MeetingController {

	private final MeetingService meetingService;

	@PostMapping("")
	public ApiResponse<MeetingCreateResponseDto> createMeeting(@RequestBody MeetingCreateRequestDto requestDto) {
		MeetingCreateResponseDto responseDto = meetingService.createMeeting(requestDto);
		return ApiResponse.success(SuccessCode.MEETING_CREATE_SUCCESS, responseDto);
	}

	@GetMapping("/{meetingId}")
	public ApiResponse<MeetingGetResponseDto> getMeeting(@PathVariable String meetingId) {
		MeetingGetResponseDto responseDto = meetingService.getMeeting(meetingId);
		return ApiResponse.success(SuccessCode.MEETING_GET_SUCCESS, responseDto);
	}
}
