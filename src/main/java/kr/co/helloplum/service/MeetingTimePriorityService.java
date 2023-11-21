package kr.co.helloplum.service;

import java.time.LocalDate;
import java.util.List;
import kr.co.helloplum.common.exception.BadRequestException;
import kr.co.helloplum.common.statusCode.ErrorCode;
import kr.co.helloplum.converter.IdxToDateTimeConverter;
import kr.co.helloplum.domain.Meeting;
import kr.co.helloplum.domain.MeetingTimePriority;
import kr.co.helloplum.dto.MeetingTimePriorityCreateRequestDto;
import kr.co.helloplum.dto.MeetingTimePriorityCreateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MeetingTimePriorityService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<MeetingTimePriorityCreateResponseDto> createMeetingTimePriority(String meetingId, MeetingTimePriorityCreateRequestDto requestDto) {
        
        Meeting meeting = mongoTemplate.findOne(
                Query.query(Criteria.where("_id").is(meetingId)),
                Meeting.class);
        
        if (meeting == null) {
            throw new BadRequestException(ErrorCode.NO_ID);
        }

        LocalDate startDate = meeting.getStartDate();
        List<MeetingTimePriority> meetingTimePriorities = requestDto.getAvailableTimes().stream().map(availabeTimeDto -> {
            MeetingTimePriority meetingTimePriority = MeetingTimePriority.builder()
                    .meetingId(meetingId)
                    .name(requestDto.getName())
                    .startTime(IdxToDateTimeConverter.convert(availabeTimeDto.getStartTimeIdx(), startDate, IdxToDateTimeConverter.START))
                    .endTime(IdxToDateTimeConverter.convert(availabeTimeDto.getEndTimeIdx(), startDate, IdxToDateTimeConverter.END))
                    .priority(availabeTimeDto.getPriority())
                    .build();

            return mongoTemplate.insert(meetingTimePriority);
        }).toList();

        return meetingTimePriorities.stream().map(MeetingTimePriorityCreateResponseDto::of).toList();
    }
}
