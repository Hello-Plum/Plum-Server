package kr.co.helloplum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import kr.co.helloplum.domain.Meeting;

public interface MeetingRepository extends MongoRepository<Meeting, String> {
}
