package one.xingyi.kyc.salt;
import one.xingyi.core.annotations.Create;
import one.xingyi.core.annotations.Get;
import one.xingyi.core.annotations.Resource;
import one.xingyi.core.sdk.IXingYiResourceDefn;

@Resource(bookmark = "/salt", rootUrl = "/salt/{id}")
@Get(mustExist = false)
@Create
public interface ISaltDefn extends IXingYiResourceDefn {
    String id();
    String salt();
}
