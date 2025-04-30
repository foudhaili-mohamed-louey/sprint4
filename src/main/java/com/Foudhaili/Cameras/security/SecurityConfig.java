package com.Foudhaili.Cameras.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/showCreate", "/saveCamera").hasAnyRole("ADMIN", "AGENT")
	            .requestMatchers("/modifierCamera", "/updateCamera", "/supprimerCamera").hasRole("ADMIN")
	            .requestMatchers("/ListeCamera", "/").hasAnyRole("ADMIN", "AGENT", "USER")
	            .anyRequest().authenticated()
	        )
	        .formLogin(form -> form
	            .loginPage("/login")
	            .defaultSuccessUrl("/ListeCamera")
	            .permitAll()
	        )
	        .logout(logout -> logout
	            .logoutSuccessUrl("/login?logout")
	            .permitAll()
	        )
	        .httpBasic(Customizer.withDefaults())
	        .exceptionHandling(exception -> exception
	            .accessDeniedPage("/accessDenied")
	        );
	    return http.build();
	}


    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .build();
        
        UserDetails agent = User.withUsername("agent")
                .password(passwordEncoder().encode("123"))
                .roles("AGENT")
                .build();
        
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("123"))
                .roles("USER")
                .build();
        
        return new InMemoryUserDetailsManager(admin, agent, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}