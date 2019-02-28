package one.xingyi.kyc.identityValue;
import one.xingyi.core.endpoints.EndPoint;
import one.xingyi.core.endpoints.EndpointConfig;
import one.xingyi.core.http.JavaHttpClient;
import one.xingyi.core.http.ServiceRequest;
import one.xingyi.core.http.ServiceResponse;
import one.xingyi.core.httpClient.HttpServiceCompletableFuture;
import one.xingyi.core.utils.BiConsumerWithException;
import one.xingyi.json.Json;
import one.xingyi.kyc.EvidenceServer;
import one.xingyi.kyc.evidence.details.EvidenceDetailsController;
import one.xingyi.kyc.evidence.main.EvidenceController;
import one.xingyi.kyc.identityValue.query.IdentityValueStore;
import one.xingyi.kyc.immutableString.ImmutableStore;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
public interface EvidenceServerFixture {
    EndpointConfig<Object> config = EndpointConfig.defaultConfig(new Json());

    default void setup(BiConsumerWithException<HttpServiceCompletableFuture, EvidenceServer<Object>> block) throws Exception {
        IdentityValueStore identityValueStore = new IdentityValueStore();
        IdentityController identityController = new IdentityController(config.parserAndWriter, identityValueStore);
        ValueController valueController = new ValueController(identityValueStore);
        ImmutableStore immutableStore = new ImmutableStore();
        EvidenceServer<Object> server = new EvidenceServer<>(config, new EvidenceDetailsController(), new EvidenceController<>(config.parserAndWriter), identityController, identityController, valueController, immutableStore);

        Function<ServiceRequest, CompletableFuture<ServiceResponse>> serverKleisli = EndPoint.toKliesli(EndPoint.compose(server.allEndpoints(),true));

        HttpServiceCompletableFuture service = HttpServiceCompletableFuture.lensService("http://localhost:9000", config.parserAndWriter, serverKleisli);
        block.accept(service, server);
    }

}
