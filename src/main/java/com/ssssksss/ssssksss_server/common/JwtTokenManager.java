package com.ssssksss.ssssksss_server.common;

import com.ssssksss.ssssksss_server.userContainer.dao.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.time.LocalDate;
import java.util.Date;

/**
 * PackageName : com.ssssksss.ssssksss_server.common
 * FileName : JwtTokenManager
 * Author : 이 수 경
 * Date : 2022-02-09
 * Description :
 */
public class JwtTokenManager {
    private long ACCESS_TOKEN_VALIDATION_SECOND = 60 * 30 * 1000; //30분
    private long REFRESH_TOKEN_VALIDATION_SECOND = 60 * 60 * 24 * 30 * 1000;

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationTime")
    private String jwtExpirationTime;

    private static final String secretkey = "ssssksssssssksssssssksssssssksssssssksssssssksssssssksssssssksssssssksssssssksss";
    private byte[] encodingKey = DatatypeConverter.parseBase64Binary(secretkey);
    private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    private Key key = Keys.hmacShaKeyFor(encodingKey);
    public String createAccessToken(User user) {
        Date date = new Date();
        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + ACCESS_TOKEN_VALIDATION_SECOND)) // 토큰 만료 시간
                .setNotBefore(new Date(date.getTime())) // 토큰 활성 날짜
                .claim("email",user.getEmail()) //미등록 클레임
//                .claim("role", user.getRole())
                .signWith(key)
                .compact(); // 설정끝
    }
    public String createRefreshToken(User user) {
        Date date = new Date();
        return Jwts.builder()
                .setHeaderParam("typ","JWT") //토큰 타입
                .setIssuedAt(date) //토큰 발행 시간
                .setExpiration(new Date(date.getTime() + REFRESH_TOKEN_VALIDATION_SECOND)) // 토큰 만료 시간
                .setNotBefore(new Date(date.getTime())) // 토큰 활성 날짜
                .signWith(key)
                .compact(); // 설정끝
    }
    public Claims validRefreshTokenAndReturnBody(String token) {
        Claims claims = null;
        try {
            return claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }catch(ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
        }
        finally {
            return  claims;
        }
    }
    public Claims validTokenAndReturnBody(String token) {
        Claims claims = null;

        try {
            return claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }catch(ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
        }
        finally {
            return  claims;
        }
    }
    //    만료된 액세스 토큰에서 데이터 추출
    public Claims expiredTokenAndReturnBody(String token) {
        Claims claims = null;

        try {
            return claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }catch(UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
        }
        finally {
            return  claims;
        }
    }

    // 토큰 만료
    public Boolean isTokenExpired(String token){
        Date expiration = validTokenAndReturnBody(token).getExpiration();
        return expiration.before(new Date());
    }
}
