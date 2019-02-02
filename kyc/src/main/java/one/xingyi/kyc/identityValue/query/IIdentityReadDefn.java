package one.xingyi.kyc.identityValue.query;
import one.xingyi.core.annotations.Get;
import one.xingyi.core.annotations.Resource;
import one.xingyi.core.client.IResourceList;
import one.xingyi.core.sdk.IXingYiResourceDefn;

@Resource(bookmark = "/identity/read", rootUrl = "/identity/{id}/latest")
@Get(mustExist = false)
public interface IIdentityReadDefn extends IXingYiResourceDefn {
    String latestValue();
    String date();
}
