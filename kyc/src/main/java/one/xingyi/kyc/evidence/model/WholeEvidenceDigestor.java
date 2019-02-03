package one.xingyi.kyc.evidence.model;
import one.xingyi.core.utils.Digestor;
import one.xingyi.core.utils.Lists;
import one.xingyi.kyc.evidence.main.server.domain.Evidence;

import java.util.function.Function;
public class WholeEvidenceDigestor implements Function<Evidence, String> {
    @Override public String apply(Evidence evidence) { //todo we can probably speed this up
        return Digestor.digestor.get().apply(evidence.salt() + "," + evidence.date() + "," + Lists.mapJoin(evidence.facts().toList(), ",", d -> d.name() + d.value() + d.mime())).digest;
    }
}
