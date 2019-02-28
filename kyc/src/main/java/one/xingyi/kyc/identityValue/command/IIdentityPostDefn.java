package one.xingyi.kyc.identityValue.command;
import one.xingyi.core.annotations.CreateWithoutId;
import one.xingyi.core.annotations.Prototype;
import one.xingyi.core.annotations.Resource;
import one.xingyi.core.sdk.IXingYiResourceDefn;

@Resource(bookmark = "identity/command", rootUrl = "{host}/identity/{id}")
@CreateWithoutId(url = "/identity")
@Prototype("prototype")
public interface IIdentityPostDefn extends IXingYiResourceDefn {
    String id();
    String value();
    String audit();
    String date();
}
