package com.food.ordering.system.order.service.domain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/** 
* Main entry point for the Order Service application
 * Bootstrap for the Spring Boot application, configures component scanning,
 * enables JPA repositories, and specifies entity scanning for data access layers.
 */
@EnableJpaRepositories(basePackages = { 
    "com.food.ordering.system.order.service.dataaccess", 
    "com.food.ordering.system.dataaccess" 
})
// Enables JPA repository support for the specified packages where repository interfaces are defined
@EntityScan(basePackages = { 
    "com.food.ordering.system.order.service.dataaccess",
    "com.food.ordering.system.dataaccess"
})
// Scans the specified packages for JPA entity classes
@SpringBootApplication(scanBasePackages = "com.food.ordering.system")
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}