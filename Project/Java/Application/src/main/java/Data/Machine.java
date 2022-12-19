package Data;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;
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

    int ProductID;
// Skal bruges hvis der er flere maskiner
//    public Machine(URI machineAddress, String name) {
//        this.machineAddress = machineAddress;
//        this.name = name;
//    }

    public Machine() {
        //String hostname = "192.168.0.122";
        //String endpointUrl = "opc.tcp://192.168.0.122:4840";
        int port = 4840;
        String hostname = "127.0.0.1";
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

    //    public int setBatchNR() {
//
//        int batchNR;
//        if (batchNR < 0 || batchNR > 65535)
//            throw new IllegalArgumentException();
//        client.writeValue(new NodeId(6, " ::Program:Cube.Command.Parameter[0]"), DataValue.valueOnly(new Variant(batchNR)));
//
//
//        return batchNR;
//    }
    public void setProductID(int i) {
        if (i < 0 || i > 5)
            throw new IllegalArgumentException();
        client.writeValue(new NodeId(6, "::Program:Cube.Command.Parameter[1]"), DataValue.valueOnly(new Variant(i)));
    }

    public void setMachineSpeed(int i, float f) {
        switch (i) {
            case 0 -> {
                if (f < 0 || f > 600)
                    throw new IllegalArgumentException();
            }
            case 1 -> {
                if (f < 0 || f > 300)
                    throw new IllegalArgumentException();
            }
            case 2 -> {
                if (f < 0 || f > 150)
                    throw new IllegalArgumentException();
            }
            case 3 -> {
                if (f < 0 || f > 200)
                    throw new IllegalArgumentException();
            }
            case 4 -> {
                if (f < 0 || f > 100)
                    throw new IllegalArgumentException();
            }
            case 5 -> {
                if (f < 0 || f > 125)
                    throw new IllegalArgumentException();
            }
        }
        client.writeValue(new NodeId(6, "::Program:Cube.Command.MachSpeed"), DataValue.valueOnly(new Variant(f)));
    }

    public void setNumberOfProducedProduct(int i) {
        if (i < 0 || i > 65535)
            throw new IllegalArgumentException();
        client.writeValue(new NodeId(6, "::Program:Cube.Command.Parameter[2].Value"), DataValue.valueOnly(new Variant(i)));
    }

    public void writeCommand(int i) {
        if (i < 1 || i > 5)
            throw new IllegalArgumentException();
        client.writeValue(new NodeId(6, "::Program:Cube.Command.CntrlCmd"), DataValue.valueOnly(new Variant(i)));
    }

    public void confirmCommand() {
        client.writeValue(new NodeId(6, "::Program:Cube.Command.CmdChangeRequest"), DataValue.valueOnly(new Variant(true)));
    }

    public float getTemperature() {
        NodeId nodeId = new NodeId(6, "::Program:Data.Value.Temperature");
        return (float) getValue(nodeId);
    }

    public Short getBad() {
        NodeId nodeId = new NodeId(6, "::Program:product.bad");
        return Short.parseShort(((UShort)getValue(nodeId)).toString());
    }

    public Short getGood() {
        NodeId nodeId = new NodeId(6, "::Program:product.good");
        return Short.parseShort(((UShort)getValue(nodeId)).toString());
    }

    public Short getProduced() {
        NodeId nodeId = new NodeId(6, "::Program:product.produce_amount");
        return Short.parseShort(((UShort)getValue(nodeId)).toString());
    }

    public Short getProduceAmount() {
        NodeId nodeId = new NodeId(6, "::Program:product.produced");
        return Short.parseShort(((UShort)getValue(nodeId)).toString());
    }

    public Short getHumidity() {
        NodeId nodeId = new NodeId(6, "::Program:Data.Value.RelHumidity");
        return (Short) getValue(nodeId);
    }

    public float getVibration() {
        NodeId nodeId = new NodeId(6, "::Program:Data.Value.Vibration");
        return (float) getValue(nodeId);
    }

    private Object getValue (NodeId nodeId) {
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
        return value.getValue().getValue();
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
