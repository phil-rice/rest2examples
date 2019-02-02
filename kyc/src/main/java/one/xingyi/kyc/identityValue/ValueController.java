package one.xingyi.kyc.identityValue;
import lombok.RequiredArgsConstructor;
import one.xingyi.kyc.identityValue.query.IdentityValueStore;
import one.xingyi.kyc.identityValue.query.server.controller.IValueReadController;
import one.xingyi.kyc.identityValue.query.server.domain.ValueRead;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
@RequiredArgsConstructor
public class ValueController implements IValueReadController {
    final IdentityValueStore identityValueStore;

    @Override public String stateFn(ValueRead entity) { return null; }

    @Override public CompletableFuture<Optional<ValueRead>> getOptional(String value) {
        Optional<ValueRead> valueRead = identityValueStore.getIdentity(value).flatMap(identity -> identityValueStore.getLatest(identity).map(vd -> new ValueRead(identity, vd.date)));
        return CompletableFuture.completedFuture(valueRead);
    }
}
