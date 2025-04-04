package arduino.temperature.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**") // Allow CORS for all endpoints
            .allowedOriginPatterns("*") // Allow all origins
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify allowed methods
            .allowedHeaders("*") // Allow all headers
    }
}