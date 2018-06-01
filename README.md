# This is a java lib for commonly used String manipulation

## Insert a String in between two elements!
Stringer.insertText(String source, String insertText, String textOnTheLeft, String textOnTheRight);  
Stringer.insertText(File textFile, String insertText, String textOnTheLeft, String textOnTheRight);
>**Example:** 
String result = Stringer.insertText("aZ", "@", "a", "Z");
//result = a@Z

## Append a String to the start of each line
Stringer.appendLineStart(String source, String appendString);  
Stringer.appendLineStart(File textFile, String appendString);

>**Example:** 
String result = Stringer.appendLineStart("aZ", "@");
//result = @aZ

>**Example2:** 
String result = Stringer.appendLineStart("aZ\n"+"aD", "@");
//result = @aZ\n@aD

## Append a String to the end of each line
Stringer.appendLineEnd(String source, String appendString);  
Stringer.appendLineEnd(File textFile, String appendString);
>**Example:** 
String result = Stringer.appendLineEnd("aZ", "@");
//result = aZ@

>**Example2:** 
String result = Stringer.appendLineEnd("aZ\n"+"aD", "@");
//result = aZ@\naD@

## Remove a String in between two elements!
Stringer.removeBetween(String source, String insertText, String textOnTheLeft, String textOnTheRight);  
Stringer.removeBetween(File textFile, String insertText, String textOnTheLeft, String textOnTheRight);
>**Example:** 
String result = Stringer.removeBetween("a@@@@@@Z", "@", "a", "Z");
//result = aZ

## Remove a String to the start of each line
Stringer.removeLineStart(String source, String appendString);  
Stringer.removeLineStart(File textFile, String appendString);

>**Example:** 
String result = Stringer.removeLineStart("@@@aZ", "@");
//result = @@aZ

>**Example2:** 
String result = Stringer.appendLineStart("@aZ\n"+"@aD", "@");
//result = aZ\naD

## Remove a String to the end of each line
Stringer.removeLineEnd(String source, String appendString);  
Stringer.removeLineEnd(File textFile, String appendString);
>**Example:** 
String result = Stringer.removeLineEnd("a@Z@", "@");
//result = a@Z

>**Example2:** 
String result = Stringer.removeLineEnd("aZ@\n"+"aD@", "@");
//result = aZ\naD
