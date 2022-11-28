package Data;

import java.util.LinkedList;

public record Batch(
		int recipeId, Machine machine, int totalBeers, int productionSpeed, int failedBeers, int successfulBeers,
		LinkedList<SensorData> sensorData) {
	
}
