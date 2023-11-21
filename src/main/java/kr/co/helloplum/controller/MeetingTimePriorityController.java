package kr.co.helloplum.controller;

import jakarta.validation.Valid;
import java.util.List;
import kr.co.helloplum.common.statusCode.SuccessCode;
import kr.co.helloplum.dto.ApiResponse;
import kr.co.helloplum.dto.MeetingTimePriorityCreateRequestDto;
import kr.co.helloplum.dto.MeetingTimePriorityCreateResponseDto;
import kr.co.helloplum.dto.MeetingTimePriorityGetResponseDto;
import kr.co.helloplum.service.MeetingTimePriorityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/meeting/{meetingId}/time")
@Slf4j
public class MeetingTimePriorityController {

    private final MeetingTimePriorityService meetingTimePriorityService;

    @PostMapping("")
    public ApiResponse<List<MeetingTimePriorityCreateResponseDto>> createMeetingTimePriority(@PathVariable String meetingId,
                                                                                       @RequestBody @Valid MeetingTimePriorityCreateRequestDto requestDto) {
        List<MeetingTimePriorityCreateResponseDto> responseDto = meetingTimePriorityService.createMeetingTimePriority(meetingId, requestDto);
        return ApiResponse.success(SuccessCode.MEETING_TIME_PRIORITY_CREATE_SUCCESS, responseDto);
    }

    @GetMapping("")
    public ApiResponse<List<MeetingTimePriorityGetResponseDto>> getMeetingTimePriorities(@PathVariable String meetingId) {
        List<MeetingTimePriorityGetResponseDto> responseDto = meetingTimePriorityService.getMeetingTimePriorities(meetingId);
        return ApiResponse.success(SuccessCode.MEETING_TIME_PRIORITIES_GET_SUCCESS, responseDto);
    }
}
