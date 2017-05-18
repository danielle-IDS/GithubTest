package sandbox;

public class Gskjdhfa {
	
	private int[] a;
	
	public Gskjdhfa (int[] x)
	{
		a = x;
	}
	
	public void addOne()
	{
		for (int i = 0; i < 5; i++)
		{
			a[i]++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] eh = { 0, 0, 0, 0, 0 };
		Gskjdhfa ah = new Gskjdhfa(eh);
		ah.addOne();
		System.out.println(eh[0]);
		
		String str = "DSJFSJD";
		
		System.out.println(str.toLowerCase());
		
	

	}

}
