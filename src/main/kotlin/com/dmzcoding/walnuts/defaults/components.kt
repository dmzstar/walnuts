package com.dmzcoding.walnuts.defaults

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct


class DefaultComponents{

    @Configuration(proxyBeanMethods = false)
    @ConditionalOnProperty(prefix = "walnuts.security", name = arrayOf("profile") ,havingValue = "mem")
    class MemoryProfile{

        @PostConstruct
        fun onCreate(){
            println("=================================== DefaultComponents")
        }


        fun userService(){

        }

    }

}