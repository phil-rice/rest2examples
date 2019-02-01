package one.xingyi.kyc.evidence;

import one.xingyi.core.annotations.View;
import one.xingyi.core.sdk.IXingYiViewDefn;
@View
public interface IEvidenceDetailsReadViewDefn extends IXingYiViewDefn<IEvidenceDetailsDefn> {
    String name();
    String value();
    String mime();
}
