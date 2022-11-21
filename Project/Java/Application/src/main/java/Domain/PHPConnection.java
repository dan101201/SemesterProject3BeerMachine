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
		
		post("/hello", (request, response) -> {
			System.out.println("POST");
			System.out.println(request.body());
			return response;
		});

		after((Filter) (request, response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			response.header("Access-Control-Allow-Methods", "GET");
		});


		//init();
	}
	
	public void hello(String args[]) {
		System.out.println("Hello World!");
	}
}