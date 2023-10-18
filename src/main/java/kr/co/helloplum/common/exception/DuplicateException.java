package kr.co.helloplum.common.exception;

import kr.co.helloplum.common.statusCode.ErrorCode;
import lombok.Getter;

@Getter
public class DuplicateException extends RuntimeException {
	private final ErrorCode code;

	public DuplicateException(ErrorCode code) {
		super(code.getMessage());
		this.code = code;
	}
}
