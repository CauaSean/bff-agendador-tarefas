package com.caua.bffagendadortarefas.infrastructure.client.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    /**
     * This interceptor prevents sending null Authorization headers to backend services.
     * If no token is provided, the header is not added to the request.
     * This allows backend services to handle unauthenticated requests gracefully.
     */
    @Override
    public void apply(RequestTemplate template) {
        // Check if Authorization header is null or empty
        if (template.headers().get("Authorization") == null ||
            template.headers().get("Authorization").isEmpty()) {
            // Remove the Authorization header if it's not set
            template.header("Authorization", (String) null);
        }
    }
}

