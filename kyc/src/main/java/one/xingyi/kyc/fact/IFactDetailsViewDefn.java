package one.xingyi.kyc.fact;

import one.xingyi.core.annotations.View;
import one.xingyi.core.sdk.IXingYiViewDefn;
@View
public interface IFactDetailsViewDefn extends IXingYiViewDefn<IFactDetailsDefn> {
    String name();
    String value();
}
