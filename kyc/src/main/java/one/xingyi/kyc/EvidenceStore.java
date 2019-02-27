package one.xingyi.kyc;
import one.xingyi.core.endpoints.EndpointConfig;
import one.xingyi.core.server.SimpleServer;
import one.xingyi.json.Json;
import one.xingyi.kyc.evidence.main.EvidenceController;
import one.xingyi.kyc.evidence.details.EvidenceDetailsController;
import one.xingyi.kyc.identityValue.IdentityController;
import one.xingyi.kyc.identityValue.ValueController;
import one.xingyi.kyc.identityValue.query.IdentityValueStore;
import one.xingyi.kyc.immutableString.ImmutableStore;
public class EvidenceStore {
    public static void main(String[] args) {
        Json json = new Json();
        EndpointConfig<Object> config = EndpointConfig.defaultConfig(json);
        IdentityValueStore identityValueStore = new IdentityValueStore();

        ImmutableStore immutableStore = new ImmutableStore();
        EvidenceDetailsController evidenceDetailsController = new EvidenceDetailsController();
        EvidenceController<Object> evidenceController = new EvidenceController<>(json);

        IdentityController identityController = new IdentityController(json, identityValueStore);
        ValueController valueController = new ValueController(identityValueStore);
        SimpleServer server = new EvidenceServer<Object>(config,
                evidenceDetailsController,
                evidenceController,
                identityController, identityController, valueController, //CQRS work around
                immutableStore).simpleServer(9000);
        server.start();
    }
}
