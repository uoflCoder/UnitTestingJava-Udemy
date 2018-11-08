package com.virtualpairprogrammers.isbntools;

public class ValidateISBN
{
    public boolean checkISBN(String isbn)
    {
       int total = 0;

       for(int i = 0; i < isbn.length(); i++)
       {
           total = total +   ((10 - i) * Integer.parseInt(Character.toString(isbn.charAt(i))));
       }

       if(total % 11 == 0)
       {
           return true;
       }

        return false;
    }
}
