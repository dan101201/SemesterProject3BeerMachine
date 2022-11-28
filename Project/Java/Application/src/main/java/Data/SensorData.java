package Data;

import java.time.LocalDateTime;

public record SensorData(int vibration, int humidity, int temperature, LocalDateTime timestamp) {
}
