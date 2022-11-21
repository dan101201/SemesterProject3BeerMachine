package Domain;

import Data.Machine;

import java.util.ArrayList;
import java.util.List;

public class Backend {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	Backend() {
		machines.add(new Machine());
	}

	List<Machine> machines = new ArrayList<>();

	public String[] getMachines() {
		List<String> strings = new ArrayList<>();
		for (Machine machine: machines
			 ) {
			strings.add(machine.getName());
		}
		return strings.toArray(new String[0]);
	}

	public float getTemperature(int machineId) {
		return machines.get(machineId).getTemperature();
	};

	public Object getHumidity(int machineId) {
		return machines.get(machineId).getHumidity();
	}

	public Object getVibration(int machineId) {
		return machines.get(machineId).getHumidity();
	}
}
