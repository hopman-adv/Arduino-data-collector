package arduino.temperature.repository

import arduino.temperature.entity.Temperature
import org.springframework.data.jpa.repository.JpaRepository

interface TemperatureRepository : JpaRepository<Temperature, Long> {
}