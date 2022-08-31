package com.dctmz.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dctxf
 */
@Slf4j
@AllArgsConstructor
public class JwtUtils {

    private static String JWT_ISSUSER;
    private static long JWT_EXPIRE;
    private static String JWT_CLAIM;

    /**
     * 生成jwt token
     *
     * @param uid    用户唯一id
     * @param secret 用户密码
     * @return token
     */
    public static String sign(String uid, String secret, String sub) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withIssuer(JWT_ISSUSER)
                .withIssuedAt(new Date())
                .withSubject(sub)
                .withExpiresAt(DateUtils.addMillisecond(JWT_EXPIRE))
                .withClaim(JWT_CLAIM, uid)
                .sign(algorithm);

    }

    public static Boolean verify(String token, String uid, String secret, String sub) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(JWT_ISSUSER)
                    .withClaim(JWT_CLAIM, uid)
                    .withSubject(sub)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            log.warn(e.getMessage());
            return false;
        }
    }

    /**
     * token是否过期
     *
     * @return true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

    public static DecodedJWT decodedJWT(String token) {
        return JWT.decode(token);
    }
}
