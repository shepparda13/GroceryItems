import java.util.*;

public class GroceryItem
{
 private int productnum;    //product number of item
 private int quantity;      //quantity of item
 private double price;      //price of item
 private String tax;        //tax code of item
 private String description;  //description of item

//accesors

 public int getNumber()
 {
  return productnum;
 }
 public int getQuantity()
 {
  return quantity;
 }
 public double getPrice()
 {
  return price;
 }
 public String getTaxCode()
 {
  return tax;
 }
 public String getName()
 {
  return description;
 }
 public static int itemSearch(GroceryItem item[],int numItems,int productID) //returns location of item 
 {
   for(int i = 0;i<=numItems-1;i++)
   {
    if(productID == item[i].productnum) //test for match between product number and specified key
      return i;
   }
    return -1;  //if the product number is not found 
 }
 //prints information for each unique product number
 public static void printInventory(GroceryItem item[],int numItems)
 {
  int prodnums[] = new int[numItems]; //array holding product numbers
  int matches = 0;    //counts number of product numbers which matched
  boolean first = true; //keeps track of first time two product numbers match   

    for(int i = 0;i<=numItems-1;i++)  //fills prodnums array with each product number
     prodnums[i] = item[i].getNumber();
 
    for(int j = 0;j<=numItems-1;j++)  //goes through each item in inventory
    {
     matches = 0;
      for(int x = 0;x<=numItems-1;x++)  //goes back through inventory looking for matches
       if(item[j].getNumber() == prodnums[x])
          matches++;
         
        if(matches == 1) //if there is only one match(the item with itself) print info.
        {
         System.out.printf("%7s",item[j].getNumber());
         System.out.printf("%13s",item[j].getName());
         System.out.printf("%5s",item[j].getQuantity());
         System.out.printf("%5s",item[j].getPrice());
         System.out.printf("%3s\n",item[j].getTaxCode());
        }
       //if there are two or more matches(the item with itself and other items)print info.
       //and set first to false so the info for the other items won't be printed
       else if((matches >= 2)&&(first)) 
       {
        System.out.printf("%7s",item[j].getNumber());
        System.out.printf("%13s",item[j].getName());
        System.out.printf("%5s",item[j].getQuantity());
        System.out.printf("%5s",item[j].getPrice());
        System.out.printf("%3s\n",item[j].getTaxCode());
        first = false;
       }
    }
      
 }
 public void setQuantity(int value) //mutator
 {
   quantity = value;
 }
 public void readItem(Scanner inFile) //reads in a single GroceryItem
 {
  productnum = inFile.nextInt();
  description = inFile.next();
  quantity = inFile.nextInt();
  price = inFile.nextDouble();
  tax = inFile.next(); 
 }

}
