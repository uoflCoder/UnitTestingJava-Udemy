package com.virtualpairprogrammers.isbntools;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;


public class StockManagementTests
{

    ExternalISBNDataService databaseService;
    ExternalISBNDataService webService;
    StockManager stockManager;


    @Before
    public void setup()
    {
        databaseService = mock(ExternalISBNDataService.class);
        webService = mock(ExternalISBNDataService.class);
        stockManager = new StockManager();
        stockManager.setDatabaseService(databaseService);
        stockManager.setWebService(webService);
    }

    @Test
    public void testCanGetACorrectLocatorCodeFromDatabase()
    {
        String isbn = "0140177396";

        when(databaseService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));
        when(webService.lookup(isbn)).thenReturn(null);

        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);


    }


    @Test
    public void testCanGetACorrectLocatorCodeFromWebService()
    {
        String isbn = "0140177396";

        when(databaseService.lookup(isbn)).thenReturn(null);
        when(webService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);


    }

    @Test
    public void databaseIsUsedIfDataIsPresent()
    {
        when(databaseService.lookup("0140177396")).thenReturn(new Book("010177396", "abc", "abc"));


        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);

        verify(databaseService, times(1)).lookup("0140177396");
        verify(webService, never()).lookup(anyString());

    }

    @Test
    public void webServiceUsedIfDataNotPresentInDatabase()
    {
        String isbn = "0140177396";

        when(databaseService.lookup(isbn)).thenReturn(null);
        when(webService.lookup(isbn)).thenReturn(new Book(isbn, "abc", "abc"));

        String locatorCode = stockManager.getLocatorCode(isbn);

        verify(databaseService, times(1)).lookup(isbn);
        verify(webService, times(1)).lookup(isbn);


    }


}
