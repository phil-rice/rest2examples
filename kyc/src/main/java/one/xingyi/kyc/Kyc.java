package one.xingyi.kyc;
import one.xingyi.core.endpoints.EndpointConfig;
import one.xingyi.core.server.SimpleServer;
import one.xingyi.json.Json;
import one.xingyi.kyc.fact.FactController;
import one.xingyi.kyc.fact.FactDetailsController;
import one.xingyi.kyc.salt.SaltDataStore;

import java.util.Random;
public class Kyc {
    public static void main(String[] args) {
        Random random = new Random();
        Json json = new Json();
        EndpointConfig<Object> config = EndpointConfig.defaultConfig(json, json);
        SaltDataStore saltStore = new SaltDataStore(() -> Integer.toString(random.nextInt(1000000000)));
        FactDetailsController factDetailsController = new FactDetailsController();
        FactController<Object> factController = new FactController<>(config.jsonParser);


        SimpleServer server = new KycServer<Object>(config, factController, factDetailsController, saltStore).simpleServer(9000);
        server.start();
    }
}
