package one.xingyi.kyc.fact;
import lombok.RequiredArgsConstructor;
import one.xingyi.core.client.ISimpleList;
import one.xingyi.core.http.ServiceRequest;
import one.xingyi.core.marshelling.JsonParser;
import one.xingyi.core.utils.IdAndValue;
import one.xingyi.kyc.fact.server.companion.FactCompanion;
import one.xingyi.kyc.fact.server.controller.IFactController;
import one.xingyi.kyc.fact.server.controller.IFactDetailsController;
import one.xingyi.kyc.fact.server.domain.Fact;
import one.xingyi.kyc.fact.server.domain.FactDetails;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public class FactController<J> implements IFactController {
    final JsonParser<J> parser;

    @Override public String stateFn(Fact entity) { return ""; }
    @Override public CompletableFuture<Fact> get(String id) {
        return CompletableFuture.completedFuture(new Fact("", "", ISimpleList.create()));
    }
    @Override public CompletableFuture<IdAndValue<Fact>> createWithoutId(Fact value) {
        return CompletableFuture.completedFuture(new IdAndValue<>("calculatedId", value));
    }
    @Override public Fact createWithoutIdRequestFrom(ServiceRequest serviceRequest) {
        return FactCompanion.companion.fromJson(parser, parser.parse(serviceRequest.body));
    }
}
