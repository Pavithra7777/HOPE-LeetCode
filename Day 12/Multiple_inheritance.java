import java.util.*;
interface Mom{
  void HS();
}
interface Dad{
  void Business();
}
class child implements Mom,Dad{
  public void HS(){
    System.out.println("Ill do Higher studies");
  }
  public void Business(){
    System.out.println("Ill do Business");
  }}
public class Main
{
	public static void main(String[] args) {
		child c=new child();
		c.HS();
		c.Business();
	}
}
