package kr.co.helloplum.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class AvailabeTimeDto {

    @Range(max = 237, message = "startTimeIdx must be between 0 and 237")
    private int startTimeIdx;

    @Range(max = 237, message = "endTimeIdx must be between 0 and 237")
    private int endTimeIdx;

    @Range(min = 1, max = 3, message = "priority must be between 1 and 3")
    private int priority;
}
