package net.moncef.inventoryservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
     private JwtAuthConverter jwtAuthConverter ;
    SecurityConfig (JwtAuthConverter jwtAuthConverter) {
        this.jwtAuthConverter = jwtAuthConverter ;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .oauth2ResourceServer(o2->o2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter)))// Resource Server OAuth2 qui va protéger mes endpoints et vérifier automatiquement les JWT
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .headers(h->h.frameOptions(fo->fo.disable()))
                .authorizeHttpRequests(ar -> ar
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/api/products").hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                )
                .build();
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));//Autorise tous les domaines :example http://localhost:4200
        configuration.setAllowedMethods(Arrays.asList("*"));//Autoriser toutes les méthodes HTTP : get post ...
        configuration.setAllowedHeaders(Arrays.asList("*"));// Autoriser tous les headers
        configuration.setExposedHeaders(Arrays.asList("*")); // Permet au frontend d’accéder aux headers dans la réponse HTTP
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);//toutes les routes de l’application
        return source;
    }
}

