//1. extending final class
final class Data{
    int a=10;
}
class b extends Data{
    //returns error because its extending final class 
}
//2.
final class Data{
    int a=10;
void change(){
    a=20;//returns error
}
}
//3.
class Data{
    final void start(){
        System.out.println("start");
    }
}
class d extends Data{
    void start(){
        System.out.println("start");
    }
}
