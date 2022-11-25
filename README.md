# JunitExamples
 First run java file which is present in src/main folder .
 This java file creates text file with following conditions.
   - Output file name is "Test File Finance.txt" and it is saved in \src folder of Java project 
   - 2 header lines (with fixed heading text width of 80 characters*) as follows:
        - 1st line is 80 times repeated single character '=',
        - 2nd line is right-justified containing text 'Sample Company'   (padded with spaces* to right-justify)
   - page ends with 3 footer lines of 65 characters width  
        - 1st line is 65 repeated '-', (simple dash character)  
        - 2nd line is cantered text 'page Number 
        - 3rd line is following text ' S a m p l e    C o m p a n y' ,  left justified 
   - 50 lines make the body of text 
        - lines are made up of words and word separators 
        - word separators are: SPACE, COMMA,FULL STOP,
        - words are random length strings of characters that are between 1 and 10 characters, where string consist of Basic Latin characters from A-Z, a-z  
        - random length strings of numbers characters that is formatted as money data type, namely $999,999,999,999.99   
        - line length is random and between 60 and 120 characters (Unicode characters) per each body line (excluding CARRIAGE RETURN
        - line is constructed of words, and words are separated by space or tab characters
   - other  
        - randomly use string "Finance" as a word in 1 place in text. 
        - randomly use string "finance" as a word in 2 places in text
        - on each page use string "testing" once (so every set of 55 lines will contain word testing once)
        - Last page is 55 lines long as well, empty lines to be used to fill between last line of text and last page header
        - Very last line in text is '<EOF>'  
        
Test file is present in src/test folder
Need to select JUnit4
FileTest.java contain 3 test as follows :
  i - ing test if able to find a straight matching text from a response saved to a file 
  ii - Passing test if able to find a matching text using patterns from a response saved to a file
  iii - Passing test if able to confirm text  "S a m p l e    C o m p a n y" exists
