// Name: Steve Regala
// USC NetID: sregala
// CSCI455 PA2
// Fall 2021


/**
 * Class BookshelfKeeper 
 *
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in 
 * non-decreasing order by height, with the restriction that single books can only be added 
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put 
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 */
public class BookshelfKeeper {

    /**
      Representation invariant:

      <put rep. invar. comment here>
      - The contained Bookshelf object is always in non-decreasing order
      - numCallMutator (number of mutator calls, pick and put) is always greater than or equal to 0
      - totalMutatorCall (accumulated number of pick and put calls) is always be greater than or equal to numCallMutator

   */
   
   // <add instance variables here>
   private Bookshelf bookshelfObject;
   private int numCallMutator;         // will keep track of number of mutator calls per pick and put call
   private int totalMutatorCall;       // accumulates number of all mutator calls


   /**
    * Creates a BookShelfKeeper object with an empty bookshelf
    */
   public BookshelfKeeper() {

      bookshelfObject = new Bookshelf();
      assert isValidBookshelfKeeper();

   }

   /**
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: method does not make a defensive copy of the bookshelf.
    *
    * PRE: sortedBookshelf.isSorted() is true.
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {

      bookshelfObject = sortedBookshelf;
      assert isValidBookshelfKeeper();

   }

   /**
    * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted 
    * after picking up the book.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: 0 <= position < getNumBooks()
    */
   public int pickPos(int position) {

      // pass in values given position and contained bookshelf object into helper function; returns number of calls in this pick operation
      numCallMutator = pickPosHelperFunction(position, bookshelfObject);

      totalMutatorCall += numCallMutator;

      assert isValidBookshelfKeeper();
      return numCallMutator;

   }

   /**
    * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted 
    * after the insertion.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: height > 0
    */
   public int putHeight(int height) {

      // pass in values given height and contained bookshelf object into helper function; returns number of calls in this put operation
      numCallMutator = putHeightHelperFunction(height, bookshelfObject);

      totalMutatorCall += numCallMutator;

      assert isValidBookshelfKeeper();
      return numCallMutator;

   }

   /**
    * Returns the total number of calls made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    */
   public int getTotalOperations() {

      assert isValidBookshelfKeeper();
      return totalMutatorCall;

   }

   /**
    * Returns the number of books on the contained bookshelf.
    */
   public int getNumBooks() {

      assert isValidBookshelfKeeper();
      return bookshelfObject.size();

   }

   /**
    * Returns string representation of this BookshelfKeeper. Returns a String containing height
    * of all books present in the bookshelf in the order they are on the bookshelf, followed 
    * by the number of bookshelf mutator calls made to perform the last pick or put operation, 
    * followed by the total number of such calls made since we created this BookshelfKeeper.
    * 
    * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
    * 
    */
   public String toString() {

      assert isValidBookshelfKeeper();
      return bookshelfObject.toString() + " " + numCallMutator + " " + totalMutatorCall;   // return only modified Bookshelf object
      
   }

   /**
    * Returns true iff the BookshelfKeeper data is in a valid state.
    * (See representation invariant comment for details.)
    */
   private boolean isValidBookshelfKeeper() {

      /*
      - The contained Bookshelf object is always in non-decreasing order
      - numCallMutator is always greater than or equal to 0
      - totalMutatorCall is always be greater than or equal to numCallMutator
       */

      if (!bookshelfObject.isSorted()) {
         return false;
      }

      else {
         if (numCallMutator < 0) {
            return false;
         }
         else {
            if (totalMutatorCall < numCallMutator) {
               return false;
            }
            return true;
         }
      }

   }

   // add any other private methods here

   /**
    * Returns the number of mutator calls in the pick operation.
    * Private helper function for the function pickPos; it performs the pick operation on the contained bookshelf object.
    *
    * PRE: positionGiven must be a valid index, it must be within the bounds of the bookshelf object (non-empty bookshelf: 0 to realObject.size() - 1)
    * PRE: realObject is the non-empty bookshelf object that must be sorted in non-decreasing order
   */
   private static int pickPosHelperFunction(int positionGiven, Bookshelf realObject) {

      int numCallMutatorCounter = 0;
      Bookshelf tempBookshelf = new Bookshelf();

      // enter LEFT side of object arrayList
      if (positionGiven < realObject.size()/2) {
         for (int i = 0; i <= positionGiven; i++) {                  // remove values until reach position
            tempBookshelf.addLast(realObject.removeFront());
            numCallMutatorCounter++;
         }

         tempBookshelf.removeLast();                                // gets rid of last element in tempBookshelf, i.e. desired value
         while (tempBookshelf.size() > 0) {
            realObject.addFront(tempBookshelf.removeLast());
            numCallMutatorCounter++;
         }
      }

      // enter RIGHT side of object arrayList
      else {
         for (int i = realObject.size() - 1; i >= positionGiven; i--) {    // remove values until reach position
            tempBookshelf.addLast(realObject.removeLast());
            numCallMutatorCounter++;
         }
         tempBookshelf.removeLast();                                       // gets rid of last element in tempBookshelf, i.e. desired value
         while (tempBookshelf.size() > 0) {
            realObject.addLast((tempBookshelf.removeLast()));
            numCallMutatorCounter++;
         }
      }

      return numCallMutatorCounter;

   }

   /**
    * Returns the number of mutator calls in the put operation.
    * Private helper function for the function putHeight; it performs the put operation on the contained bookshelf object
    *
    * PRE: heightGiven must be a positive value, i.e. heightGiven > 0
    * PRE: realObject is an empty/non-empty bookshelf object that must be sorted in non-decreasing order
    */
   private static int putHeightHelperFunction(int heightGiven, Bookshelf realObject) {

      int numCallMutatorCounter = 0;
      int tempIndex = -1;           // this variable will hold index one after where height should be placed
      Bookshelf tempBookshelf = new Bookshelf();

      // determines the index one after where height should be placed
      for (int i = 0; i < realObject.size(); i++) {
         if (heightGiven < realObject.getHeight(i)) {
            tempIndex = i;
            break;      // exit the for-loop at the FIRST instance that height is less than value at index i
         }
      }

      // takes care of when height is bigger than all the values in Bookshelf object, i.e. when height should be at the end
      if (tempIndex == -1) {
         realObject.addLast(heightGiven);
         numCallMutatorCounter++;
      }

      // enter LEFT side of object arrayList
      else if (tempIndex <= realObject.size()/2) {
         for (int i = 0; i < tempIndex; i++) {
            tempBookshelf.addLast(realObject.removeFront());
            numCallMutatorCounter++;
         }

         realObject.addFront(heightGiven);
         numCallMutatorCounter++;
         while (tempBookshelf.size() > 0) {
            realObject.addFront(tempBookshelf.removeLast());
            numCallMutatorCounter++;
         }
      }

      // enter RIGHT side of object arrayList
      else {
         for (int i = realObject.size()-1; i >= tempIndex; i--) {   // tempIndex because height should go before tempIndex
            tempBookshelf.addLast(realObject.removeLast());
            numCallMutatorCounter++;
         }

         realObject.addLast(heightGiven);
         numCallMutatorCounter++;
         while (tempBookshelf.size() > 0) {
            realObject.addLast(tempBookshelf.removeLast());
            numCallMutatorCounter++;
         }
      }

      return numCallMutatorCounter;

   }

}
