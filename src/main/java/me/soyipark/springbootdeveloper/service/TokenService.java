package me.soyipark.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.soyipark.springbootdeveloper.config.jwt.TokenProvider;
import me.soyipark.springbootdeveloper.domain.User;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken) {
        //토큰 유효성 검사 실패 시 예외 발생
        if(!tokenProvider.validToken(refreshToken)){
            throw new IllegalArgumentException("Unexpected token");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);

        //userId로 찾은 user 객체의 정보를 바탕으로 토큰 생성
        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
