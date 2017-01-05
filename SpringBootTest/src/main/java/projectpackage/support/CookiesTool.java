package projectpackage.support;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gvozd on 01.01.2017.
 */
public class CookiesTool {
    public static String searchCookie(String cookieName, HttpServletRequest request) {
        return getCookie(cookieName, request);
    }

    public static boolean aquireCookie(String cookieName, HttpServletRequest request) {
        if (null!=getCookie(cookieName, request)) {
            return true;
        } else return false;
    }

    private static String getCookie(String cookieName, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public static void setCookie(String cookieName, String value, int maxAge, HttpServletResponse response) {
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
