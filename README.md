This is a java lib for commonly used String manipulation
## Insert a String in between two elements!
Stringer.insertText(String source, String insertText, String textOnTheLeft, String textOnTheRight);
>**Example:** 
String result = Stringer.insertText("aZ", "@", "a", "Z");
//result = a@Z

## Append a String to the start of each line
Stringer.appendLineStart(String source, String appendString);
>**Example:** 
String result = Stringer.appendLineStart("aZ", "@");
//result = @aZ

>**Example2:** 
String result = Stringer.appendLineStart("aZ\n"+"aD", "@");
//result = @aZ@aD

## Append a String to the end of each line
Stringer.appendLineEnd(String source, String appendString);
>**Example:** 
String result = Stringer.appendLineEnd("aZ", "@");
//result = aZ@

>**Example2:** 
String result = Stringer.appendLineEnd("aZ\n"+"aD", "@");
//result = aZ@aD@
