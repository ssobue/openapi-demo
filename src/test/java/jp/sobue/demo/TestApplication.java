package jp.sobue.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Class for Test.
 *
 * @author Sho SOBUE
 * @see Application
 */
@SpringBootApplication
public class TestApplication {

  /**
   * Main method.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    SpringApplication
        // use main
        .from(Application::main)
        // Launch Application with MySQL using Testcontainers.
        .with(ContainerConfiguration.class)
        .run(args);
  }
}
