package one.xingyi.kyc.evidence.details;

import one.xingyi.core.annotations.View;
import one.xingyi.core.sdk.IXingYiViewDefn;
@View
public interface IEvidenceDetailsReadViewDefn extends IXingYiViewDefn<IEvidenceDetailsDefn> {
    String name();
    String value();
    String mime();
    String digest();//really a boolean. Is this the thing or is it digested
}
