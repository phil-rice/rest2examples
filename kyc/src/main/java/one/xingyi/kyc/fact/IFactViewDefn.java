package one.xingyi.kyc.fact;

import one.xingyi.core.annotations.View;
import one.xingyi.core.client.ISimpleList;
import one.xingyi.core.sdk.IXingYiViewDefn;
@View
public interface IFactViewDefn extends IXingYiViewDefn<IFactDefn> {
    String salt();
    String date();
    ISimpleList<IFactDetailsViewDefn> facts();
}
