# This is a java lib for commonly used String manipulation

## Insert 
## Between two elements 

>**Example:** 
String result = Stringer.insertText("aZ", "@", "a", "Z");
//result = a@Z

- Stringer.insertText(String source, String insertText, String textOnTheLeft, String textOnTheRight);  
- Stringer.insertText(File textFile, String insertText, String textOnTheLeft, String textOnTheRight);

## Start of each line

>**Example:** 
String result = Stringer.appendLineStart("aZ", "@");
//result = @aZ

>**Example2:** 
String result = Stringer.appendLineStart("aZ\n"+"aD", "@");
//result = @aZ\n@aD

- Stringer.appendLineStart(String source, String appendString);  
- Stringer.appendLineStart(File textFile, String appendString);


## End of each line

>**Example:** 
String result = Stringer.appendLineEnd("aZ", "@");
//result = aZ@

>**Example2:** 
String result = Stringer.appendLineEnd("aZ\n"+"aD", "@");
//result = aZ@\naD@

- Stringer.appendLineEnd(String source, String appendString);  
- Stringer.appendLineEnd(File textFile, String appendString);

## Remove  
## Between two elements!  

>**Example:** 
String result = Stringer.removeBetween("a@@@@@@Z", "@", "a", "Z");
//result = aZ

- Stringer.removeBetween(String source, String removeText, String textOnTheLeft, String textOnTheRight);  
- Stringer.removeBetween(File textFile, String removeText, String textOnTheLeft, String textOnTheRight);

## Start of each line

>**Example:** 
String result = Stringer.removeLineStart("@@@aZ", "@");
//result = @@aZ

>**Example2:** 
String result = Stringer.removeLineStart("@aZ\n"+"@aD", "@");
//result = aZ\naD

- Stringer.removeLineStart(String source, String appendString);  
- Stringer.removeLineStart(File textFile, String appendString);

## End of each line

>**Example:** 
String result = Stringer.removeLineEnd("a@Z@", "@");
//result = a@Z

>**Example2:** 
String result = Stringer.removeLineEnd("aZ@\n"+"aD@", "@");
//result = aZ\naD

- Stringer.removeLineEnd(String source, String appendString);  
- Stringer.removeLineEnd(File textFile, String appendString);

## Custom Functions

>**Example:**  
<pre>
        TextActioner actioner = new ReadText.Actioner() {  
            @Override   
            public String actOnLine(String line) {  
                return "abc" + line + "abc";  
            }  
        };  
</pre>
String result = Stringer.editLines("aZ@\n"+"aD@", actioner);
//result = abcaZ@abc\nabcaD@abc;
