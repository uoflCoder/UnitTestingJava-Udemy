package com.virtualpairprogrammers.isbntools;

public class ExternalISBNDataServiceImplementation implements ExternalISBNDataService
{
    @Override public Book lookup(String isbn)
    {
        return new Book(isbn, "Of Mice And Men", "J. Steinbeck");
    }
}
