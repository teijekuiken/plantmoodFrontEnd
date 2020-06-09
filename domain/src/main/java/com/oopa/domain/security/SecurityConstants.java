package com.oopa.domain.security;

import org.springframework.beans.factory.annotation.Value;

public class SecurityConstants {
    @Value("${oop.jwt.secret}")
    public static final String SECRET = "SecretKeyToGenJWTs";

    public static final long EXPIRATION_TIME = 3_600; // 1 hour

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "Authorization";

    public static final String SIGN_UP_URL = "/users/sign-up";
}
