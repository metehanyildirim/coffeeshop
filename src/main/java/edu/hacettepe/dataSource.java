package edu.hacettepe;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class dataSource extends DriverManagerDataSource {
    public dataSource() {
        // TODO Auto-generated constructor stub
        this.setDriverClassName("org.postgresql.Driver");
        this.setUrl("jdbc:postgresql://localhost:32768/");
        this.setUsername("docker"); this.setPassword("docker");
    }
}
