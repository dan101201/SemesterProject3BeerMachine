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

	/* public float getOEE(int machineId) { //guess we aint doing this
		private float myOEE;
		private float goodBeers = new float (machines.get(machineId).getGood()); //converting getGood to float
		private float cycleTime = new float (machines.get(machineId).getCycleTime()); //these methods shall be made
		private float plannedTime = new float (machines.get(machineId).getPannedTime());
		myOEE = goodBeers * cycleTime / plannedTime
				return myOEE;
	} */

	public void setMachineSpeed(int i, float j) {
		machines.get(0).setMachineSpeed(i, j);
	}

	public Short getBad(int machineId) {
		return machines.get(machineId).getBad();
	}

	public Short getGood(int machineId) {
		return machines.get(machineId).getGood();
	}

	public Short getProduced(int machineId) {
		return machines.get(machineId).getProduced();
	}

	public Short getProduceAmount(int machineId) {
		return machines.get(machineId).getProduceAmount();
	}

	public float[] getInventory(int machineId) {
		return machines.get(machineId).getInventory();
	}

	public float getTemperature(int machineId) {
		return machines.get(machineId).getTemperature();
	};

	public Short getHumidity(int machineId) {
		return machines.get(machineId).getHumidity();
	}

	public float getVibration(int machineId) {
		return machines.get(machineId).getVibration();
	}
	
	public void writeCommand(int machineId, int commandValue) {
		machines.get(machineId).writeCommand(commandValue);
	}
	
	public void confirmCommand(int machineId) {
		machines.get(machineId).confirmCommand();
	}
}
