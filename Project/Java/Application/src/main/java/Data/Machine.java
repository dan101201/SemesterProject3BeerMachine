package Data;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.sdk.client.api.identity.IdentityProvider;
import org.eclipse.milo.opcua.sdk.client.api.identity.UsernameProvider;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.util.EndpointUtil;

import java.net.URI;
import java.util.List;

public class Machine {
    URI machineAddress;
    String name;

    public Machine (URI machineAddress, String name) {
        this.machineAddress=machineAddress;
        this.name=name;
    }
    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int port = 4840;
        String endpointUrl = "opc.tcp://127.0.0.1:4840";

        try

        {
            List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints(endpointUrl).get();

            OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder()
//                    .setIdentityProvider(getIdentityprovider())
;
            EndpointDescription configPoint = EndpointUtil.updateUrl(endpoints.get(0), hostname, port);
            cfg.setEndpoint(configPoint);
            OpcUaClient client = OpcUaClient.create(cfg.build());
            client.connect().get();
            System.out.println("forbundet! "+ client.getNamespaceTable());
        }
        catch(Throwable ex)
        {
            System.out.println("*****************************************");
            ex.printStackTrace();
        }

    }
//    public static IdentityProvider getIdentityprovider() {
//        return new UsernameProvider("username", "password");
//    }
}
