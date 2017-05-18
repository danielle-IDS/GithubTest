package sandbox;

public class NotesFeb1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menuChoice = 0;
		
		int n = 17;
		int m = 18;
		
		System.out.println(n / 10 + n % 10);
		System.out.println(n % 2 + m % 2);
		System.out.println((m + n) / 2);
		System.out.println((m + n) / 2.0);
		System.out.println((int) 5.0 * (m+ n));
		System.out.println((int) Math.round(5.0 * (m+ n)));
		
		
		/*
		switch(menuChoice)
		{
			case 1:
				playGame();
				break;
			case 2:
				slow();
				break;
			case 3:
				quit();
				break;		
		}
		*/
		// switch is the same as a bunch of if else statements
		// the break is used to to end the switch and continue
			// on with code after the switch
		// if you don't put the break, it will "fall through"
			// and simply go to the next case.
		
		
		// want to compare values not identity - want to test for EQUALITY
		// if b.equal(a) = this returns a boolean
		
		// ebsilon - in chapter 5 about comparing double

	}

}
