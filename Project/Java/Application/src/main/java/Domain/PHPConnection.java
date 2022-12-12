package Domain;

import static spark.Spark.*;

import spark.Request;
import spark.Response;
import spark.Route;

import spark.Filter;
import spark.Request;
import spark.Response;

public class PHPConnection {
	static Backend backend = new Backend();
	public static void main(String args[]) throws Exception {

		get("/machine/", (request, response) -> {
			try {
				return backend.getMachines();
			} catch (Exception e) {
				return e.getMessage();
			}
		});

		get("/machine/:id", (request, response) -> {
			String res = request.params("id");
			System.out.println(res);
			int machineId = Integer.parseInt(res);
			return "machine: " + machineId;
		});

		get("/machine/:id/data", (request, response) -> {
			String res = request.params("id");
			System.out.println(res);
			int machineId = Integer.parseInt(res);
			return "machine: " + machineId;
		});
		
		get("/machine/:id/inventory", (request, response) -> {
			String res = request.params("id");
			System.out.println(res);
			int machineId = Integer.parseInt(res);
			return backend.getInventory(machineId);
		});

		get("/machine/:id/temperature", (request, response) -> {
			String res = request.params("id");
			System.out.println(res);
			int machineId = Integer.parseInt(res);
			return backend.getTemperature(machineId);
		});

		get("/machine/:id/vibration", (request, response) -> {
			String res = request.params("id");
			System.out.println(res);
			int machineId = Integer.parseInt(res);
			return backend.getVibration(machineId);
		});

		get("/machine/:id/humidity", (request, response) -> {
			String res = request.params("id");
			System.out.println(res);
			int machineId = Integer.parseInt(res);
			return backend.getHumidity(machineId);
		});
		
		post("/hello", (request, response) -> "Hello World!");
		
		post("/machine/:id/command/reset", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			backend.writeCommand(machineId, 1);
			backend.confirmCommand(machineId);
			return "reset machine: " + machineId;
		});
		
		post("/machine/:id/command/start", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			backend.writeCommand(machineId, 2);
			backend.confirmCommand(machineId);
			return "start machine: " + machineId;
		});
		
		post("/machine/:id/command/stop", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			backend.writeCommand(machineId, 3);
			backend.confirmCommand(machineId);
			return "stop machine: " + machineId;
		});
		
		post("/machine/:id/command/abort", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			backend.writeCommand(machineId, 4);
			backend.confirmCommand(machineId);
			return "abort machine: " + machineId;
		});
		
		post("/machine/:id/command/clear", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			backend.writeCommand(machineId, 5);
			backend.confirmCommand(machineId);
			return "clear machine: " + machineId;
		});

		post("/machine/:id/command/speed/:batch/:speed", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			int batch = Integer.parseInt(request.params("batch"));
			float speed = Float.parseFloat(request.params("speed"));
			backend.writeCommand(machineId, 5);
			backend.confirmCommand(machineId);
			return "changed machine " + machineId + "batch " + batch+ " to speed " + speed;
		});

		after((Filter) (request, response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			response.header("Access-Control-Allow-Methods", "GET");
		});


		//init();
	}
}