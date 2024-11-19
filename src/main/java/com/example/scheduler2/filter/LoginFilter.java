package com.example.scheduler2.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

public class LoginFilter implements Filter {

    private static final String[] WHITELIST = {"/", "/members/signup", "/login", "/logout"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain Chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if(!isWhitelist(requestURI)) {

            HttpSession session = httpRequest.getSession(false);

            if(session == null || session.getAttribute("sessionKey") == null) {
                httpResponse.sendError(401,"로그인 하세요.");
                return;
            }
        }

        Chain.doFilter(request, response);

    }

    private boolean isWhitelist(String requestURI) {

        return PatternMatchUtils.simpleMatch(WHITELIST, requestURI);

    }
}
