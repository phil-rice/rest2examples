package one.xingyi.kyc.evidence;

import one.xingyi.core.annotations.View;
import one.xingyi.core.client.ISimpleList;
import one.xingyi.core.sdk.IXingYiViewDefn;
@View
public interface IEvidenceViewDefn extends IXingYiViewDefn<IEvidenceDefn> {
    String salt();
    String date();
    ISimpleList<IEvidenceDetailsReadViewDefn> facts();
}
