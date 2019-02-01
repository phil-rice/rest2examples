package one.xingyi.kyc.fact;

import one.xingyi.core.annotations.CreateWithoutId;
import one.xingyi.core.annotations.Get;
import one.xingyi.core.annotations.Put;
import one.xingyi.core.annotations.Resource;
import one.xingyi.core.client.ISimpleList;
import one.xingyi.core.sdk.IXingYiResourceDefn;

@Resource(bookmark = "/fact", rootUrl = "/fact/{id}")
@CreateWithoutId(url = "/fact")
@Get(mustExist = true)//returns prototype no matter what you ask for
public interface IFactDefn extends IXingYiResourceDefn {
    String salt();
    String date();
    ISimpleList<IFactDetailsDefn> facts();

}
