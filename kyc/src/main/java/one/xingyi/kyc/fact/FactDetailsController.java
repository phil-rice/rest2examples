package one.xingyi.kyc.fact;
import one.xingyi.kyc.fact.server.controller.IFactDetailsController;
import one.xingyi.kyc.fact.server.domain.FactDetails;

import java.util.concurrent.CompletableFuture;
public class FactDetailsController implements IFactDetailsController {
    final FactDetails prototype = new FactDetails("", "");

    @Override public String stateFn(FactDetails entity) { return ""; }
    @Override public CompletableFuture<FactDetails> get(String id) {
        return CompletableFuture.completedFuture(prototype);
    }
}
