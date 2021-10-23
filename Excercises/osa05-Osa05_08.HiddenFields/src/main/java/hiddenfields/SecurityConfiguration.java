package hiddenfields;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/messages").authenticated()
                .antMatchers(HttpMethod.POST, "/messages").hasAnyAuthority("POSTER")
                .anyRequest().authenticated();
        http.formLogin()
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");
    }
    
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        List<UserDetails> users = new ArrayList<>();
        
        UserDetails user = User.withDefaultPasswordEncoder()
                                .username("user")
                                .password("password")
                                .authorities("USER")
                                .build();
        
        users.add(user);
        
        UserDetails user2 = User.withDefaultPasswordEncoder()
                                .username("postman")
                                .password("pat")
                                .authorities("POSTER")
                                .build();
        
        users.add(user2);
        
        InMemoryUserDetailsManager userManager = new InMemoryUserDetailsManager(users);
        
        return userManager;
    }
    
}
