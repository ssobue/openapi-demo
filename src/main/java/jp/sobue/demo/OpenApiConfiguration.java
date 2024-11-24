package jp.sobue.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI Configuration.
 *
 * @author Sho SOBUE
 */
@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Management APIs",
        version = "1.0",
        contact = @Contact(
            name = "Sho SOBUE"
        )
    ),
    servers = {
        @Server(
            description = "Local development",
            url = "http://localhost:8080"),
        @Server(
            description = "Test Server",
            url = "https://test.example.com"),
        @Server(
            description = "Production Server",
            url = "https://example.jp"
        )
    }
)
public class OpenApiConfiguration {

}
