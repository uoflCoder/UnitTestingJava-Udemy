package com.virtualpairprogrammers.isbntools;

public class ValidateISBN
{
    public static final int SHORT_ISBN_LENGTH = 10;
    public static final int LONG_ISBN_LENGTH = 13;
    public static final int SHORT_ISBN_DIVIDER = 10;
    public static final int LONG_ISBN_DIVIDER = 11;

    public boolean checkISBN(String isbn)
    {
        if (isbn.length() != SHORT_ISBN_LENGTH && isbn.length() != LONG_ISBN_LENGTH)
        {
            throw new NumberFormatException("ISBN must be 10 or 13 digits long");
        }

        else if (isbn.length() == LONG_ISBN_LENGTH)
        {
            return isValidLongISBN(isbn);
        }

        else
        {
            return isValidShortISBN(isbn);
        }
    }

    private boolean isValidShortISBN(String isbn)
    {
        int total = 0;
        for (int i = 0; i < SHORT_ISBN_LENGTH; i++)
        {


            if (!Character.isDigit(isbn.charAt(i)))
            {
                if (i == 9 && isbn.charAt(i) == 'X')
                {
                    total = total + 10;
                } else
                {

                    throw new NumberFormatException("ISBN must only contain digits or X as last character");
                }
            }

            else
            {

                total = total + ((SHORT_ISBN_LENGTH - i) * Character.getNumericValue(isbn.charAt(i)));

            }
        }
        return total % LONG_ISBN_DIVIDER == 0;
    }

    private boolean isValidLongISBN(String isbn)
    {
        int total = 0;
        for(int i = 0; i < LONG_ISBN_LENGTH; i++)
        {

            if (!Character.isDigit(isbn.charAt(i)))
            {
                throw new NumberFormatException("ISBN must only contain digits");
            }


            if(i % 2 == 0)
            {
                total = total + Character.getNumericValue(isbn.charAt(i));
            }

            else
            {
                total = total + (3 * Character.getNumericValue(isbn.charAt(i)));
            }
        }
        return total % SHORT_ISBN_DIVIDER == 0;
    }


}