
import java.util.ArrayList;

public class BookshelfKeeperTester {

   public static void main(String[] arg) {

      testPickPos();
      System.out.println("--------------------------------------------------------------");
      System.out.println();
      System.out.println("--------------------------------------------------------------");

      testPutHeight();
      System.out.println("--------------------------------------------------------------");
      System.out.println();
      System.out.println("--------------------------------------------------------------");

      testToString();


   }

   private static void testPickPos() {

      System.out.println();
      System.out.println("TESTING pickPos FUNCTION:");
      System.out.println();
      System.out.println("Testing BookshelfKeeper (EVEN ARRAY CASE):");
      System.out.println();

      ArrayList<Integer> arrayListOfBooks = new ArrayList<Integer>();
      arrayListOfBooks.add(2);
      arrayListOfBooks.add(5);
      arrayListOfBooks.add(8);
      arrayListOfBooks.add(12);
      arrayListOfBooks.add(13);
      arrayListOfBooks.add(18);

      ArrayList<Integer> arrayListOfBooks2 = new ArrayList<Integer>();
      arrayListOfBooks2.add(2);
      arrayListOfBooks2.add(5);
      arrayListOfBooks2.add(8);
      arrayListOfBooks2.add(12);
      arrayListOfBooks2.add(13);
      arrayListOfBooks2.add(18);

      ArrayList<Integer> arrayListOfBooks3 = new ArrayList<Integer>();
      arrayListOfBooks3.add(2);
      arrayListOfBooks3.add(5);
      arrayListOfBooks3.add(8);
      arrayListOfBooks3.add(12);
      arrayListOfBooks3.add(13);
      arrayListOfBooks3.add(18);

      Bookshelf bookList = new Bookshelf(arrayListOfBooks);
      System.out.println("Original Bookshelf object in BookshelfKeeper #1 object: " + bookList.toString());
      BookshelfKeeper exampleKeeper1 = new BookshelfKeeper(bookList);
      System.out.println("Remove index 3 -->");
      System.out.println("Number of Mutators: " + exampleKeeper1.pickPos(3));
      System.out.println("Expected: [2, 5, 8, 13, 18]");
      System.out.println("Actual: " + exampleKeeper1.toString());
      System.out.println();

      Bookshelf bookList2 = new Bookshelf(arrayListOfBooks2);
      System.out.println("Original Bookshelf object in BookshelfKeeper #2 object: " + bookList2.toString());
      BookshelfKeeper exampleKeeper2 = new BookshelfKeeper(bookList2);
      System.out.println("Remove index 2 -->");
      System.out.println("Number of Mutators: " + exampleKeeper2.pickPos(2));
      System.out.println("Expected: [2, 5, 12, 13, 18]");
      System.out.println("Actual: " + exampleKeeper2.toString());
      System.out.println();

      // Remove first index, and then last index
      Bookshelf bookList3 = new Bookshelf(arrayListOfBooks3);
      System.out.println("Original Bookshelf object in BookshelfKeeper #3 object: " + bookList3.toString());
      BookshelfKeeper exampleKeeper3 = new BookshelfKeeper(bookList3);
      System.out.println("Remove 1st index -->");
      System.out.println("Number of Mutators: " + exampleKeeper3.pickPos(0));
      System.out.println("Expected: [5, 8, 12, 13, 18]");
      System.out.println("Actual: " + exampleKeeper3.toString());
      System.out.println();

      System.out.println("Now remove last index -->");
      System.out.println("Number of Mutators: " + exampleKeeper3.pickPos(4));
      System.out.println("Expected: [5, 8, 12, 13]");
      System.out.println("Actual: " + exampleKeeper3.toString());
      System.out.println();

      // Test Case #6
      ArrayList<Integer> arrayListOfBooks6 = new ArrayList<Integer>();
      arrayListOfBooks6.add(2);
      arrayListOfBooks6.add(5);
      arrayListOfBooks6.add(8);
      arrayListOfBooks6.add(12);
      arrayListOfBooks6.add(13);
      arrayListOfBooks6.add(18);

      Bookshelf bookList6 = new Bookshelf(arrayListOfBooks6);
      System.out.println("Original Bookshelf object in BookshelfKeeper #6 object: " + bookList6.toString());
      BookshelfKeeper exampleKeeper6 = new BookshelfKeeper(bookList6);
      System.out.println("Remove index 4 -->");
      System.out.println("Number of Mutators: " + exampleKeeper6.pickPos(4));
      System.out.println("Expected: [2, 5, 8, 12, 18]");
      System.out.println("Actual: " + exampleKeeper6.toString());
      System.out.println();

      // Test Case #7
      ArrayList<Integer> arrayListOfBooks7 = new ArrayList<Integer>();
      arrayListOfBooks7.add(2);
      arrayListOfBooks7.add(5);
      arrayListOfBooks7.add(8);
      arrayListOfBooks7.add(12);
      arrayListOfBooks7.add(13);
      arrayListOfBooks7.add(18);

      Bookshelf bookList7 = new Bookshelf(arrayListOfBooks7);
      System.out.println("Original Bookshelf object in BookshelfKeeper #7 object: " + bookList7.toString());
      BookshelfKeeper exampleKeeper7 = new BookshelfKeeper(bookList7);
      System.out.println("Remove index 1 -->");
      System.out.println("Number of Mutators: " + exampleKeeper7.pickPos(1));
      System.out.println("Expected: [2, 8, 12, 13, 18]");
      System.out.println("Actual: " + exampleKeeper7.toString());
      System.out.println();

      // -------------------------------------------------------------

      System.out.println();
      System.out.println("Testing BookshelfKeeper (ODD ARRAY CASE):");
      System.out.println();

      ArrayList<Integer> arrayListOfBooks4 = new ArrayList<Integer>();
      arrayListOfBooks4.add(2);
      arrayListOfBooks4.add(5);
      arrayListOfBooks4.add(8);
      arrayListOfBooks4.add(12);
      arrayListOfBooks4.add(13);
      arrayListOfBooks4.add(18);
      arrayListOfBooks4.add(24);

      ArrayList<Integer> arrayListOfBooks5 = new ArrayList<Integer>();
      arrayListOfBooks5.add(2);
      arrayListOfBooks5.add(5);
      arrayListOfBooks5.add(8);
      arrayListOfBooks5.add(12);
      arrayListOfBooks5.add(13);
      arrayListOfBooks5.add(18);
      arrayListOfBooks5.add(24);

      Bookshelf bookList4 = new Bookshelf(arrayListOfBooks4);
      System.out.println("Original Bookshelf object in BookshelfKeeper #4 object: " + bookList4.toString());
      BookshelfKeeper exampleKeeper4 = new BookshelfKeeper(bookList4);
      System.out.println("Remove index 3 -->");
      System.out.println("Number of Mutators: " + exampleKeeper4.pickPos(3));
      System.out.println("Expected: [2, 5, 8, 13, 18, 24]");
      System.out.println("Actual: " + exampleKeeper4.toString());
      System.out.println();

      Bookshelf bookList5 = new Bookshelf(arrayListOfBooks5);
      System.out.println("Original Bookshelf object in BookshelfKeeper #5 object: " + bookList5.toString());
      BookshelfKeeper exampleKeeper5 = new BookshelfKeeper(bookList5);
      System.out.println("Remove index 4 -->");
      System.out.println("Number of Mutators: " + exampleKeeper5.pickPos(4));
      System.out.println("Expected: [2, 5, 8, 12, 18, 24]");
      System.out.println("Actual: " + exampleKeeper5.toString());
      System.out.println();


      // Test Case #8
      ArrayList<Integer> arrayListOfBooks8 = new ArrayList<Integer>();
      arrayListOfBooks8.add(2);
      arrayListOfBooks8.add(5);
      arrayListOfBooks8.add(8);
      arrayListOfBooks8.add(12);
      arrayListOfBooks8.add(13);
      arrayListOfBooks8.add(18);
      arrayListOfBooks8.add(24);

      Bookshelf bookList8 = new Bookshelf(arrayListOfBooks8);
      System.out.println("Original Bookshelf object in BookshelfKeeper #8 object: " + bookList8.toString());
      BookshelfKeeper exampleKeeper8 = new BookshelfKeeper(bookList8);
      System.out.println("Remove index 2 -->");
      System.out.println("Number of Mutators: " + exampleKeeper8.pickPos(2));
      System.out.println("Expected: [2, 5, 12, 13, 18, 24]");
      System.out.println("Actual: " + exampleKeeper8.toString());
      System.out.println();

      // Test Case #9
      ArrayList<Integer> arrayListOfBooks9 = new ArrayList<Integer>();
      arrayListOfBooks9.add(2);
      arrayListOfBooks9.add(5);
      arrayListOfBooks9.add(8);
      arrayListOfBooks9.add(12);
      arrayListOfBooks9.add(13);
      arrayListOfBooks9.add(18);
      arrayListOfBooks9.add(24);

      Bookshelf bookList9 = new Bookshelf(arrayListOfBooks9);
      System.out.println("Original Bookshelf object in BookshelfKeeper #9 object: " + bookList9.toString());
      BookshelfKeeper exampleKeeper9 = new BookshelfKeeper(bookList9);
      System.out.println("Remove index 5 -->");
      System.out.println("Number of Mutators: " + exampleKeeper9.pickPos(5));
      System.out.println("Expected: [2, 5, 8, 12, 13, 24]");
      System.out.println("Actual: " + exampleKeeper9.toString());
      System.out.println();

   }


   private static void testPutHeight() {

      System.out.println();
      System.out.println("TESTING putHeight FUNCTION:");
      System.out.println();

      // Test Case #1
      ArrayList<Integer> arrList1 = new ArrayList<Integer>();
      arrList1.add(5);
      arrList1.add(10);
      arrList1.add(15);
      arrList1.add(20);
      arrList1.add(25);
      arrList1.add(30);

      Bookshelf listBook1 = new Bookshelf(arrList1);
      System.out.println("Original Bookshelf object in BookshelfKeeper listBook1: " + listBook1.toString());
      BookshelfKeeper exKeeper1 = new BookshelfKeeper(listBook1);
      System.out.println("Put(22) -->");
      System.out.println("Number of Mutators: " + exKeeper1.putHeight(22));
      System.out.println("Expected: [5, 10, 15, 20, 22, 25, 30]");
      System.out.println("Actual: " + exKeeper1.toString());
      System.out.println();

      // Test Case #2
      ArrayList<Integer> arrList2 = new ArrayList<Integer>();
      arrList2.add(5);
      arrList2.add(10);
      arrList2.add(15);
      arrList2.add(20);
      arrList2.add(25);
      arrList2.add(30);
      arrList2.add(35);

      Bookshelf listBook2 = new Bookshelf(arrList2);
      System.out.println("Original Bookshelf object in BookshelfKeeper listBook2: " + listBook2.toString());
      BookshelfKeeper exKeeper2 = new BookshelfKeeper(listBook2);
      System.out.println("Put(22) -->");
      System.out.println("Number of Mutators: " + exKeeper2.putHeight(22));
      System.out.println("Expected: [5, 10, 15, 20, 22, 25, 30, 35]");
      System.out.println("Actual: " + exKeeper2.toString());
      System.out.println();

      // Test Case #3
      ArrayList<Integer> arrList3 = new ArrayList<Integer>();
      arrList3.add(5);
      arrList3.add(10);
      arrList3.add(15);
      arrList3.add(20);
      arrList3.add(25);
      arrList3.add(30);

      Bookshelf listBook3 = new Bookshelf(arrList3);
      System.out.println("Original Bookshelf object in BookshelfKeeper listBook3: " + listBook3.toString());
      BookshelfKeeper exKeeper3 = new BookshelfKeeper(listBook3);
      System.out.println("Put(1) -->");
      System.out.println("Number of Mutators: " + exKeeper3.putHeight(1));
      System.out.println("Expected: [1, 5, 10, 15, 20, 25, 30]");
      System.out.println("Actual: " + exKeeper3.toString());
      System.out.println();

      // Test Case #4
      ArrayList<Integer> arrList4 = new ArrayList<Integer>();
      arrList4.add(5);
      arrList4.add(10);
      arrList4.add(15);
      arrList4.add(20);
      arrList4.add(25);
      arrList4.add(30);

      Bookshelf listBook4 = new Bookshelf(arrList4);
      System.out.println("Original Bookshelf object in BookshelfKeeper listBook4: " + listBook4.toString());
      BookshelfKeeper exKeeper4 = new BookshelfKeeper(listBook4);
      System.out.println("Put(35) -->");
      System.out.println("Number of Mutators: " + exKeeper4.putHeight(35));
      System.out.println("Expected: [5, 10, 15, 20, 25, 30, 35]");
      System.out.println("Actual: " + exKeeper4.toString());
      System.out.println();

      // Test Case #5
      ArrayList<Integer> arrList5 = new ArrayList<Integer>();
      arrList5.add(5);
      arrList5.add(10);
      arrList5.add(15);
      arrList5.add(20);
      arrList5.add(25);
      arrList5.add(30);
      arrList5.add(35);

      Bookshelf listBook5 = new Bookshelf(arrList5);
      System.out.println("Original Bookshelf object in BookshelfKeeper listBook5: " + listBook5.toString());
      BookshelfKeeper exKeeper5 = new BookshelfKeeper(listBook5);
      System.out.println("Put(17) -->");
      System.out.println("Number of Mutators: " + exKeeper5.putHeight(17));
      System.out.println("Expected: [5, 10, 15, 17, 20, 25, 30, 35]");
      System.out.println("Actual: " + exKeeper5.toString());
      System.out.println();

      // Test Case #6
      ArrayList<Integer> arrList6 = new ArrayList<Integer>();
      arrList6.add(5);
      arrList6.add(10);
      arrList6.add(15);
      arrList6.add(20);
      arrList6.add(25);
      arrList6.add(30);

      Bookshelf listBook6 = new Bookshelf(arrList6);
      System.out.println("Original Bookshelf object in BookshelfKeeper listBook6: " + listBook6.toString());
      BookshelfKeeper exKeeper6 = new BookshelfKeeper(listBook6);
      System.out.println("Put(18) -->");
      System.out.println("Number of Mutators: " + exKeeper6.putHeight(18));
      System.out.println("Expected: [5, 10, 15, 18, 20, 25, 30]");
      System.out.println("Actual: " + exKeeper6.toString());
      System.out.println();

      // Test Case #7
      ArrayList<Integer> arrList7 = new ArrayList<Integer>();
      arrList7.add(5);
      arrList7.add(10);
      arrList7.add(15);
      arrList7.add(20);
      arrList7.add(25);
      arrList7.add(30);
      arrList7.add(35);

      Bookshelf listBook7 = new Bookshelf(arrList7);
      System.out.println("Original Bookshelf object in BookshelfKeeper listBook7: " + listBook7.toString());
      BookshelfKeeper exKeeper7 = new BookshelfKeeper(listBook7);
      System.out.println("Put(12) -->");
      System.out.println("Number of Mutators: " + exKeeper7.putHeight(12));
      System.out.println("Expected: [5, 10, 12, 15, 20, 25, 30, 35]");
      System.out.println("Actual: " + exKeeper7.toString());
      System.out.println();

      // Test Case #8
      ArrayList<Integer> arrList8 = new ArrayList<Integer>();
      arrList8.add(5);
      arrList8.add(10);
      arrList8.add(15);
      arrList8.add(20);
      arrList8.add(25);
      arrList8.add(30);
      arrList8.add(35);

      Bookshelf listBook8 = new Bookshelf(arrList8);
      System.out.println("Original Bookshelf object in BookshelfKeeper listBook8: " + listBook8.toString());
      BookshelfKeeper exKeeper8 = new BookshelfKeeper(listBook8);
      System.out.println("Put(27) -->");
      System.out.println("Number of Mutators: " + exKeeper8.putHeight(27));
      System.out.println("Expected: [5, 10, 15, 20, 25, 27, 30, 35]");
      System.out.println("Actual: " + exKeeper8.toString());
      System.out.println();

      // Test Case #9
      ArrayList<Integer> arrList9 = new ArrayList<Integer>();
      arrList9.add(5);
      arrList9.add(10);
      arrList9.add(15);
      arrList9.add(20);
      arrList9.add(25);
      arrList9.add(30);

      Bookshelf listBook9 = new Bookshelf(arrList9);
      System.out.println("Original Bookshelf object in BookshelfKeeper listBook9: " + listBook9.toString());
      BookshelfKeeper exKeeper9 = new BookshelfKeeper(listBook9);
      System.out.println("Put(27) -->");
      System.out.println("Number of Mutators: " + exKeeper9.putHeight(27));
      System.out.println("Expected: [5, 10, 15, 20, 25, 27, 30]");
      System.out.println("Actual: " + exKeeper9.toString());
      System.out.println();

      // Test Case #10
      ArrayList<Integer> arrList10 = new ArrayList<Integer>();
      arrList10.add(5);
      arrList10.add(10);
      arrList10.add(15);
      arrList10.add(20);
      arrList10.add(25);
      arrList10.add(30);

      Bookshelf listBook10 = new Bookshelf(arrList10);
      System.out.println("Original Bookshelf object in BookshelfKeeper listBook10: " + listBook10.toString());
      BookshelfKeeper exKeeper10 = new BookshelfKeeper(listBook10);
      System.out.println("Put(7) -->");
      System.out.println("Number of Mutators: " + exKeeper10.putHeight(7));
      System.out.println("Expected: [5, 7, 10, 15, 20, 25, 30]");
      System.out.println("Actual: " + exKeeper10.toString());
      System.out.println();

   }

   private static void testToString() {

      // Testing String toString method
      System.out.println();
      System.out.println("Testing String toString method");
      System.out.println();

      ArrayList<Integer> testArray = new ArrayList<Integer>();
      testArray.add(5);
      testArray.add(10);
      testArray.add(15);
      testArray.add(20);
      testArray.add(25);
      testArray.add(30);
      Bookshelf testList = new Bookshelf(testArray);

      System.out.println("Original Bookshelf object in BookshelfKeeper listBook10: " + testList.toString());
      BookshelfKeeper testKeeper = new BookshelfKeeper(testList);
      System.out.println("putHeight(7)");
      System.out.println("Expected: [5, 7, 10, 15, 20, 25, 30] 3 3 -->");
      testKeeper.putHeight(7);
      System.out.println("Actual: " + testKeeper.toString());
      System.out.println();

      System.out.println("putHeight(35)");
      System.out.println("Expected: [5, 7, 10, 15, 20, 25, 30, 35] 1 4 -->");
      testKeeper.putHeight(35);
      System.out.println("Actual: " + testKeeper.toString());
      System.out.println();

      System.out.println("pickPos(4)");
      System.out.println("Expected: [5, 7, 10, 15, 25, 30, 35] 7 11 -->");
      testKeeper.pickPos(4);
      System.out.println("Actual: " + testKeeper.toString());
      System.out.println();

      System.out.println("pickPos(3)");
      System.out.println("Expected: [5, 7, 10, 25, 30, 35] 7 18 -->");
      testKeeper.pickPos(3);
      System.out.println("Actual: " + testKeeper.toString());
      System.out.println();

      System.out.println("Number of books on the contained bookshelf [exp: 6] is: " + testKeeper.getNumBooks());
      System.out.println();

      System.out.println("putHeight(27)");
      System.out.println("Expected: [5, 7, 10, 25, 27, 30, 35] 5 23 -->");
      testKeeper.putHeight(27);
      System.out.println("Actual: " + testKeeper.toString());
      System.out.println();

      System.out.println("putHeight(26)");
      System.out.println("Expected: [5, 7, 10, 25, 26, 27, 30, 35] 7 30 -->");
      testKeeper.putHeight(26);
      System.out.println("Actual: " + testKeeper.toString());
      System.out.println();

      System.out.println("Number of books on the contained bookshelf [exp: 8] is: " + testKeeper.getNumBooks());
   }

}
