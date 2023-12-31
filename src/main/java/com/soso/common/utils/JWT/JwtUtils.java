package com.soso.common.utils.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.micrometer.common.util.StringUtils;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    private static final String SECRET_KEY = generateSecretKey(); // 시크릿 키
    private static final int SECRET_KEY_LENGTH = 32; // 256비트, 32바이트
    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000; // 토큰 만료 시간 (24시간)

    // JWT 생성
    public static String generateJwtToken(String email, String loginId, String name, String team) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("iss", "soso_server");
        claims.put("email", email);
        claims.put("loginId", loginId);
        claims.put("name", name);
        if(!StringUtils.isBlank(team)){
            claims.put("teamId", team);
        }
        if(email.equals("alstntjddms@naver.com")){
            claims.put("roles", "admin");
        }else{
            claims.put("roles", "user");
        }


        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    // JWT 검증
    public static boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // JWT에서 사용자명 추출
    public static Claims getJwtTokenClaims(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    // 무작위 문자열로 SECRET_KEY 생성
    private static String generateSecretKey() {
        byte[] randomBytes = new byte[SECRET_KEY_LENGTH];
        new SecureRandom().nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }
}
