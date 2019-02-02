package one.xingyi.kyc.identityValue.command;
import one.xingyi.core.annotations.CreateWithoutId;
import one.xingyi.core.annotations.Resource;
import one.xingyi.core.sdk.IXingYiResourceDefn;

@Resource(bookmark = "identity/command", rootUrl = "/identity")
@CreateWithoutId(url = "/identity")
public interface IIdentityPostDefn extends IXingYiResourceDefn {
    String id();
    String value();
    String date();
}
