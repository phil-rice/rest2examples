package one.xingyi.kyc.salt;
import lombok.RequiredArgsConstructor;
import one.xingyi.core.store.ControllerUsingMap;
import one.xingyi.kyc.salt.server.controller.ISaltController;
import one.xingyi.kyc.salt.server.domain.Salt;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class SaltDataStore extends ControllerUsingMap<Salt> implements ISaltController {
    final Supplier<String> saltGenerator;
    public SaltDataStore(Supplier<String> saltGenerator) {
        super("Salt");
        this.saltGenerator = saltGenerator;
    }
    @Override public String stateFn(Salt entity) { return null; }
    @Override protected Salt prototype(String id) { return new Salt(id, saltGenerator.get()); }
}
