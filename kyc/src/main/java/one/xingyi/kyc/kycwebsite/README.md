For a demo

* select organisation (this is basically login) and a 'create organisation' option
   * there is an organisation template (value)
   * organisation are evidence of type 'kyc/organisation'
   * organisation have data 'name/icon/homepage'
   * might have parent organisation
  
* organisation home page
   * Show list of templates and the option to make new ones
   * Show evidence by date (configurable display details)
   * search for evidence box (attribute = value nothing clever)
* If you click on a template you can enter data
 

Wouldn't it be cool if I could have a general purpose identity value gui that can be customized
So same gui for 'organisation' and 'evidence'

This is a key thing... The website would just ask for this component and put it on the screen, perhaps
with customisation (css looks ideal for that

Options:
Isn't it just a render option? And have 'html/view' and 'html/edit' as the idiomatic renderings
Mustache is fantastic as rendering, so let's use it! mustache.js looks good

Big question:how to ship the mustache?

Need the following resources

KYC Organisation 
Consider the idea that this is just evidence
For now ignore problems of users. 

KYC Template 
Are just prototype templates.

KYC
This is basically a filled in template for a person
* post
* change (this is the identity value story)
* get (this should be sharable with others)


