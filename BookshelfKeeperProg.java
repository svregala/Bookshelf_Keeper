// Name: Steve Regala
// USC NetID: sregala
// CSCI455 PA2
// Fall 2021

import java.util.Scanner;
import java.util.ArrayList;


/**
 * Contains the main method
 * Prompts for the initial list of numbers and performs the valid pick and put operations
 * Depends on both Bookshelf class and BookshelfKeeper class
 */
public class BookshelfKeeperProg {

   public static void main(String[] args) {

      Scanner in = new Scanner(System.in);

      // we pass in our only Scanner object to read from System.in into our private helper method beginProgram
      beginProgram(in);

   }


   /**
    * This method contains the main functions such as prompting the user to input a list of numbers, error checking, creating Bookshelf object and BookshelfKeeper.
    * The logistics of this program start when we pass in our Scanner object, this is where the program mainly occurs:
    *    It creates the array that the user inputs and error checks it.
    *    It creates the bookshelf and bookshelfKeeper object.
    *    It calls functions to do more necessary error checking as described in the program comments and private helper functions below.
    *
    * PRE: in must be an object of type Scanner to read from System.in
    */
   private static void beginProgram(Scanner in) {

      System.out.println("Please enter initial arrangement of books followed by newline:");
      String initialUserInput = in.nextLine();
      Scanner initialScan = new Scanner(initialUserInput);     // created Scanner object that have different data source

      ArrayList<Integer> userList = new ArrayList<Integer>();
      while (initialScan.hasNext()) {
         userList.add(initialScan.nextInt());                  // place integers from the string input into array list
      }

      if (checkNegative(userList)) {            // pass in the array list into a helper method that checks for negative values in array list

         Bookshelf userBookshelf = new Bookshelf(userList);

         if (checkOrder(userBookshelf)) {       // check if initial arrangement of books is in non-decreasing order

            BookshelfKeeper userKeeper = new BookshelfKeeper(userBookshelf);
            System.out.println(userKeeper.toString());

            System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
            String userInput = in.nextLine();

            performPickPut(userInput, userKeeper, in);     // pass in put/pick operation inputted by user into helper method to check if the input is valid

         }

         else {
            System.out.println("ERROR: Heights must be specified in non-decreasing order.");
         }

      }

      else {
         System.out.println("ERROR: Height of a book must be positive.");
      }

      System.out.println("Exiting Program.");

   }


   /**
    * Returns true iff the array list does NOT have any negative values.
    *
    * PRE: listArray must be an array list of type ArrayList<Integer>
    */
   private static boolean checkNegative(ArrayList<Integer> listArray) {

      for (int i=0; i< listArray.size(); i++) {
         if (listArray.get(i) <= 0) {
            return false;
         }
      }
      return true;

   }


   /**
    * Returns true iff the bookshelf object is sorted in non-decreasing order.
    *
    * PRE: userBookshelfObject must be an object of type Bookshelf
    */
   private static boolean checkOrder(Bookshelf userBookshelfObject) {

      if (userBookshelfObject.isSorted()) {
         return true;
      }
      return false;

   }


   /**
    * This private method will proceed with the pick and put operations (this program will be called after checking validity of the initial array list from the user).
    *    That is, if the initial array list is free of negative values and is in non-decreasing order, it will proceed to perform pick and put operations.
    *    Additionally, it will error check the pick and put operations provided by the user.
    *
    * PRE: inputFromUser must be a string; this method will error check if the values are valid inputs such as "pick 3", "put 10", "pick 0', "put 46"
    * PRE: keeperObject must be the object of type BookshelfKeeper, that we constantly call different methods on such as pickPos and putHeight
    *       This object contains the values that were initially placed into the contained bookshelf.
    * PRE: inHere must be of type Scanner; it is the scanner object that we pass in to ensure that we will constantly receive input from the user, until otherwise directed
    */
   private static void performPickPut(String inputFromUser, BookshelfKeeper keeperObject, Scanner inHere) {

      while (!inputFromUser.equals("end")) {

         Scanner scanner = new Scanner(inputFromUser);
         String bookAction = scanner.next();    // read in either 'put' or 'pick'
         int bookNumber = scanner.nextInt();    // read in the integer that follows the bookAction

         if (bookAction.equals("put") || bookAction.equals("pick")) {            // if the book action from the user is neither 'put' nor 'pick', go to else statement

            if (bookAction.equals("put")) {
               if (checkIndexHeight(keeperObject, bookNumber, bookAction)) {     // pass 'put', the corresponding number, and bookshelfKeeper object into checkIndexHeight function (function described before helper function is defined)
                  keeperObject.putHeight(bookNumber);                            // checkIndexHeight is a private boolean function
               }

               else {
                  break;
               }
            }

            else {
               if (checkIndexHeight(keeperObject, bookNumber, bookAction)) {     // pass 'pick', the corresponding number, and bookshelfKeeper object into checkIndexHeight function (function described before helper function is defined)
                  keeperObject.pickPos(bookNumber);
               }
               else {
                  break;
               }
            }

            System.out.println(keeperObject.toString());
            inputFromUser = inHere.nextLine();              // if there are no errors in the user input, proceed to ask for more 'pick', 'put' commands
         }

         else {
            System.out.println("ERROR: Invalid command. Valid commands are pick, put, or end.");
            break;
         }

      }

   }


   /**
    * Returns true iff the user puts a positive height OR picks an index within the bounds of the bookshelf object.
    *    i.e. Returns true if it does not violate any of the following errors: can't put a negative height, can't pick a negative index, can't put height 0, can't pick an index > size-1.
    *
    * PRE: shelfKeeper must be an object of type BookshelfKeeper
    * PRE: bookIndexOrHeight must be an integer; it follows the commands 'pick' or 'put'
    * PRE: actionPerform must be a string; it is the 'pick', 'put' commands
    */
   private static boolean checkIndexHeight(BookshelfKeeper shelfKeeper, int bookIndexOrHeight, String actionPerform) {

      if (bookIndexOrHeight < 0) {
         if (actionPerform.equals("put")) {
            System.out.println("ERROR: Height of a book must be positive.");                  // cannot put a negative height
         }
         else {
            System.out.println("ERROR: Entered pick operation is invalid on this shelf.");    // cannot pick a negative index
         }
         return false;
      }

      else {

         if (actionPerform.equals("put")) {
            if (bookIndexOrHeight == 0) {
               System.out.println("ERROR: Height of a book must be positive.");               // cannot put a book of height 0
               return false;
            }
            else {
               return true;
            }
         }

         else {
            if (bookIndexOrHeight > shelfKeeper.getNumBooks() - 1) {
               System.out.println("ERROR: Entered pick operation is invalid on this shelf."); // cannot pick an index that is beyond the bounds, i.e. an index greater than the last possible index
               return false;
            }
            return true;
         }

      }

   }

}