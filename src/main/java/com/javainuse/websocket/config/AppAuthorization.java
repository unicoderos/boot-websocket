package com.javainuse.websocket.config;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Secured("ROLE_USER")
    public String secure() {
        return "Connection Secured";
    }

    @PreAuthorize("true")
    public String authorized() {
        return "Connection Authorized";
    }

    @PreAuthorize("false")
    public String denied() {
        return "Connection Denied";
    }

}