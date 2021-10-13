package com.example.demo.rest

import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

class RESTConfig {
    companion object{
        const val DB_URL = "jdbc:mysql://192.168.0.14:3306/mydb"
        const val DB_LOGIN = "FunnCo"
        const val DB_PASSWORD = "8rSPsJE8XBDKIJ0J"
    }
}