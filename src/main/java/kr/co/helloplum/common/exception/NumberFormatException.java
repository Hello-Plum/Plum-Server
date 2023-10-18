package kr.co.helloplum.common.exception;

import kr.co.helloplum.common.statusCode.ErrorCode;

public class NumberFormatException extends RuntimeException {
	private final ErrorCode code;

	public NumberFormatException(ErrorCode code) {
		super(code.getMessage());
		this.code = code;
	}
}