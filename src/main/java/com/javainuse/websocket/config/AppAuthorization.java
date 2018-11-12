package com.javainuse.websocket.config;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * Indicates that an annotated class is a "Service", originally defined by
 * Domain-Driven Design (Evans, 2003) as "an operation offered as an interface
 * that stands alone in the model, with no encapsulated state."
 * May also indicate that a class is a "Business Service Facade" (in the Core J2EE patterns sense),
 * or something similar. This annotation is a general-purpose stereotype and individual
 * teams may narrow their semantics and use as appropriate.
 * This annotation serves as a specialization of @Component, allowing for implementation classes
 * to be autodetected through classpath scanning.
 */
@Service
public class AppAuthorization {
    /**
     * Java 5 annotation for describing service layer security attributes.
     * The Secured annotation is used to define a list of security configuration attributes for business methods.
     * This annotation can be used as a Java 5 alternative to XML configuration.
     * @return
     */
    @Secured("ROLE_USER")
    public String secure() {
        return "Connection Secured";
    }

    /**
     * Annotation for specifying a method access-control
     * expression which will be evaluated to decide whether a
     * method invocation is allowed or not.
     * @return connection authorization status
     */
    @PreAuthorize("true")
    public String authorized() {
        return "Connection Authorized";
    }
    /**
     * Annotation for specifying a method access-control
     * expression which will be evaluated to decide whether a
     * method invocation is allowed or not.
     * @return connection authorization status
     */
    @PreAuthorize("false")
    public String denied() {
        return "Connection Denied";
    }

}