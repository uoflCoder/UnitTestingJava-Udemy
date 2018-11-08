package com.virtualpairprogrammers.isbntools;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ValidateISBNTest
{

    @Test
    public void checkAValidISBN()
    {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue("First value",result);

        result = validator.checkISBN("0140177396");
        assertTrue("Second value", result);
    }

    @Test
    public void checkAnInvalidISBN()
    {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }


}
