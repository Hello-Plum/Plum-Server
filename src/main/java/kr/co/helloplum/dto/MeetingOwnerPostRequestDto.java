package kr.co.helloplum.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MeetingOwnerPostRequestDto {

    @NotBlank(message = "password 값이 없습니다.")
    @Size(max = 10, message = "password는 10자 이하만 가능합니다.")
    private String password;
}
