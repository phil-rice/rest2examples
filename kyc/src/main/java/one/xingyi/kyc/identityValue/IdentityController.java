package one.xingyi.kyc.identityValue;
import lombok.RequiredArgsConstructor;
import one.xingyi.core.http.ServiceRequest;
import one.xingyi.core.marshelling.JsonParser;
import one.xingyi.core.utils.IdAndValue;
import one.xingyi.kyc.identityValue.command.server.companion.IdentityPostCompanion;
import one.xingyi.kyc.identityValue.command.server.controller.IIdentityPostController;
import one.xingyi.kyc.identityValue.command.server.domain.IdentityPost;
import one.xingyi.kyc.identityValue.query.IdentityValueStore;
import one.xingyi.kyc.identityValue.query.ValueAndDate;
import one.xingyi.kyc.identityValue.query.server.controller.IIdentityReadController;
import one.xingyi.kyc.identityValue.query.server.domain.IdentityRead;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public class IdentityController<J> implements IIdentityReadController, IIdentityPostController {
    final JsonParser<J> parser;
    final IdentityValueStore identityValueStore;

    @Override public String stateFn(IdentityRead entity) { return null; }
    @Override public String stateFn(IdentityPost entity) { return null; }

    @Override public CompletableFuture<Optional<IdentityRead>> getOptional(String identity) {
        Optional<ValueAndDate> latest = identityValueStore.getLatest(identity);
        return CompletableFuture.completedFuture(latest.map(vd -> new IdentityRead(vd.value, vd.date)));
    }

    @Override public IdentityPost createWithoutIdRequestFrom(ServiceRequest serviceRequest) {
        return IdentityPostCompanion.companion.fromJson(parser, parser.parse(serviceRequest.body));
    }
    @Override public CompletableFuture<IdAndValue<IdentityPost>> createWithoutId(IdentityPost identity) {
        identityValueStore.put(identity);
        return CompletableFuture.completedFuture(new IdAndValue<>(identity.id(), identity));
    }
}
