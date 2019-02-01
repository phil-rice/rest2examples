package one.xingyi.kyc.immutableString;
import one.xingyi.core.annotations.CreateWithoutId;
import one.xingyi.core.annotations.Get;
import one.xingyi.core.annotations.Resource;
import one.xingyi.core.sdk.IXingYiResourceDefn;

@Resource(bookmark = "/immutable", rootUrl = "/immutable/{id}")
@Get(mustExist = false)
@CreateWithoutId(url = "/immutable")
public interface IImmutableStringDefn extends IXingYiResourceDefn {
    String id();
    String value();
}
