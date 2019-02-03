package one.xingyi.kyc.evidence.main;

import one.xingyi.core.annotations.View;
import one.xingyi.core.client.IResourceList;
import one.xingyi.core.sdk.IXingYiViewDefn;
import one.xingyi.kyc.evidence.details.IEvidenceDetailsReadViewDefn;
@View
public interface IEvidenceViewDefn extends IXingYiViewDefn<IEvidenceDefn> {
    String salt();
    String date();
    String type();
    IResourceList<IEvidenceDetailsReadViewDefn> facts();
}
