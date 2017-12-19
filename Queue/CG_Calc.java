import java.util.*;

public class CG_Calc {
    private class Purchase {
        private int shares;
        private int price;

        Purchase(int shares, int price) {
            this.shares = shares;
            this.price = price;
        }
    }

    public static Queue<Purchase> q;

    public static int totalShares = 0;

    public CG_Calc() {
        q = new LLQueue<Purchase>();
    }

    public void processPurchase(int shares, int price) {
        Purchase p = new Purchase(shares, price);
        totalShares += shares;
        q.insert(p);
    }

    public int processSale(int sharesAvailable, int price) {
        if (sharesAvailable > totalShares)
            throw new IllegalArgumentException("\nYou don't have " + sharesAvailable + " shares to sell.");
        totalShares -= sharesAvailable;

        int totalCapitalGains = 0;

        while (sharesAvailable > 0) {
            Purchase ownedShares = q.peek();

            if (ownedShares.shares <= sharesAvailable) { 
                sharesAvailable -= ownedShares.shares;
                totalCapitalGains += ownedShares.shares * (price - ownedShares.price);
                ownedShares.shares = 0;
                q.remove();
            }
            else {
                totalCapitalGains += sharesAvailable * (price - ownedShares.price);
                ownedShares.shares -= sharesAvailable;
                sharesAvailable = 0;
            }
        }
        return totalCapitalGains;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CG_Calc calc = new CG_Calc();
        int totalProfit = 0;
        int gain = 0;

        while (true) {

            System.out.print("1: Purchase \n2: Sell \n3: Quit \nPlease enter a numerical option: ");
            int choice = scan.nextInt();
            if (choice == 3)
                break;
            if(choice != 1 && choice != 2) {
                System.out.println("\nPlease enter 1, 2 or 3: ");
                continue;
            }

            // Get the number of shares and the price.
            System.out.print("\nNumber of Shares: ");
            int shares = scan.nextInt();
            System.out.print("Price Per Share: ");
            int price = scan.nextInt();
            if (shares <= 0 || price <= 0) {
                System.err.println("Please enter positive numbers.");
                continue;
            }

            if (choice == 1)
                calc.processPurchase(shares, price);
            else {
                try {
                    gain = calc.processSale(shares, price);
                    System.out.println("\nCapital Gain on Sale: $" + gain +"\n");
                    totalProfit += gain;
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        System.out.println("\nTotal Capital Gain: $" + totalProfit);
    }
}
