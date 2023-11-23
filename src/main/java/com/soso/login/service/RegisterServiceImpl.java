package com.soso.login.service;

import com.soso.login.dto.RegisterMemberDTO;
import com.soso.login.dto.CertifiedCodeDTO;
import com.soso.login.repository.CertifiedCodeRepository;
import com.soso.login.repository.itf.RegisterRAO;
import com.soso.login.service.itf.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;


@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    RegisterRAO rao;

    @Override
    public boolean checkIdDuplicated(String loginId) {
        return false;
    }

    @Override
    public boolean sendCertifiedToMail(String email) {
        System.out.println("email = " + email);
        // 무작위 코드를 생성

        // 무작위 코드를 이메일로 전송

        // 무작위 코드를 repository에 저장
        CertifiedCodeRepository.repository.add(
                new CertifiedCodeDTO(email, "test", new Timestamp(System.currentTimeMillis())));

        System.out.println("CertifiedCodeRepository.repository = " + CertifiedCodeRepository.repository);
        return false;
    }

    @Override
    public boolean checkMailFromCertifiedCode(String email, String certifiedCode) {
        return false;
    }

    @Override
    public String registerMember(RegisterMemberDTO registerMemberDTO) {
        return null;
    }
}
