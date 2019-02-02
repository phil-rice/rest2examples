package one.xingyi.kyc.evidence;
import one.xingyi.core.utils.Digestor;
import one.xingyi.core.utils.Lists;
import one.xingyi.kyc.evidence.server.domain.Evidence;

import java.util.function.Function;
public class WholeEvidenceDigestor implements Function<Evidence, String> {
    final ThreadLocal<Digestor> digestor = new ThreadLocal<>() {
        @Override protected Digestor initialValue() {
            return Digestor.sha256();
        }
    };


    @Override public String apply(Evidence evidence) { //todo we can probably speed this up
        return digestor.get().apply(evidence.salt() + "," + evidence.date() + "," + Lists.mapJoin(evidence.facts().toList(), ",", d -> d.name() + d.value() + d.mime()));
    }
}
