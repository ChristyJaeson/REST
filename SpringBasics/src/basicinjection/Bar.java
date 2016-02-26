package basicinjection;
/**
 * 
 * @author Apurav
 *
 */
public class Bar {
	private String name;
	private int age;
	private Foo foo;
	public Bar() {}
	public Bar(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public void setFoo(Foo foo) {
		this.foo = foo;
	}
	
	public void processFooName(){
		System.out.println("Name in Injected Foo is: "+foo.getName());
	}
	
	@Override
	public String toString() {
		return "Bar has name = "+this.name+" and age = "+this.age;
	}
	
}
