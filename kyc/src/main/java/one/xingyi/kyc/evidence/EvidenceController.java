package one.xingyi.kyc.evidence;
import one.xingyi.core.client.ISimpleList;
import one.xingyi.core.http.ServiceRequest;
import one.xingyi.core.marshelling.JsonParser;
import one.xingyi.core.store.ControllerUsingMap;
import one.xingyi.core.utils.IdAndValue;
import one.xingyi.kyc.evidence.server.companion.EvidenceCompanion;
import one.xingyi.kyc.evidence.server.controller.IEvidenceController;
import one.xingyi.kyc.evidence.server.domain.Evidence;

import java.util.concurrent.CompletableFuture;

public class EvidenceController<J> extends ControllerUsingMap<Evidence> implements IEvidenceController {
    final JsonParser<J> parser;
    public EvidenceController(JsonParser<J> parser) {
        super("Fact");
        store.put("prototype", prototype(""));
        this.parser = parser;
    }

    @Override public String stateFn(Evidence entity) { return ""; }
    @Override protected Evidence prototype(String id) { return new Evidence("", "", ISimpleList.create()); }
    @Override public CompletableFuture<IdAndValue<Evidence>> createWithoutId(Evidence value) {
        return CompletableFuture.completedFuture(new IdAndValue<>("calculatedId", value));
    }
    @Override public Evidence createWithoutIdRequestFrom(ServiceRequest serviceRequest) {
        return EvidenceCompanion.companion.fromJson(parser, parser.parse(serviceRequest.body));
    }
}
