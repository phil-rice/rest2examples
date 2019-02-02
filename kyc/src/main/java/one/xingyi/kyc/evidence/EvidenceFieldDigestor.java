package one.xingyi.kyc.evidence;
import one.xingyi.core.client.IResourceList;
import one.xingyi.core.utils.Digestor;
import one.xingyi.core.utils.Lists;
import one.xingyi.kyc.evidence.server.domain.Evidence;
import one.xingyi.kyc.evidence.server.domain.IEvidenceDetails;

import java.util.function.BiFunction;
public class EvidenceFieldDigestor implements BiFunction<String, Evidence, Evidence> {
    final ThreadLocal<Digestor> digestor = new ThreadLocal<>() {
        @Override protected Digestor initialValue() {
            return Digestor.sha256();
        }
    };


    BiFunction<String, IEvidenceDetails, IEvidenceDetails> doOne =
//            (salt, d) ->  d.withvalue(fieldDigestor.get().apply(salt + d.value())) ;
            (salt, d) -> Boolean.parseBoolean(d.hide()) ? d.withvalue(digestor.get().apply(salt + d.value())) : d;

    @Override public Evidence apply(String salt, Evidence evidence) {//TODO clean this up
        return evidence.withfacts(IResourceList.fromList(Lists.map(evidence.facts().toList(), d -> doOne.apply(salt, d))));
    }
}
