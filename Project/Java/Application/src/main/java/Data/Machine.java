package Data;

import java.net.URI;

public class Machine {
    URI machineAddress;
    String name;

    public Machine (URI machineAddress, String name) {
        this.machineAddress=machineAddress;
        this.name=name;
    }
    public Machine () {
    }

    public String getName() {
        return name;
    }

    public float getTemperature() {
        return 0;
    }
}
