package com.jair.velazquez.volga.config;

import org.springframework.stereotype.Component;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;
import java.util.Objects;

@Component
public class AuthorizationValidator {

    public boolean hasRole(Jwt jwt, VolgaRoles role) {
        Object groupsObj = jwt.getClaims().get("cognito:groups");

        if (groupsObj instanceof List<?>) {
            List<String> roles = ((List<?>) groupsObj).stream()
                    .filter(Objects::nonNull)
                    .map(Object::toString)
                    .map(String::toLowerCase)
                    .toList();

            return roles.contains(role.toString().toLowerCase());
        }
        if (groupsObj instanceof String) {
            return ((String) groupsObj).equalsIgnoreCase(role.toString());
        }
        return false;
    }
}