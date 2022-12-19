package Domain;

import static spark.Spark.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.Request;
import spark.Response;
import spark.Route;

import spark.Filter;
import spark.Request;
import spark.Response;

public class PHPConnection {
	static Backend backend = new Backend();

	static Gson gsonBuilder = new Gson();

	public static void main(String[] args){

		get("/machine/", (request, response) -> {
			try {
				return backend.getMachines();
			} catch (Exception e) {
				return e.getMessage();
			}
		});

		get("/machine/:id", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			System.out.println("sent id for machine: " + machineId);
			return "machine: " + machineId;
		});

		get("/machine/:id/data", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			System.out.println("sent data for machine: " + machineId);
			return "machine: " + machineId;
		});
		
		get("/machine/:id/inventory", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			System.out.println("sent inventory for machine: " + machineId);
			return gsonBuilder.toJson(backend.getInventory(machineId));
		});

		get("/machine/:id/temperature", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			System.out.println("sent temperature");
			return backend.getTemperature(machineId);
		});

		get("/machine/:id/vibration", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			System.out.println("sent vibration");
			return backend.getVibration(machineId);
		});

		get("/machine/:id/humidity", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			System.out.println("sent humidity");
			return backend.getHumidity(machineId);
		});

		get("/machine/:id/batch/good", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			System.out.println("sent good");
			return backend.getGood(machineId);
		});

		get("/machine/:id/batch/bad", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			System.out.println("sent bad");
			return backend.getBad(machineId);
		});

		get("/machine/:id/batch/produced", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			System.out.println("sent produced");
			return backend.getProduced(machineId);
		});

		get("/machine/:id/batch/produce_amount", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			System.out.println("sent produce_amount");
			return backend.getProduceAmount(machineId);
		});
		
		get("/hello", (request, response) -> "Hello World!");
		
		get("/machine/:id/command/reset/", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			backend.writeCommand(machineId, 1);
			backend.confirmCommand(machineId);
			System.out.println("Reset Command Received");
			return "reset machine: " + machineId;
		});

		get("/machine/:id/command/start/", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			backend.writeCommand(machineId, 2);
			backend.confirmCommand(machineId);
			System.out.println("Start Command Received");
			return "start machine: " + machineId;
		});

		get("/machine/:id/command/stop/", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			backend.writeCommand(machineId, 3);
			backend.confirmCommand(machineId);
			System.out.println("Stop Command Received");
			return "stop machine: " + machineId;
		});

		get("/machine/:id/command/abort/", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			backend.writeCommand(machineId, 4);
			backend.confirmCommand(machineId);
			System.out.println("Stop Command Received");
			return "abort machine: " + machineId;
		});

		get("/machine/:id/command/clear/", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			backend.writeCommand(machineId, 5);
			backend.confirmCommand(machineId);
			System.out.println("Stop Command Received");
			return "clear machine: " + machineId;
		});

		get("/machine/:id/command/setproducedamount/:amount/", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			int amount = Integer.parseInt(request.params("amount"));
			try {
				backend.setProduceAmount(machineId, amount);
			} catch (IllegalArgumentException e) {
				response.status(400);
				System.out.println("Amount out of range");
				return "Amount out of range";
			}
			System.out.println("changed machine " + machineId + " amount to " + amount);
			return "changed machine " + machineId + " amount to " + amount;
		});

		get("/machine/:id/command/speed/:recipe/:speed/", (request, response) -> {
			String res = request.params("id");
			int machineId = Integer.parseInt(res);
			int recipe = Integer.parseInt(request.params("recipe"));
			float speed = Float.parseFloat(request.params("speed"));
			try {
				backend.setMachineSpeed(recipe, speed);
			} catch (IllegalArgumentException e) {
				response.status(400);
				System.out.println("Speed value out of range for this recipe");
				return "Speed value out of range for this recipe";
			}
			System.out.println("changed machine " + machineId + " recipe " + recipe + " to speed " + speed);
			return "changed machine " + machineId + " recipe " + recipe + " to speed " + speed;
		});

		after((Filter) (request, response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			response.header("Access-Control-Allow-Methods", "GET");
		}) ;

		//init();
	}
}