package com.dmzcoding.walnuts.config

import com.dmzcoding.walnuts.defaults.DefaultComponents
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import javax.annotation.PostConstruct

@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig : WebSecurityConfigurerAdapter(){

    val log = LoggerFactory.getLogger(SecurityConfig::class.java)

    @PostConstruct
    fun onCreate(){
        println("=================================== configure web: WebSecurity")
        val hints = """
            Just to recap, the major building blocks of Spring Security that we’ve seen so far are:
            SecurityContextHolder, to provide access to the SecurityContext.
            SecurityContext, to hold the Authentication and possibly request-specific security information.
            Authentication, to represent the principal in a Spring Security-specific manner.
            GrantedAuthority, to reflect the application-wide permissions granted to a principal.
            UserDetails, to provide the necessary information to build an Authentication object from your application’s DAOs or other source of security data.
            UserDetailsService, to create a UserDetails when passed in a String-based username (or certificate ID or the like).
        """
        println(hints)
    }

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers("/assets/**","/webjars/**")
        super.configure(web)
    }

    override fun configure(http: HttpSecurity) {

        //http.authorizeRequests().antMatchers("/*").authenticated()
        http.authorizeRequests().antMatchers("/*").permitAll()

        http.formLogin().loginPage("/login").permitAll()

        http.logout().logoutUrl("/logout")
                .logoutSuccessUrl("/").permitAll()

        log.info("SecurityConfigurerInited")
        super.configure(http)

    }

}
