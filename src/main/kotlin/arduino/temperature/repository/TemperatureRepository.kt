package arduino.temperature.repository

import arduino.temperature.entity.Temperature
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface TemperatureRepository : JpaRepository<Temperature, Long> {
    fun findByDateBetween(startDate: LocalDateTime, endDate: LocalDateTime): MutableList<Temperature>
}