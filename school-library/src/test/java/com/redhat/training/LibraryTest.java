package com.redhat.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertTrue;

import com.redhat.training.books.Book;
import com.redhat.training.books.BookNotAvailableException;
import com.redhat.training.inventory.InMemoryInventory;


public class LibraryTest {

    InMemoryInventory inventory;
    Library library;

    @BeforeEach
    public void setUp() {
        inventory = new InMemoryInventory();
        library = new Library(inventory);
    }

    // Add tests here...
    @Test
    public void checkingOutDecreasesNumberOfBookCopiesFromInventory()
        throws BookNotAvailableException { 
            // Given    
            inventory.add(new Book("book1"));    
            inventory.add(new Book("book1"));    
            // When    
            library.checkOut("someStudentId", "book1");    
            // Then    
            assertEquals(1, inventory.countCopies("book1"));
        }
}
