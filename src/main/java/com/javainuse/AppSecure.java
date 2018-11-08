package com.javainuse;



import com.javainuse.websocket.config.AppAuthorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
/**
 * Enable auto-configuration of the Spring Application Context, attempting to guess and configure beans
 * that you are likely to need. Auto-configuration classes are usually applied based on your classpath
 * and what beans you have defined. For example, if you have tomcat-embedded.jar on your classpath you
 * are likely to want a TomcatServletWebServerFactory (unless you have defined your own ServletWebServerFactory bean).
 * When using SpringBootApplication, the auto-configuration of the context is automatically enabled and
 * adding this annotation has therefore no additional effect.
 *
 * Auto-configuration tries to be as intelligent as possible and will back-away as you define more of your
 * own configuration. You can always manually exclude() any configuration that you never want to apply
 * (use excludeName() if you don't have access to them). You can also exclude them via the
 * spring.autoconfigure.exclude property. Auto-configuration is always applied after
 * user-defined beans have been registered.
 *
 * The package of the class that is annotated with @EnableAutoConfiguration, usually via @SpringBootApplication,
 * has specific significance and is often used as a 'default'. For example, it will be used when scanning for
 * @Entity classes. It is generally recommended that you place @EnableAutoConfiguration
 * (if you're not using @SpringBootApplication) in a root package so that all sub-packages
 * and classes can be searched.
 *
 * Auto-configuration classes are regular Spring Configuration beans.
 * They are located using the SpringFactoriesLoader mechanism (keyed against this class).
 * Generally auto-configuration beans are @Conditional beans (most often using @ConditionalOnClass
 * and @ConditionalOnMissingBean annotations).
 */
//@EnableAutoConfiguration
/**
 * Configures component scanning directives for use with @Configuration classes. Provides support parallel
 * with Spring XML's <context:component-scan> element.
 * Either basePackageClasses() or basePackages() (or its alias value()) may be specified to define
 * specific packages to scan. If specific packages are not defined, scanning will occur from the
 * package of the class that declares this annotation.
 *
 * Note that the <context:component-scan> element has an annotation-config attribute; however, this annotation
 * does not. This is because in almost all cases when using @ComponentScan,
 * default annotation config processing (e.g. processing @Autowired and friends) is assumed.
 * Furthermore, when using AnnotationConfigApplicationContext, annotation config processors are always registered,
 * meaning that any attempt to disable them at the @ComponentScan level would be ignored.
 */
//@ComponentScan
/**
 * Enables Spring Security global method security similar to the <global-method-security> xml support.
 *
 * More advanced configurations may wish to extend GlobalMethodSecurityConfiguration and override the
 * protected methods to provide custom implementations. Note that EnableGlobalMethodSecurity
 * still must be included on the class extending GlobalMethodSecurityConfiguration to determine the settings.
 */
//@EnableGlobalMethodSecurity(securedEnabled = false, prePostEnabled = false)
public class AppSecure implements CommandLineRunner {
    /**
     * Marks a constructor, field, setter method or config method as to be autowired by Spring's dependency
     * injection facilities.
     * This is an alternative to the JSR-330 Inject annotation, adding required-vs-optional semantics.
     * Only one constructor (at max) of any given bean class may declare this annotation with the 'required'
     * parameter set to true, indicating the constructor to autowire when used as a Spring bean. If multiple
     * non-required constructors declare the annotation, they will be considered as candidates for autowiring.
     * The constructor with the greatest number of dependencies that can be satisfied by matching beans in the
     * Spring container will be chosen. If none of the candidates can be satisfied, then a primary/default
     * constructor (if present) will be used. If a class only declares a single constructor to begin with,
     * it will always be used, even if not annotated. An annotated constructor does not have to be public.
     *
     * Fields are injected right after construction of a bean, before any config methods are invoked.
     * Such a config field does not have to be public.
     */
    @Autowired
    private AppAuthorization service;

    @Override
    public void run(String... args) throws Exception {
        /*
        SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken("user", "N/A",
                        AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER")));
        try {
            System.out.println(this.service.secure());
        }
        finally {
            SecurityContextHolder.clearContext();
        }
        */
    }

    public static void main(String[] args) {

        SpringApplication.run(AppSecure.class);
    }

}