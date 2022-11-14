package Domain;

import static spark.Spark.*;

import spark.Request;
import spark.Response;
import spark.Route;

public class PHPConnection {
	public static final String JAVABRIDGE_PORT="8087";
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
		
		post("/hello", (request, response) -> {
			System.out.println("POST");
			System.out.println(request.body());
			return response;
		});
		
		//init();
	}
	
	public void hello(String args[]) {
		System.out.println("Hello World!");
	}
}