package one.xingyi.kyc.identityValue;
import one.xingyi.core.endpoints.EndpointConfig;
import one.xingyi.json.Json;
import one.xingyi.kyc.EvidenceServer;
import one.xingyi.kyc.evidence.details.EvidenceDetailsController;
import one.xingyi.kyc.evidence.main.EvidenceController;
import one.xingyi.kyc.identityValue.command.client.view.Identity;
import one.xingyi.kyc.identityValue.command.server.controller.IIdentityPostController;
import one.xingyi.kyc.identityValue.command.server.domain.IdentityPost;
import one.xingyi.kyc.identityValue.query.IdentityValueStore;
import one.xingyi.kyc.immutableString.ImmutableStore;
import org.junit.Test;

import java.util.function.Consumer;

public class IdentityValueTest implements EvidenceServerFixture {


    @Test public void test() throws Exception {
        setup((service, server) -> {
            Identity.prototype(service, "someId", p -> p.withaudit("someAudit").withdate("someDate").withvalue("the value")).get();
        });
    }
}
