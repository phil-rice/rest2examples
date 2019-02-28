package one.xingyi.kyc.identityValue.command;
import one.xingyi.core.annotations.View;
import one.xingyi.core.sdk.IXingYiViewDefn;

@View
public interface IIdentityDefn extends IXingYiViewDefn<IIdentityPostDefn> {
    String value();
    String audit();
    String date();
}
