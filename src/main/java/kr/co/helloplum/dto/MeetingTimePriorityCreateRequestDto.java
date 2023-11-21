package kr.co.helloplum.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;

@Getter
public class MeetingTimePriorityCreateRequestDto {

    @NotBlank(message = "name must not be blank")
    @Size(max = 10, message = "The length of name must be under 10")
    private String name;

    @Size(max = 3, message = "The length of availableTimes must be under 3")
    private List<AvailabeTimeDto> availableTimes;
}
