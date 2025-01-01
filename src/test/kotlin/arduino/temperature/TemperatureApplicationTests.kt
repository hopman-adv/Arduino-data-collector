package arduino.temperature

import io.github.oshai.kotlinlogging.KotlinLogging
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

val log = KotlinLogging.logger {}

@Testcontainers
@SpringBootTest
class MyDatabaseTests {

	companion object {
		@Container
		@ServiceConnection
		val postgresContainer = PostgreSQLContainer<Nothing>("postgres:15.2")
	}

	@Test
	fun testDatabaseConnection() {
		log.info { "Testing database connection" }
	}
}