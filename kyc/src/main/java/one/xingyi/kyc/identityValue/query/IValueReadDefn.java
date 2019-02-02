package one.xingyi.kyc.identityValue.query;
import one.xingyi.core.annotations.Get;
import one.xingyi.core.annotations.Resource;
import one.xingyi.core.sdk.IXingYiResourceDefn;
@Resource(bookmark = "/identity/value", rootUrl = "/identity/value/{id}")
@Get(mustExist = false)
public interface IValueReadDefn extends IXingYiResourceDefn {
    String identity();
    String date();
}
