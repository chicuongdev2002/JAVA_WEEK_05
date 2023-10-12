package vn.edu.fit.iuh.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//@EnableJpaRepositories(basePackages = {"vn.edu.fit.iuh.repositories"})
@EntityScan(basePackages = {"vn.edu.fit.iuh.enities"})
public class AppConfig {
}
