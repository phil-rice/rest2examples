package one.xingyi.kyc.evidence.main;
import one.xingyi.core.client.IResourceList;
import one.xingyi.core.http.ServiceRequest;
import one.xingyi.core.marshelling.JsonParser;
import one.xingyi.core.store.ControllerUsingMap;
import one.xingyi.core.utils.IdAndValue;
import one.xingyi.kyc.evidence.main.server.companion.EvidenceCompanion;
import one.xingyi.kyc.evidence.main.server.controller.IEvidenceController;
import one.xingyi.kyc.evidence.main.server.domain.Evidence;
import one.xingyi.kyc.evidence.model.EvidenceFieldDigestor;
import one.xingyi.kyc.evidence.model.WholeEvidenceDigestor;

import java.util.concurrent.CompletableFuture;

public class EvidenceController<J> extends ControllerUsingMap<Evidence> implements IEvidenceController {
    final JsonParser<J> parser;
    final WholeEvidenceDigestor wholeEvidenceDigestor = new WholeEvidenceDigestor();
    final EvidenceFieldDigestor fieldDigestor = new EvidenceFieldDigestor();
    public EvidenceController(JsonParser<J> parser) {
        super("Fact");
        store.put("prototype", prototype(""));
        this.parser = parser;
    }

    @Override public String stateFn(Evidence entity) { return ""; }
    @Override protected Evidence prototype(String id) { return new Evidence("", "", "",IResourceList.create()); }
    @Override public CompletableFuture<IdAndValue<Evidence>> createWithoutId(Evidence value) {
        String id = wholeEvidenceDigestor.apply(value);
        store.put(id, value);
        return CompletableFuture.completedFuture(new IdAndValue<>(id, value));
    }
    @Override public Evidence createWithoutIdRequestFrom(ServiceRequest serviceRequest) {
        Evidence evidence = EvidenceCompanion.companion.fromJson(parser, parser.parse(serviceRequest.body));
        return fieldDigestor.apply(evidence.salt(), evidence);
    }
}
