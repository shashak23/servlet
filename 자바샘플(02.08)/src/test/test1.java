package test;

class MyClass{
	// 1. 생성자
	public MyClass() {
		
	}
	// 2. 팰드(private)
	private int cost;
	
	// 3. 메소드
		
	// 4. setter & getter
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
public class test1 {
	public static void main(String[] args) {
		MyClass obj = new MyClass();
		// 객체의 method를 이용해 객체의 field(데이터)를 제어해요
		obj.setCost(100);
		// 메소드나 객체를 이용해서 자바프로그램을 핸들링 해왔어요 -> stateful 스테이트풀
		// 스테이트 리스도 있어요~ 
		// stateful은 객체가 가지는 정보를 인스턴스 필드에 직접 저장하는 방식, 객체에 정보가 있다
		// stateless는 무상태, 상태가 없다 = 인스턴스가 데이터를 안갖고 있다, 필드를 사용하지 않는다
		// 그러면 데이터는 어떻게 유지해요? 서블렛이나 스테이트?를 사용하면 리스가 되는 거래요
		// 이게 무슨 말이지...
		// 우리가 작성하는 서블릿이라는 건 스테이트 리스 방식이에요 이전에 했던 거는 전부 스테이트 풀이고요
		
	}

}
