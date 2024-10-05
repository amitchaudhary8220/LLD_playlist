// S - single responsibility principle
// O - Open/ Closed principle
// L - Liskov substitution principle
// I - Interface segmented principle
// D - Dependency inversion principle


// Advantage of these principles
  // Avoid Duplicate code
  // Easy to maintain
  // Easy to understand
  // flexible software
 // Reduce complexity



// Single responsibility => A class should have only 1 reason to change , it means that a class
// should have only one responsibility.

public class SolidPrinciple {
    public  static  void main(String[] args){

    }
}

class Marker{
    String name;
    String color;
    int year;
    int price;

    public  Marker(String name,String color, int year, int price){
        this.name = name;
        this.color= color;
        this.year = year;
        this.price = price;
    }
}


class Invoice {
    //since Invoice class has object of Marker class, it is has-a relation
    private  Marker marker;
    private  int quantity;
    public  Invoice(Marker marker, int quantity ){
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal(){
        int price = ((this.marker.price) * this.quantity);
        return price;
    }

    public void printInvoice(){
        // print the invoice
    }
    public  void saveToDB(){
        // Save data into DB
    }

    // In the above case Invoice class is not following the single responsibility principle, because suppose if we introduce
// GST so calculation logic will change

// other is , if we want save invoice into file , in that case also , this class will change
// If we want to change the invoice logic , in that case printInvoice will also change

// so over all Invoice all has more than 1 reason to change , now we will try to break into small class
// with single responsibility
}


class Invoice {
    //since Invoice class has object of Marker class, it is has-a relation
    private  Marker marker;
    private  int quantity;
    public  Invoice(Marker marker, int quantity ){
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal(){
        int price = ((this.marker.price) * this.quantity);
        return price;
    }

}


//class InvoiceDao {
//    Invoice invoice;
//
//    public  InvoiceDao(Invoice invoice){
//        this.invoice = invoice;
//    }
//
//    public void saveToDB() {
//        // save into the DB
//    }
//}

class InvoicePrinter{
    private  Invoice invoice;

    public  InvoicePrinter(Invoice invoice){
    this.invoice = invoice;
    }

    public  void print(){
        // print the invoice
    }
}

// Now each class has a single responsibility,




// -----> Open/Closed principle

// Open for extension but closed for modification

// now suppose we want to add few more thing to class InvoiceDao


//class InvoiceDao {
//    Invoice invoice;
//
//    public  InvoiceDao(Invoice invoice){
//        this.invoice = invoice;
//    }
//
//    public void saveToDB() {
//        // save into the DB
//    }
//
//    public void saveToFile(String  filename){
//        // save the invoice in the file with given name
//    }
//
//    // since the InvoiceDao class was already tested an it was running on production , adding few more
//    // feature can leads to bugs ,and it is not following the open/closed principle, which suggests that
//    // class should be open for extension but closed for modification , and here we are modifying the class
//}



// better way could be

interface  InvoiceDao{
    public  void save(Invoice invoice);
}

class  DatabaseInvoiceDao implements  InvoiceDao{
    @Override
    public void save(Invoice invoice) {
        // save to DB
    }
}

class  FileInvoiceDao implements  InvoiceDao{
    @Override
    public void save(Invoice invoice) {
        // save to file
    }
}




// 3 Liskov substitution principle

// If class B is subtype of class A , then we should be able to replace the  object of A with B
// without breaking the behaviour of the program

// subclass should extend the capabilities of parent class , not narrow it down
interface  Bike{
    void turnOnEngine();
    void accelerate();
}

class  MotorCycle implements  Bike{
    boolean isEngineOn;
    int speed;
    @Override
    public  void turnOnEngine(){
        isEngineOn = true;
    }

    @Override
    public void accelerate() {
        speed+=10;
    }
}

class  Bicycle implements  Bike{
    //here we are narrowing down the capabilites of Bike , as Bicycle don't have engine, so we have to avoid this.
    @Override
    public void turnOnEngine() {
        throw new AssertionError("There is no engine");
    }

    @Override
    public void accelerate() {
    // do something
    }
}




// 4 --> Interface segmented principle

// Interfaces should be such, that client should not implement unnecessary functions they don't
// need

// break the Interface into small interfaces ,such that Client don't need to implement the
// functions they don't need

interface  RestaurantEmployee{
    void washDishes();
    void serveCustomers();
    void cookFood();
}
//
//class Waiter implements  RestaurantEmployee{
//
//    @Override
//    public void serveCustomers() {
//        // yes and here is implementation
//        System.out.println("Serving the customers");
//    }
//
//    @Override
//    public void washDishes() {
//    // not my job , waiter will not wash the dishes
//    }
//
//    @Override
//    public void cookFood() {
//    // not my job , waiter will not cook the food
//    }
//}

interface WaiterInterface{
    void serverCustomers();
    void  takeOrder();
}

interface  ChefInterface{
    void cookFood();
    void decideMenu();
}

class Waiter implements  WaiterInterface{
    @Override
    public void serverCustomers() {
        System.out.println("serving the customers");
    }

    @Override
    public void takeOrder() {
        System.out.println("taking the orders");

    }
}


// 5 ------> Dependency Inversion principle

// it states that class should depend on interfaces rather than concrete classes

interface  Keyboard{

}

class  WiredKeyboard implements  Keyboard{

}

class  WirelessKeyboard implements  Keyboard{

}

interface  Mouse{

}

class  WiredMouse implements  Mouse{

}

class  WirelessMouse implements  Mouse{

}

//class  MacBook{
//    private  final WiredKeyboard keyboard;
//    private  final  WiredMouse mouse;
//
//    public  MacBook(){
//        keyboard = new WiredKeyboard();
//        mouse = new WiredMouse();
//    }
//
//    // now in this case , since we have assign the object of WiredKeyboard and WiredMosue , in
//    // future  if want to assign keyboard = WirelessKeyboard so we won't be able to do that ,
//    // so to avoid this , class should depend on interface
//}

class  MacBook{
    private  final  Keyboard keyboard;
    private  final Mouse mouse;


    // now if we will pass the obect of wireless mouse or keyboard , then keyboard or mouse will be
    // wireless, or if we will send the wired , then it will be wired
    public  MacBook(Keyboard keyboard, Mouse mouse){
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}