package com.javainuse.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Indicates that a class declares one or more @Bean methods and may be processed by the Spring container
 * to generate bean definitions and service requests for those beans at runtime.
 * As an alternative to registering @Configuration classes directly against an AnnotationConfigApplicationContext,
 * @Configuration classes may be declared as normal <bean> definitions within Spring XML files.
 */
@Configuration
/**
 * Add this annotation to an @Configuration class to configure processing WebSocket requests.
 */
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    /**
     * Register web socket request handlers
     * @param registry Configure a WebSocketHandler at the specified URL paths.
     */
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new SocketTextHandler(), "/user");
	}

}