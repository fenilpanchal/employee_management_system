package com.example.employeemgmt.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;

public class CookieUtils {

    public static Cookie setCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60*60*24);
        return cookie;
    }

    public static boolean isCookieExist(HttpServletRequest httpServletRequest, String key) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (Objects.isNull(cookies) || cookies.length <= 0) {
            return false;
        }
        return Arrays.stream(cookies).anyMatch(cookie -> key.equalsIgnoreCase(cookie.getName()));
    }

    public static Cookie[] removeCookie(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setValue("");
        }
        return cookies;
    }
}
