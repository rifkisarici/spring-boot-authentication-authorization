package com.auth.ws.configuration;

import com.auth.ws.user.entity.enums.UserRole;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.exceptionHandling().authenticationEntryPoint(new AuthEntryPoint());

        http.headers().frameOptions().disable();

        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, buildEndpoint("logout")).authenticated()
                .antMatchers(HttpMethod.POST, buildEndpoint("education")).authenticated()
                .antMatchers(HttpMethod.POST, buildEndpoint("company")).hasAnyRole(UserRole.EMPLOYER.name(), UserRole.ADMIN.name())
                .antMatchers(HttpMethod.GET,"api/1.0/user/userAll").hasAnyRole(UserRole.CANDIDATE.name(), UserRole.ADMIN.name())
                /*  .antMatchers(HttpMethod.PUT, buildEndpoint("user/{username}")).authenticated()
                  .antMatchers(HttpMethod.POST, buildEndpoint("logout")).authenticated()*/
                .and()
                .authorizeRequests().anyRequest().permitAll();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        /*http.addFilterBefore(tokenFilter(), UsernamePasswordAuthenticationFilter.class);*/

    }

    private String buildEndpoint(String postfix) {
        return String.format("api/1.0/%s", postfix);
    }


}
