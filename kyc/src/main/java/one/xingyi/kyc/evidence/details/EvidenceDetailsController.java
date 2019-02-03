package one.xingyi.kyc.evidence.details;
import one.xingyi.kyc.evidence.details.server.controller.IEvidenceDetailsController;
import one.xingyi.kyc.evidence.details.server.domain.EvidenceDetails;

import java.util.concurrent.CompletableFuture;
public class EvidenceDetailsController implements IEvidenceDetailsController {

    final EvidenceDetails prototype = new EvidenceDetails("", "", "application/json", "true", "false");
    @Override public String stateFn(EvidenceDetails entity) { return ""; }
    @Override public CompletableFuture<EvidenceDetails> get(String id) { return CompletableFuture.completedFuture(prototype); }
}
