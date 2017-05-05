import java.io.*;
class defaultInterface{
public static void main(String[] args){
MyInterface intf = new MyInterface(){
@Override
public void printMe(){
System.out.println("I'm in..");
	}
	};
intf.printMe();
	}
	}
