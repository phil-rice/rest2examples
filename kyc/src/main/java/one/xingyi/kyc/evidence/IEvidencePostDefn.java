package one.xingyi.kyc.evidence;

import one.xingyi.core.annotations.View;
import one.xingyi.core.client.IResourceList;
import one.xingyi.core.sdk.IXingYiViewDefn;
@View
public interface IEvidencePostDefn extends IXingYiViewDefn<IEvidenceDefn> {
    String salt();
    String date();
    IResourceList<IEvidenceDetailsPostViewDefn> facts();
}
