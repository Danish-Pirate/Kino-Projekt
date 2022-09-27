package group3.kino.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//kilde: https://stackoverflow.com/questions/54758872/spring-boot-security-postman-gives-401-unauthorized?noredirect=1&lq=1
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

   @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST,"/createBooking").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.PUT,"/editBooking").permitAll()
                .antMatchers(HttpMethod.DELETE,"/deleteBooking").permitAll()
                .antMatchers(HttpMethod.GET,"/getAll").permitAll()
                .antMatchers(HttpMethod.POST,"/addMovie").permitAll()
                .antMatchers(HttpMethod.GET,"/getAllMovie").permitAll()
                .antMatchers(HttpMethod.PUT,"/editMovie").permitAll()
                .antMatchers(HttpMethod.POST,"deleteMovie").permitAll()

                .anyRequest().authenticated();
    }
}