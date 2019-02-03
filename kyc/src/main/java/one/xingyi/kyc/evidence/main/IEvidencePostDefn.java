package one.xingyi.kyc.evidence.main;

import one.xingyi.core.annotations.View;
import one.xingyi.core.client.IResourceList;
import one.xingyi.core.sdk.IXingYiViewDefn;
import one.xingyi.kyc.evidence.details.IEvidenceDetailsPostViewDefn;
@View
public interface IEvidencePostDefn extends IXingYiViewDefn<IEvidenceDefn> {
    String salt();
    String date();
    String type();
    IResourceList<IEvidenceDetailsPostViewDefn> facts();
}
