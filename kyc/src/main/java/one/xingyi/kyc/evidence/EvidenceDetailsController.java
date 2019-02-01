package one.xingyi.kyc.evidence;
import one.xingyi.kyc.evidence.server.controller.IEvidenceDetailsController;
import one.xingyi.kyc.evidence.server.domain.EvidenceDetails;

import java.util.concurrent.CompletableFuture;
public class EvidenceDetailsController implements IEvidenceDetailsController {
    final EvidenceDetails prototype = new EvidenceDetails("", "", "application/json", "true");
    @Override public String stateFn(EvidenceDetails entity) { return ""; }
    @Override public CompletableFuture<EvidenceDetails> get(String id) { return CompletableFuture.completedFuture(prototype); }
}
