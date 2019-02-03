## Evidence
* this takes Salt + name/values/type/digest it? (the last a boolean on whether to store the value or the digest) Often the name/values will start with id and date
* this returns big digest (as part of the id of this thing which is the uri to get it again)
* It stores the fact this big digest has been seen
* Given the big digest you can get the data back (digested if boolean was true). This is awesome for things 
like photos (of passports etc)
Note that the point of the salt is just to stop similar values being returned for the values like dates and ids


# Comments
Originally had differences between read and write shape. Currently same. Will leave alone for now
but might simplify

# Current thoughts
Evidence can be a passport or can be a kyc bundle or can be a utility bill. i.e. it can be primitives or aggregates and 
there is no real difference

Evidence is typically a value accessed through id/value if you want the latest, but have a value for 'this evidence'
Many of the items in it are values and it will be able to find the latest values of them