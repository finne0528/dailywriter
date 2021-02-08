package com.dailyreport.dailywriter.config

import org.jetbrains.exposed.sql.Database
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class DatabaseConfig {
    @Autowired
    lateinit var environment: Environment

    //TODO: yaml から取得するようにする
    //TODO: HikariCP をかませたい
    fun getConnection(): Database = Database.connect(
        "jdbc:mysql://localhost:3306/dailywriter?serverTimezone=JST", //environment.getRequiredProperty("database.url"),
        "com.mysql.cj.jdbc.Driver",             //environment.getRequiredProperty("database.driver-class-name"),
        "admin",                                 //environment.getRequiredProperty("database.username"),
        "admin_password",                   //environment.getRequiredProperty("database.password")
    )
}