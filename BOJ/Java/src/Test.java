class Parent {
    String x = "parent";
    void method(){

        System.out.println("this is a method from parent");

    }
}

class Child extends Parent{
    String x = "child";

    void method() {
        String x = "method";
        System.out.println("x : " + x);
        System.out.println("this.x : " + this.x);
        System.out.println("super.x : " + super.x);
    }
}

public class Test {
    public static void main(String[] args) {
        Child child = new Child();
        child.method();

        Parent p = new Child();
//        System.out.println((Child) p.x);
        System.out.println(((Child) p).x);
        p.method();

//        Child c = new Parent();

    }
}

/*
a) 발생함
b) 에러
c) method child child parent


 */
