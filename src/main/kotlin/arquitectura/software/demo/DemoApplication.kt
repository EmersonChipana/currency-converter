package arquitectura.software.demo

import org.keycloak.adapters.KeycloakConfigResolver
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@SpringBootApplication
@Configuration
@EnableDiscoveryClient
class DemoApplication{

	@Bean
	fun KeycloakConfigResolver(): KeycloakConfigResolver? {
		return KeycloakSpringBootConfigResolver()
	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
