package Data;

import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;

public record SensorData(int vibration, int humidity, int temperature, DateTime timestamp) {
}
