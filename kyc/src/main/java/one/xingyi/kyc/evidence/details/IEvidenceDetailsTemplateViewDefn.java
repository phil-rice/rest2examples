package one.xingyi.kyc.evidence.details;

import one.xingyi.core.annotations.View;
import one.xingyi.core.sdk.IXingYiViewDefn;
@View
public interface IEvidenceDetailsTemplateViewDefn extends IXingYiViewDefn<IEvidenceDetailsDefn> {
    String name();
    String mime();
    String digest(); //should it be digested
}
