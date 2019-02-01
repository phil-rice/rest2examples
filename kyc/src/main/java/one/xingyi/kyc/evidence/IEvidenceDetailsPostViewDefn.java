package one.xingyi.kyc.evidence;

import one.xingyi.core.annotations.View;
import one.xingyi.core.sdk.IXingYiViewDefn;
@View
public interface IEvidenceDetailsPostViewDefn extends IXingYiViewDefn<IEvidenceDetailsDefn> {
    String name();
    String value();
    String mime();
    String hide();
}
