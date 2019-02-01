package one.xingyi.kyc.evidence;

import one.xingyi.core.annotations.CreateWithoutId;
import one.xingyi.core.annotations.Get;
import one.xingyi.core.annotations.Resource;
import one.xingyi.core.client.ISimpleList;
import one.xingyi.core.sdk.IXingYiResourceDefn;

@Resource(bookmark = "/evidence", rootUrl = "/evidence/{id}")
@CreateWithoutId(url = "/evidence")
@Get(mustExist = false)//returns prototype no matter what you ask for
public interface IEvidenceDefn extends IXingYiResourceDefn {
    String salt();
    String date();
    ISimpleList<IEvidenceDetailsDefn> facts();

}
