package com.simpatitour;

import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

public class Main {
	public static void main(String[] args) {
		port(getHerokuAssignedPort());
		staticFileLocation("/public");
        get("/hello", (req, res) -> "Hello World");
    }

	// test master
	static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		return 4567; // return default port if heroku-port isn't set (i.e. on
						// localhost)
	}
}

