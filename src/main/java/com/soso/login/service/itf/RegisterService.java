package com.soso.login.service.itf;

import com.soso.login.dto.LoginMemberDTO;
import com.soso.login.dto.RegisterMemberDTO;

import java.util.HashMap;

public interface RegisterService {

    /**
     * 중복된 아이디가 있는지 확인한다.
     * @param loginId
     * @return
     */
    public boolean checkIdDuplicated(String loginId);

    /**
     * 이메일 인증번호를 전송한다.
     * @param email
     * @return
     */
    public boolean sendCertifiedToMail(String email);

    /**
     * 이메일 인증번호를 검증한다.
     * @param email
     * @return
     */
    public boolean checkMailFromCertifiedCode(String email, String certifiedCode);


    /**
     * 멤버를 등록한다.
     * @param registerMemberDTO
     * @return loginId
     */
    public String registerMember(RegisterMemberDTO registerMemberDTO);
}