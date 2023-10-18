package kr.co.helloplum.common.exception;

import kr.co.helloplum.common.statusCode.ErrorCode;
import lombok.Getter;

@Getter
public class ForbiddenException extends RuntimeException {
	private final ErrorCode code;

	public ForbiddenException(ErrorCode code) {
		super(code.getMessage());
		this.code = code;
	}
}
