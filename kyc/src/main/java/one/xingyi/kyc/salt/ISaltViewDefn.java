package one.xingyi.kyc.salt;
import one.xingyi.core.annotations.Resource;
import one.xingyi.core.annotations.View;
import one.xingyi.core.sdk.IXingYiViewDefn;

@View
public interface ISaltViewDefn extends IXingYiViewDefn<ISaltDefn> {
    String id();
    String salt();
}
