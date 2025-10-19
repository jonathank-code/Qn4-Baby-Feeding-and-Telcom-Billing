package qn3.babyfeedingschedule;

 import java.util.Scanner;

public class BabyFeedingSchedule {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Constants
        final double PORRIDGE_PER_FEEDING = 0.5; // half a cup in liters
        final double MILK_PER_FEEDING = 1.0; // full cup in liters
        final int PORRIDGE_INTERVAL = 45; // minutes
        final int MILK_INTERVAL = 30; // minutes
        final double TOTAL_PORRIDGE = 2.0; // liters
        final double TOTAL_MILK = 2.0; // liters
        
        // Calculate number of feedings
        int porridgeFeedings = (int)(TOTAL_PORRIDGE / PORRIDGE_PER_FEEDING);
        int milkFeedings = (int)(TOTAL_MILK / MILK_PER_FEEDING);
        
        // Prompt for initial feeding time
        System.out.println("Enter the initial feeding time (HH:MM, 24-hour format): ");
        String initialTime = scanner.nextLine();
        
        // Parse initial time
        String[] timeParts = initialTime.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        
        int currentMinutes = hours * 60 + minutes;
        int totalMinutes = 0;
        
        System.out.println("\nFeeding Schedule:");
        
        // Alternate between porridge and milk, prioritizing porridge if both are available
        while (porridgeFeedings > 0 || milkFeedings > 0) {
            if (porridgeFeedings > 0) {
                // Porridge feeding
                System.out.printf("At %02d:%02d - Feed half cup of Aunt Porridge\n", 
                    currentMinutes / 60, currentMinutes % 60);
                porridgeFeedings--;
                
                // Update time
                currentMinutes += PORRIDGE_INTERVAL;
                totalMinutes = currentMinutes - (hours * 60 + minutes);
                
                // If milk is available and next porridge feeding isn't due yet
                while (milkFeedings > 0 && (porridgeFeedings == 0 || 
                    (currentMinutes + MILK_INTERVAL) <= (currentMinutes + PORRIDGE_INTERVAL))) {
                    System.out.printf("At %02d:%02d - Feed full cup of Lato Milk\n", 
                        currentMinutes / 60, currentMinutes % 60);
                    milkFeedings--;
                    currentMinutes += MILK_INTERVAL;
                    totalMinutes = currentMinutes - (hours * 60 + minutes);
                }
            } else if (milkFeedings > 0) {
                // Milk feeding when no porridge left
                System.out.printf("At %02d:%02d - Feed full cup of Lato Milk\n", 
                    currentMinutes / 60, currentMinutes % 60);
                milkFeedings--;
                currentMinutes += MILK_INTERVAL;
                totalMinutes = currentMinutes - (hours * 60 + minutes);
            }
        }
        
        // Calculate and display total time
        int totalHours = totalMinutes / 60;
        int remainingMinutes = totalMinutes % 60;
        System.out.printf("\nTotal time to finish all feedings: %d hours and %d minutes\n", 
            totalHours, remainingMinutes);
        
        scanner.close();
    }
}

        
    

