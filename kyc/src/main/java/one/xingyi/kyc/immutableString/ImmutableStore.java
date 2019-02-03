package one.xingyi.kyc.immutableString;
import one.xingyi.core.http.ServiceRequest;
import one.xingyi.core.store.ControllerUsingMap;
import one.xingyi.core.utils.Digestor;
import one.xingyi.core.utils.IdAndValue;
import one.xingyi.kyc.immutableString.server.controller.IImmutableStringController;
import one.xingyi.kyc.immutableString.server.domain.ImmutableString;

import java.util.concurrent.CompletableFuture;

public class ImmutableStore extends ControllerUsingMap<ImmutableString> implements IImmutableStringController {

   public ImmutableStore() {
        super("ImmutableString");
    }
    @Override public ImmutableString createWithoutIdRequestFrom(ServiceRequest serviceRequest) {
        return new ImmutableString(Digestor.digestor().apply(serviceRequest.body).digest, serviceRequest.body);
    }
    @Override public CompletableFuture<IdAndValue<ImmutableString>> createWithoutId(ImmutableString immutableString) {
        store.put(immutableString.id(), immutableString);
        return CompletableFuture.completedFuture(new IdAndValue<>(immutableString.id(), immutableString));
    }
    @Override public String stateFn(ImmutableString entity) { return null; }
    @Override protected ImmutableString prototype(String s) { throw new RuntimeException("Not meaningful");}


}
