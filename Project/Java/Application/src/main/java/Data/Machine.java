package Data;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.util.EndpointUtil;

import java.net.URI;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

public class Machine {
    URI machineAddress;
    String name;
    OpcUaClient client;
    Inventory inventory = new Inventory();
// Skal bruges hvis der er flere maskiner
//    public Machine(URI machineAddress, String name) {
//        this.machineAddress = machineAddress;
//        this.name = name;
//    }

    public Machine() {
        String hostname = "127.0.0.1";
        int port = 4840;
        String endpointUrl = "opc.tcp://127.0.0.1:4840";

        try {
            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints(endpointUrl).get();

            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder()
//                    .setIdentityProvider(getIdentityprovider())
                    ;
            EndpointDescription configPoint = EndpointUtil.updateUrl(endpoints.get(0), hostname, port);
            cfg.setEndpoint(configPoint);
            client = OpcUaClient.create(cfg.build());
            client.connect().get();
            System.out.println("forbundet! " + client.getNamespaceTable());
        } catch (Throwable ex) {
            System.out.println("COULD NOT CONNECT");
            ex.printStackTrace();
        }
        updateValuesOnMachine();
    }

    public void updateValuesOnMachine() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                inventory.setBarley(getBarley());
                inventory.setMalt(getMalt());
                inventory.setHops(getHops());
                inventory.setWheat(getWheat());
                inventory.setYeast(getYeast());
            }

        }, 0, 120000);
    }
    
    public float[] getInventory() {
        float[] resArr = new float[5];
        resArr[0] = inventory.getBarley();
        resArr[1] = inventory.getMalt();
        resArr[2] = inventory.getHops();
        resArr[3] = inventory.getWheat();
        resArr[4] = inventory.getYeast();
        return resArr;
    }


    public float getTemperature() {
        NodeId nodeId = new NodeId(6, "::Program:Data.Value.Temperature");
        return getValueInt(nodeId);
    }

    public int getHumidity() {
        NodeId nodeId = new NodeId(6, "::Program:Data.Value.RelHumidity");
        return getValueInt(nodeId);
    }

    public int getVibration() {
        NodeId nodeId = new NodeId(6, "::Program:Data.Value.Vibration");
        return getValueInt(nodeId);
    }
    
    private int getValueInt(NodeId nodeId) {
        DataValue value = null;
        try {
            value = client.readValue(0, TimestampsToReturn.Both, nodeId).get();
        } catch (InterruptedException e) {
            System.out.println("Der er sket en fejl med funktionen");
            e.printStackTrace();
            return -1;
        } catch (ExecutionException e) {
            System.out.println("Der er sket en anden fejl med funktionen");
            e.printStackTrace();
            return -1;
        }
        assert value != null;
        return (int) value.getValue().getValue();
    }
    
    private float getBarley() {
        NodeId nodeId = new NodeId(6, "::Program:Inventory.Barley");
        return getValueFloat(nodeId);
    }

    private float getHops() {
        NodeId nodeId = new NodeId(6, "::Program:Inventory.Hops");
        return getValueFloat(nodeId);
    }

    private float getMalt() {
        NodeId nodeId = new NodeId(6, "::Program:Inventory.Malt");
        return getValueFloat(nodeId);
    }

    private float getWheat() {
        NodeId nodeId = new NodeId(6, "::Program:Inventory.Wheat");
        return getValueFloat(nodeId);
    }

    private float getYeast() {
        NodeId nodeId = new NodeId(6, "::Program:Inventory.Yeast");
        return getValueFloat(nodeId);
    }
    
    private float getValueFloat(NodeId nodeId) {
        DataValue value = null;
        try {
            value = client.readValue(0, TimestampsToReturn.Both, nodeId).get();
        } catch (InterruptedException e) {
            System.out.println("Der er sket en fejl med funktionen");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("Der er sket en anden fejl med funktionen");
            e.printStackTrace();
        }
        assert value != null;
        return (float) value.getValue().getValue();
    }
    
    public String getName() {
        return name;
    }
    // Skal bruges hvis vi har lyst til at bruge en server med Username/password og skal udkommenteres omkring cfg-variablen.
//    public static IdentityProvider getIdentityprovider() {
//        return new UsernameProvider("username", "password");
//    }
}
