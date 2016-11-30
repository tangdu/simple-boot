
public class MainShi {
	public static void main(String[] args) {
		String a="2222";
		String b="2222";
		Integer c=22222;
		Long d=22222l;
		System.out.println(d.equals(c));
		System.out.println(c.equals(222));
		System.out.println(a==b);
		System.out.println(a.equals(b));
		Integer a1=300;
		Integer b1=3;
		System.out.println(a1==b1);
		
		System.out.println(Thread.currentThread().getContextClassLoader());
	}
}
