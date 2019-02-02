# Setting up a kyc document validator

## Evidence
* this takes Salt + name/values/type/digest it? (the last a boolean on whether to store the value or the digest) Often the name/values will start with id and date
* this returns big digest (as part of the id of this thing which is the uri to get it again)
* It stores the fact this big digest has been seen
* Given the big digest you can get the data back (digested if boolean was true). This is awesome for things 
like photos (of passports etc)
Note that the point of the salt is just to stop similar values being returned for the values like dates and ids

## Identity
A fact has an identity and many values
The identity is just a string (typically something like `<customerId>Statement`) 
The value is just an integer order (often just the long of a date object) and a string. The string would typically by the identifier from DigestMe
Post adds a value to the identity with an audit reason. The audit reason is stored in immutable string (purely to mask why we did this from casual viewers)
Get returns the values of the identity in time order with audit reason id. Note therefore that get can return a different thing if called later... unlike most things in this approach

## ImmutableString


## Purpose
Get /purpose/<purpose> returns [ {name: "<someFieldName>" , type: "<someMimeType>", digestIt: true/false, optional: true/false ]
Just delegates the heavy lifting to identity and immutable string (purpose lives in immutable string, it is accessed via identity)

## Register
So this is a website. Or even cooler an android app

Some ID + Purpose + Name/Values
Needs an ID (where does it get this from..?)
* Scan/upload stuff with tags 
 * Photo would be 'photo this, label it or delete it'
 * Upload is standard (painful) upload or url or drag/drop
* Fill in fields with drop downs (purpose details what we need/can have)
* Send to digest me. 
* Send to identity value.
* The digest me id turns into a QR code


* It given a purpose id and a customer id 
* it gets the fields from purpose (so we have identity/value on purpose)
* The fields are populated
* 



