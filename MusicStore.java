package practicals;

import java.util.*;

@SuppressWarnings("unused")
public class MusicStore {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int a,sold = 0;
		String A,Address;
		List<String> stock = new ArrayList<String>();
		List<Integer> quantity = new ArrayList<Integer>();
		stock.add("2Scratch - Superlife (ft. Lox Chatterbox)");
		stock.add("G-Eazy - Far Alone ft. Jay Ant (Alperen Karaman Remix)");
		stock.add("Bazanji - Fed Up");
		stock.add("New World Sound & Thomas Newson - Flute (Original Mix)");
		stock.add("Miguel Atiaz - Mr Colors (Original Mix)");
		for(int i=0;i<5;i++)
			quantity.add(i+1);
		while(true) {
			System.out.println("1. Add New Item\n"
					+ "2. Create Order\n"
					+ "3. Sold Items\n"
					+ "4. Item in Stock\n"
					+ "5. All Items\n"
					+ "6. Remove Item\n"
					+ "7. Exit\n");
			System.out.println("Enter your choice : ");
			int c = in.nextInt();
			in.nextLine();
			while(checking(c)) {
				System.out.println("1. Add New Item\n"
						+ "2. Create Order\n"
						+ "3. Sold Items\n"
						+ "4. Item in Stock\n"
						+ "5. All Items\n"
						+ "6. Remove Item\n"
						+ "7. Exit\n");
				System.out.println("Enter a valid choice : ");
				c = in.nextInt();
				in.nextLine();
			}
			if(c==1) {
				System.out.println("do you want to increase the stock of existing track/s?(y/n)");
				A = in.nextLine();
				if(A.equals("y") || A.equals("Y")) {
					System.out.println("which track do you want to add?");
					A = in.nextLine();
					int i = stock.indexOf(A);
					System.out.println("How many track/s you want to add?");
					a = in.nextInt();
					int l = quantity.get(i) + a;
					quantity.remove(i);
					quantity.add(i, l);
				}
				if(A.equals("n") || A.equals("N")) {
					System.out.println("Enter the name and quantity of track you want to add : ");
					A = in.nextLine();
					a = in.nextInt();
					stock.add(A);
					quantity.add(a);
				}
				System.out.println("List updated...");
			}
			if(c==2) {
				System.out.println("Enter your Address : ");
				Address = in.nextLine();
				System.out.println("Enter the track : ");
				A = in.nextLine();
				System.out.println("Enter the quantity : ");
				a = in.nextInt();
				sold += a;
				int l = stock.indexOf(A);
				int k = quantity.get(l) - a;
				quantity.remove(l);
				quantity.add(l, k);
			}
			if(c==3) {
				System.out.println("Total items sold : "+sold);
			}
			if(c==4) {
				//a = in.nextInt();
				//A = in.nextLine();
				/*for(int l=0;l<stock.size();l++) {
					if(quantity.elementAt(l).equals(0)) {
						continue;
					}
					else
						System.out.println(stock.get(l)+" : "+quantity.get(l));
				}*/
				for(int j=0;j<stock.size();j++) {
					System.out.println(stock.get(j)+" : "+quantity.get(j));
				}
			}
			if(c==5) {
				for(int j=0;j<stock.size();j++) {
					System.out.println(stock.get(j)+" : "+quantity.get(j));
				}
			}
			if(c==6) {
				System.out.println("Enter the track you want to remove : ");
				A = in.nextLine();
				int i = stock.indexOf(A);
				stock.remove(i);
				quantity.remove(i);
			}
			if(c==7) {
				in.close();
				System.exit(0);
			}
		}
	}
	public static boolean checking(int c) {		
		try {
			if(c<1 || c>7)
				throw new Exception();
		}
		catch(Exception e) {
			System.out.println("Invalid Choice");
			return true;
		}
		return false;
	}
}
