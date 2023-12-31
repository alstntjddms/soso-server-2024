package com.soso.login.service.itf;

import com.soso.login.dto.LoginMemberDTO;
import com.soso.login.dto.MemberDTO;
import com.soso.domain.dto.TeamDTO;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

public interface LoginService {

    /**
     * 로그인을 검증하고 사용자정보와 jwt를 response한다.
     * @param loginMemberDTO
     * @return
     */
    public MemberDTO loginMember(LoginMemberDTO loginMemberDTO, HttpServletResponse res) throws Exception;

    /**
     * 비밀번호를 잃어버렸을 경우 이메일과 아이디를 받고, 이메일로 임시비밀번호를 전달한다.
     * @param email
     * @param loginId
     * @return
     */
    public boolean findPassword(String email, String loginId);

    /**
     * 로그인한 멤버정보를 조회한다.
     * @param sosoJwtToken
     * @return
     */
    public HashMap<String, String> findLoginMember(String sosoJwtToken);


}
