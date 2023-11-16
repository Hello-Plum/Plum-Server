package kr.co.helloplum.service;

import kr.co.helloplum.dto.MeetingGetResponseDto;
import kr.co.helloplum.dto.MeetingOwnerPostRequestDto;
import kr.co.helloplum.dto.MeetingOwnerPostResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import kr.co.helloplum.domain.Meeting;
import kr.co.helloplum.dto.MeetingCreateRequestDto;
import kr.co.helloplum.dto.MeetingCreateResponseDto;
import kr.co.helloplum.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MeetingService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public MeetingCreateResponseDto createMeeting(MeetingCreateRequestDto requestDto) {
		Meeting meeting = Meeting.builder()
			.name(requestDto.getName())
			.startDate(requestDto.getStartDate())
			.endDate(requestDto.getEndDate())
			.place(requestDto.getPlace())
			.placeDetail(requestDto.getPlaceDetail())
			.host(requestDto.getHost())
			.password(requestDto.getPassword())
			.info(requestDto.getInfo())
			.build();

		Meeting savedMeeting = mongoTemplate.insert(meeting);
		return MeetingCreateResponseDto.of(meeting);
	}

	public MeetingGetResponseDto getMeeting(String meetingId) {
		Meeting meeting = mongoTemplate.findOne(
				Query.query(Criteria.where("_id").is(meetingId)),
				Meeting.class
		);
		return MeetingGetResponseDto.of(meeting);
	}

	public MeetingOwnerPostResponseDto checkOwner(String meetingId, MeetingOwnerPostRequestDto requestDto) {
		Meeting meeting = mongoTemplate.findOne(
				Query.query(Criteria.where("_id").is(meetingId)),
				Meeting.class
		);
		return MeetingOwnerPostResponseDto.of(requestDto.getPassword().equals(meeting.getPassword()));
	}
}
