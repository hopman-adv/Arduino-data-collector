package arduino.temperature.controller

import arduino.temperature.entity.Temperature
import arduino.temperature.repository.TemperatureRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class TemperatureController(val temperatureRepository: TemperatureRepository) {

    @GetMapping("/data")
    fun getTemperature(): MutableList<Temperature> {
        return temperatureRepository.findAll()
    }
   
    @PostMapping
    fun createTemperature() {
        temperatureRepository.save(Temperature(value = 25.0, date = LocalDateTime.now()))
    }
}

