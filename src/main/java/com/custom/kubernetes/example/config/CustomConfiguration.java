package com.custom.kubernetes.example.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "custom")
public class CustomConfiguration {

    @Value("${username:application_properties_username}")
    private String username;

    @Value("${pwd:application_properties_pwd}")
    private String pwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public CustomConfiguration() {
    }

    public CustomConfiguration(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

}
