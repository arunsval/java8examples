interface MyInterface{
void printMe();
default void printHello(){
System.out.println("Hello!!!");
}
}
