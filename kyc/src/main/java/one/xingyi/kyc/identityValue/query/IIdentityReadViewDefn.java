package one.xingyi.kyc.identityValue.query;
import one.xingyi.core.annotations.View;
import one.xingyi.core.sdk.IXingYiViewDefn;
@View
public interface IIdentityReadViewDefn extends IXingYiViewDefn<IIdentityReadDefn> {
    String latestValue();
    String date();
}
