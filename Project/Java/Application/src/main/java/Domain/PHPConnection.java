package Domain;

import php.java.bridge.http.JavaBridgeRunner;

import static spark.Spark.*;

import spark.Request;
import spark.Response;
import spark.Route;

public class PHPConnection {
	public static final String JAVABRIDGE_PORT="8087";
	static final JavaBridgeRunner runner = JavaBridgeRunner.getInstance(JAVABRIDGE_PORT);
	
	public static void main(String args[]) throws Exception {
		/*try {
			runner.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);*/
		
		get("/hello", (req, res) -> {
			return "Hello World";
		});
		
		post("/hello", (req, res) -> {
			return req.body();
		});
		
		//init();
	}
	
	public void hello(String args[]) {
		System.out.println("Hello World!");
	}
}