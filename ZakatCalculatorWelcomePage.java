package zakatcalculator;
import java.util.*;

public class ZakatCalculatorWelcomePage {
	public static void main(String[] args) {
        displayWelcomeMessage();
        clearPage();
        System.out.println("");
        calculateZakat();
        clearPage();
        System.out.println("");
        
        boolean continueCalculation = askToContinue();
        if (continueCalculation) {
            System.out.println("Continuing Zakat calculation...");
            System.out.println("");
            calculateZakat();
            
        } else {
            System.out.println("*******Thank you for using Zakat Calculator. Goodbye!********");
            System.out.println("");
            
        }
    }

    private static void displayWelcomeMessage() {
        System.out.println("					---Welcome to Zakat Calculator---");
        System.out.println("			---Calculate your Zakat easily with our Zakat calculator---");
        System.out.println("					Press any key to get started.......	");
        
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        
        clearPage();
    }

    private static void clearPage() {
        // Clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }
    
    private static void calculateZakat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("		Do you have ");
        System.out.println("		1. Money.");
        System.out.println("		2. Gold.");
        System.out.println("		3. Silver");
        System.out.println("		4. ALL..");
        System.out.println("Enter 1, 2, 3, or 4:");
       
        int assetValue = scanner.nextInt();
        double totalZakat = 0;
  
        
        switch (assetValue) {
            case 1:
                totalZakat += calculateMoneyZakat()*0.025;
                break;
            case 2:
                totalZakat += calculateGoldZakat()* 0.025;
                break;
            case 3:
                totalZakat += calculateSilverZakat()* 0.025;
                break;
            case 4:
                totalZakat += calculateMoneyZakat() + calculateGoldZakat() + calculateSilverZakat() * 0.025;
                break;
            default:
                System.out.println("Invalid asset value entered. Please try again........");
                System.out.println("");
                return;
        }
    	
        System.out.println("		Your total ZakatAmount is: " + totalZakat);
        System.out.println("");
    }

    private static double calculateMoneyZakat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of money you have:");
        double money = scanner.nextDouble();
		return money
				;
    }

    private static double calculateGoldZakat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Enter the weight of gold you have (in grams):");
        
        double goldWeight = scanner.nextDouble();
        return goldWeight * getGoldPricePerGram();
    }

    private static double getGoldPricePerGram() {
        return 19119; // RS 19,119 per gram at 22 March 2024 in Pakistan
    }

    private static double calculateSilverZakat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Enter the weight of silver you have (in grams):");
        
        double silverWeight = scanner.nextDouble();
        return silverWeight * getSilverPricePerGram();
    }

    private static double getSilverPricePerGram() {
        
        return 220.59; // RS 220.59 per gram at 22 March 2024 in Pakistan
    }
    
    private static boolean askToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue Zakat calculation? (yes/no)");
        String response = scanner.nextLine().toLowerCase();
        return response.equals("yes");
    }
}

