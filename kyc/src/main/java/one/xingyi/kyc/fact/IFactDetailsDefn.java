package one.xingyi.kyc.fact;


import one.xingyi.core.annotations.*;
import one.xingyi.core.sdk.IXingYiResourceDefn;

@Resource(bookmark = "/factdetails", rootUrl = "/factdetails/{id}")
@Get(mustExist = true) //always returns prototype no matter what you ask for
public interface IFactDetailsDefn extends IXingYiResourceDefn {
    String name();
    String value();
}
