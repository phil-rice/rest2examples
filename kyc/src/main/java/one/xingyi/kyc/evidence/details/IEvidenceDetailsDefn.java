package one.xingyi.kyc.evidence.details;


import one.xingyi.core.annotations.*;
import one.xingyi.core.sdk.IXingYiResourceDefn;

@Resource(bookmark = "/evidencedetails", rootUrl = "{host}/evidencedetails/{id}")
@Get(mustExist = true) //always returns prototype no matter what you ask for
public interface IEvidenceDetailsDefn extends IXingYiResourceDefn {
    String name();
    String value();
    String mime();
    String digest(); //really a boolean... don't have boolean yet. If it is digested, then it is stored in immutable string
    String searchable();
          //to be considered. Means that you can ask for all the evidence that have name=value
          //the purpose is to allow 'find me all the templates for my organisation
          // if an organisation is a template, then 'find all the organisations'
}
