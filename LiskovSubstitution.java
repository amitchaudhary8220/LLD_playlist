public class LiskovSubstitution {
 public  static  void  main(String[] args){
     Sparrow sparrow = new Sparrow();
     sparrow.fly();
 }
}

class Bird{
  public  void  fly(){
      System.out.println("This bird can fly");
    }
}

class Sparrow extends  Bird{
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");

    }
}

//class Penguin extends  Bird{
//    @Override
//    public void fly() throws Exception {
//        throw new Exception("Penguin can't fly");
//    }
//}
