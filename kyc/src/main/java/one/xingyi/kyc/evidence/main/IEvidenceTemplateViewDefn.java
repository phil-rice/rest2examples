package one.xingyi.kyc.evidence.main;

import one.xingyi.core.annotations.View;
import one.xingyi.core.client.IResourceList;
import one.xingyi.core.sdk.IXingYiViewDefn;
import one.xingyi.kyc.evidence.details.IEvidenceDetailsTemplateViewDefn;
@View
public interface IEvidenceTemplateViewDefn extends IXingYiViewDefn<IEvidenceDefn> {
    IResourceList<IEvidenceDetailsTemplateViewDefn> facts();

}
