package kr.co.helloplum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MeetingOwnerPostResponseDto {

    private boolean check;

    public static MeetingOwnerPostResponseDto of(boolean check) {
        return new MeetingOwnerPostResponseDto(check);
    }
}
