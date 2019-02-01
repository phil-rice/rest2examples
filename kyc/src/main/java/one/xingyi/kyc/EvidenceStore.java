package one.xingyi.kyc;
import one.xingyi.core.endpoints.EndpointConfig;
import one.xingyi.core.server.SimpleServer;
import one.xingyi.json.Json;
import one.xingyi.kyc.evidence.EvidenceController;
import one.xingyi.kyc.evidence.EvidenceDetailsController;
import one.xingyi.kyc.immutableString.ImmutableStore;

import java.util.Random;
public class EvidenceStore {
    public static void main(String[] args) {
        Random random = new Random();
        Json json = new Json();
        EndpointConfig<Object> config = EndpointConfig.defaultConfig(json, json);
        ImmutableStore immutableStore = new ImmutableStore();
        EvidenceDetailsController evidenceDetailsController = new EvidenceDetailsController();
        EvidenceController<Object> evidenceController = new EvidenceController<>(config.jsonParser);

        SimpleServer server = new EvidenceServer<>(config, evidenceController, evidenceDetailsController, immutableStore).simpleServer(9000);
        server.start();
    }
}
