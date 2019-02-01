package one.xingyi.kyc.immutableString;
import one.xingyi.core.annotations.View;
import one.xingyi.core.sdk.IXingYiViewDefn;

@View
public interface IImmutableStringViewDefn extends IXingYiViewDefn<IImmutableStringDefn> {
    String id();
    String value();
}
