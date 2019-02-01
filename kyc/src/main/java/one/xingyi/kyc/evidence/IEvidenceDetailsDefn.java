package one.xingyi.kyc.evidence;


import one.xingyi.core.annotations.*;
import one.xingyi.core.sdk.IXingYiResourceDefn;

@Resource(bookmark = "/evidencedetails", rootUrl = "/evidencedetails/{id}")
@Get(mustExist = true) //always returns prototype no matter what you ask for
public interface IEvidenceDetailsDefn extends IXingYiResourceDefn {
    String name();
    String value();
    String mime();
    String hide();
}
