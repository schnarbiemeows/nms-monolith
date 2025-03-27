package com.schnarbiesnmeowers.nmsmonolith.utilities;

public class Constants {
    public static final String YES = "Y";
    public static final String NO = "N";
    public static final int BRAND_ID_FOR_RECIPE = 62;
    public static final int INGREDIENT_TYPE_ID_FOR_RECIPE = 183;
    public static final int SERVING_TYPE_ID_FOR_RECIPE = 15;
    public static final String SERVINGS = "serving";
    public static final long EXPIRATION_TIME = 432_000_000; // 5 days expressed in milliseconds
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String AUTHORIZATION = "Authorization";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String COMPANY = "schnarbies-n-meowers";
    public static final String COMPANY_ADMINISTRATION = "User Management Portal";
    public static final String AUTHORITIES = "authorities";
    public static final String FORBIDDEN_MESSAGE = "Please log in to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this page";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    public static final String[] PUBLIC_URLS = {
            "/user/confirmemail/**",
            "/healthcheck/ping",
            "/user/login",
            "/user/register",
            "/user/forgotpassword/**",
            "/user/forgotusername/**",
            "/user/image/**",
            "/user/setpwd",
            "/user/setrole",
            "/user/testemail",
            "/user/checkreset",
            "/user/finalizepassword" };
    public static final int DAYS_BACK = 90;

}
