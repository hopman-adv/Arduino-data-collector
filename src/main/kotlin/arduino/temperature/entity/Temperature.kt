package arduino.temperature.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "temperature")
data class Temperature(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val value: Double,
    val unit: String = "Celsius",
    val date: LocalDateTime
) {
    constructor() : this(null, 0.0, "Celsius", LocalDateTime.now())
}