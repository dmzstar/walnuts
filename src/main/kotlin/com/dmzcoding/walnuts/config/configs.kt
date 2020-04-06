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