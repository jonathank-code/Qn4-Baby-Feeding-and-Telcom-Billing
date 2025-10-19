
package qn4.telecombilling;

import java.util.Scanner;

public class TelecomBilling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Input
        System.out.print("Enter airtime loaded (UGX): ");
        double loadedAmount = input.nextDouble();
        
        System.out.print("Enter call duration (in minutes): ");
        double callDurationMinutes = input.nextDouble();
        
        // Constants
        double chargeRate = 0.10;          // 10% service charge
        double callRatePerSecond = 200;    // UGX per second
        
        // Calculations
        double chargeAmount = loadedAmount * chargeRate;
        double balanceAfterCharge = loadedAmount - chargeAmount;
        
        double callDurationSeconds = callDurationMinutes * 60;
        double callCost = callDurationSeconds * callRatePerSecond;
        
        double finalBalance = balanceAfterCharge - callCost;
        
        // Output
        System.out.println("\n--- TELECOM BILLING SUMMARY ---");
        System.out.println("Initial Airtime Loaded: UGX " + loadedAmount);
        System.out.println("Service Charge (10%): UGX " + chargeAmount);
        System.out.println("Balance After Charge: UGX " + balanceAfterCharge);
        System.out.println("Call Duration: " + callDurationSeconds + " seconds");
        System.out.println("Call Cost: UGX " + callCost);
        System.out.println("Final Balance: UGX " + finalBalance);
        
        input.close();
    }
}


   