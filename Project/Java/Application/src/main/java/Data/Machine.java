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
import java.util.concurrent.ExecutionException;

public class Machine {
    URI machineAddress;
    String name;
    OpcUaClient client;

    public Machine(URI machineAddress, String name) {
        this.machineAddress = machineAddress;
        this.name = name;
    }

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

    }

    public static void main(String[] args) {

    }

    public float getTemperature() {
        NodeId nodeId = new NodeId(6, "::Program:Data.Value.Temperature");
        DataValue value = null;
        try {
            value = client.readValue(0, TimestampsToReturn.Both, nodeId).get();
        } catch (InterruptedException e) {
            System.out.println("Der er sket en fejl med getTemp-funktionen");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("Der er sket en anden fejl med getTemp-funktionen");
            e.printStackTrace();
        }
        assert value != null;
        return (float)value.getValue().getValue();
    }

    public String getName() {
        return name;
    }
//    public static IdentityProvider getIdentityprovider() {
//        return new UsernameProvider("username", "password");
//    }
}
