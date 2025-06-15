package com.example.Trusttalk.config;

import com.example.Trusttalk.filter.JwtHandshakeInterceptor;
import com.example.Trusttalk.util.JwtUtil; // ✅ Apne JWT util ka import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // ✅ Inject JwtUtil to use inside interceptor
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("topic"); // ✅ Outgoing messages (subscribed)
        config.setApplicationDestinationPrefixes("/app"); // ✅ Incoming messages from frontend
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // ✅ Registering endpoint + JWT handshake interceptor
        registry.addEndpoint("/server1")
                .setAllowedOriginPatterns("*")
                .addInterceptors(new JwtHandshakeInterceptor(jwtUtil)) // 🔒 JWT validate here
               .withSockJS(); // Fallback for browsers
    }
}
