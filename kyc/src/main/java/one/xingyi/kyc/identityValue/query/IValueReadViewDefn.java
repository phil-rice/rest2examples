package one.xingyi.kyc.identityValue.query;
import one.xingyi.core.annotations.View;
import one.xingyi.core.sdk.IXingYiViewDefn;

@View
public interface IValueReadViewDefn extends IXingYiViewDefn<IValueReadDefn> {
    String identity();
    String date();
}
