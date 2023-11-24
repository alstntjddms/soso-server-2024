package com.soso.common.aop.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExceptionStatus {
    COOKIES_NOT_FOUND("쿠키가 없습니다."),
    JWT_FAIL_VALIDATE("JWT 검증에 실패했습니다."),
    UNKNOWN_ERROR("알수 없는 에러 발생"),
    LOGIN_ID_DUPLICATED("로그인 아이디 중복됨"),
    EMAIL_WRONG_PATTERN("이메일 형식 잘못됨"),
    EMAIL_DUPLICATED("이메일 중복됨"),
    LOGIN_ID_LENGTH("아이디 길이 잘못됨"),
    LOGIN_ID_WRONG("아이디 틀림"),
    PASSWORD_LENGTH("비밀번호 길이 잘못됨"),
    PASSWORD_WRONG("비밀번호 틀림"),
    CERTIFIED_CODE_WRONG("인증번호 틀림"),

    ;

    private final String message;

    public String getStatus(){
        return name();
    }

}