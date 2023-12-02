// Name: Steve Regala
// USC NetID: sregala
// CSCI455 PA2
// Fall 2021


import java.util.ArrayList;

/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.   
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
*/

public class Bookshelf {

    /**
      Representation invariant:

      <put rep. invar. comment here>
      - ArrayList listOfBooks can be empty OR can only contain/add numbers greater than 0

   */

   // <add instance variables here>
   private ArrayList<Integer> listOfBooks;

   /**
    * Creates an empty Bookshelf object i.e. with no books
    */
   public Bookshelf() {

      listOfBooks = new ArrayList<Integer>();
      assert isValidBookshelf();  // sample assert statement (you will be adding more of these calls)

   }


   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    * 
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    */
   public Bookshelf(ArrayList<Integer> pileOfBooks) {

      listOfBooks = new ArrayList<>(pileOfBooks);
      assert isValidBookshelf();
 
   }


   /**
    * Inserts book with specified height at the start of the Bookshelf, i.e., it
    * will end up at position 0.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addFront(int height) {

      listOfBooks.add(0, height);      // adds element to specified location, shifts the rest to the right
      assert isValidBookshelf();

   }


   /**
    * Inserts book with specified height at the end of the Bookshelf.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addLast(int height) {

      listOfBooks.add(height);
      assert isValidBookshelf();
      
   }


   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeFront() {

      int frontElement = listOfBooks.get(0);
      listOfBooks.remove(0);
      assert isValidBookshelf();
      return frontElement;
      
   }


   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeLast() {

      int endElement = listOfBooks.get(listOfBooks.size()-1);
      listOfBooks.remove(listOfBooks.size()-1);
      assert isValidBookshelf();
      return endElement;

   }

   /**
    * Gets the height of the book at the given position.
    * 
    * PRE: 0 <= position < this.size()
    */
   public int getHeight(int position) {

      assert isValidBookshelf();
      return listOfBooks.get(position);
      
   }


   /**
    * Returns number of books on the Bookshelf.
    */
   public int size() {

      assert isValidBookshelf();
      return listOfBooks.size();

   }


   /**
    * Returns string representation of this Bookshelf. Returns a string with the height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
    * by example here:  “[7, 33, 5, 4, 3]”
    */
   public String toString() {

      assert isValidBookshelf();
      return listOfBooks.toString();      // ArrayList API states toString method is inherited from class java.util.AbstractCollection

   }

   /**
    * Returns true iff the books on this Bookshelf are in non-decreasing order.
    * (Note: this is an accessor; it does not change the bookshelf.)
    */
   public boolean isSorted() {

      for (int i=0; i < listOfBooks.size(); ++i) {
         if (i != listOfBooks.size()-1) {        // if 'i' reaches the last index, don't compare
            if (listOfBooks.get(i) > listOfBooks.get(i + 1)) {
               assert isValidBookshelf();
               return false;
            }
         }
      }
      assert isValidBookshelf();
      return true;

   }

   /**
    * Returns true iff the Bookshelf data is in a valid state.
    * (See representation invariant comment for more details.)
    */
   private boolean isValidBookshelf() {

      for (int i=0; i<listOfBooks.size(); i++)
      {
         if (listOfBooks.get(i) <= 0) {         // checking to see if any value in bookshelf object is less than or equal to 0
            return false;
         }
      }
      return true;

   }

}