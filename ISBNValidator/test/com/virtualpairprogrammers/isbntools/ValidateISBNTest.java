package com.virtualpairprogrammers.isbntools;
import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ValidateISBNTest
{

    @Test
    public void checkAValid10DigitISBN()
    {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue("First value",result);

        result = validator.checkISBN("0140177396");
        assertTrue("Second value", result);
    }

    @Test
    public void checkAnInvalid10DigitISBN()
    {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }


    @Test
    public void checkAValid13DigitISBN()
    {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781853260087");
        assertTrue(result);
    }


    @Test
    public void checkAnInvalid13DigitISBN()
    {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781853260088");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void checkInvalidISBNLength()
    {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("123456789");
    }

    @Test
    public void checkValidISBNEndingWithX()
    {
        ValidateISBN validator = new ValidateISBN();
        boolean value = validator.checkISBN("012000030X");
        assertTrue(value);
    }

    @Test(expected = NumberFormatException.class)
    public void checkInvalidISBNCharacters()
    {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("014017739y");
    }




}
