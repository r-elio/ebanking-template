package ph.com.aub.ebanking.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        .antMatchers("/resources/**").permitAll()
                        .antMatchers("/").permitAll()
                        .antMatchers("/dashboard/**").hasRole("USER")
                        .antMatchers("/personal/**").hasRole("PERSONAL")
                        .antMatchers("/corporate/**").hasRole("CORPORATE")
                        .anyRequest().denyAll())
                .csrf(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .logout((logout) -> logout
                        .logoutSuccessUrl("/")
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true)
                        .permitAll());
        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails personal = User.builder()
                .username("personal_user")
                .password(passwordEncoder().encode("personal"))
                .roles("USER", "PERSONAL")
                .build();
        UserDetails corporate = User.builder()
                .username("corporate_user")
                .password(passwordEncoder().encode("corporate"))
                .roles("USER", "CORPORATE")
                .build();
        return new InMemoryUserDetailsManager(personal, corporate);
    }
}
