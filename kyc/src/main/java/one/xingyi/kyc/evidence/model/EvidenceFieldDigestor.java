package one.xingyi.kyc.evidence.model;
import one.xingyi.core.client.IResourceList;
import one.xingyi.core.utils.Digestor;
import one.xingyi.core.utils.Lists;
import one.xingyi.kyc.evidence.details.server.domain.IEvidenceDetails;
import one.xingyi.kyc.evidence.main.server.domain.Evidence;

import java.util.function.BiFunction;
public class EvidenceFieldDigestor implements BiFunction<String, Evidence, Evidence> {


    BiFunction<String, IEvidenceDetails, IEvidenceDetails> doOne =
//            (salt, d) ->  d.withvalue(fieldDigestor.get().apply(salt + d.value())) ;
            (salt, d) -> Boolean.parseBoolean(d.digest()) ? d.withvalue(Digestor.digestor.get().apply(salt + d.value()).digest) : d;

    @Override public Evidence apply(String salt, Evidence evidence) {//TODO clean this up
        return evidence.withfacts(IResourceList.fromList(Lists.map(evidence.facts().toList(), d -> doOne.apply(salt, d))));
    }
}
