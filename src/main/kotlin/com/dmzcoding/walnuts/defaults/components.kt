package com.dmzcoding.walnuts.defaults

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import javax.annotation.PostConstruct


class DefaultComponents{

    @Configuration(proxyBeanMethods = false)
    @ConditionalOnMissingBean(value = arrayOf(UserDetailsService::class))
    class SecurityBeansCheck{

        @PostConstruct
        fun onCreate(){
            println("=================================== MissingBean:  UserDetailsService")
        }

    }

    @Configuration(proxyBeanMethods = false)
    @ConditionalOnMissingBean(value = arrayOf(AuthenticationManager::class))
    class AuthenticationManagerCheck{

        @PostConstruct
        fun onCreate(){
            println("=================================== MissingBean:  AuthenticationManager")
        }

    }


    @Configuration(proxyBeanMethods = false)
    @ConditionalOnMissingBean(value = arrayOf(PasswordEncoder::class))
    class PasswordEncoderCheck{

        @PostConstruct
        fun onCreate(){
            println("=================================== MissingBean:  PasswordEncoder")
        }

    }



    @Configuration(proxyBeanMethods = false)
    @ConditionalOnProperty(prefix = "walnuts.security", name = arrayOf("profile") ,havingValue = "mem")
    class MemoryProfile{

        @PostConstruct
        fun onCreate(){

        }

        /**
        @Bean
        @Throws(Exception::class)
        fun userDetailsService(): UserDetailsService? {
            // ensure the passwords are encoded properly
            val users: User.UserBuilder = User.withDefaultPasswordEncoder()
            val manager = InMemoryUserDetailsManager()
            manager.createUser(users.username("user").password("password").roles("USER").build())
            manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build())
            return manager
        }
        */
        
    }

}