package Domain;

import Data.Machine;

import java.util.ArrayList;
import java.util.List;

public class Backend {
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
	
	public Object getInventory(int machineId) {
		return machines.get(machineId).getInventory();
	}

	public float getTemperature(int machineId) {
		return machines.get(machineId).getTemperature();
	};

	public Short getHumidity(int machineId) {
		return machines.get(machineId).getHumidity();
	}

	public float getVibration(int machineId) {
		return machines.get(machineId).getHumidity();
	}
	
	public void writeCommand(int machineId, int commandValue) {
		machines.get(machineId).writeCommand(commandValue);
	}
	
	public void confirmCommand(int machineId) {
		machines.get(machineId).confirmCommand();
	}
}
