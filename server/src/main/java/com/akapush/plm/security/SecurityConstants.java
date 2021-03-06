package com.akapush.plm.security;

public class SecurityConstants {
	public static final String SECRET = "unjourmonprinceviendra";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/api/register";
	public static final String SIGN_IN_URL = "/api/auth";
	public static final String CSV_URL = "/api/export/csv/**";
}