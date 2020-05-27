package com.chiragbohet.ecommerce.utilities;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.ofNullable("UNAUTHENTICATED");
        }

        Optional<String> currentLoggedInUser = Optional.ofNullable(authentication.getName());

        return currentLoggedInUser;
    }
}