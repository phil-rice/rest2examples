package one.xingyi.kyc.evidence.main;

import one.xingyi.core.annotations.CreateWithoutId;
import one.xingyi.core.annotations.Get;
import one.xingyi.core.annotations.Resource;
import one.xingyi.core.client.IResourceList;
import one.xingyi.core.sdk.IXingYiResourceDefn;
import one.xingyi.kyc.evidence.details.IEvidenceDetailsDefn;

@Resource(bookmark = "/evidence", rootUrl = "{host}/evidence/{id}")
@CreateWithoutId(url = "/evidence")
@Get(mustExist = false)//returns prototype no matter what you ask for
public interface IEvidenceDefn extends IXingYiResourceDefn {
    String salt();
    String date();
    String type();
    IResourceList<IEvidenceDetailsDefn> facts();

}
