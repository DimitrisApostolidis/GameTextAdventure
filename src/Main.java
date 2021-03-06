import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main (String [] args) {
        //System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Game variables
        String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assassin" };
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        //Player variables
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotioHealAmount= 30;
        int healthPotionDropChance = 50; //Percentage
        int choice=1;

        boolean running = true;

        System.out.println("Welcome to the Dangeon!\n");
        System.out.println("Here is your first enemy\n");
        System.out.println("--------------------------");

        GAME:
        while(running) {
            System.out.println("-------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " appeared! #\n");
            //    # Skeleton has appeared !#

            while(enemyHealth > 0){
                System.out.println("\tYour HP: " + health);
                System.out.println("\t " + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Health Potion");
                System.out.println("\t3. Run!");
                System.out.println("\t4. Choose your path");
                System.out.println("\t5. Pick a Torch");

                String input = in.nextLine();
                if(input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike " + enemy + "for " + damageDealt + " damage.");
                    System.out.println("\t> You recieve " + damageTaken + " in retaliation!");

                    if(health < 1) {
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        break;
                    }
                }
                else if(input.equals("2")) {
                    if(numHealthPotions > 0) {
                        health += healthPotioHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health potion, healing yourself for " + healthPotioHealAmount + " . "
                        + "\n\t> You now have " + health + "HP."
                        + "\n\t> You have " + numHealthPotions + " health potions left.\n");
                    }
                    else {
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get a potion!");
                    }
                }
                else if(input.equals("3")) {
                        System.out.println("\tYou run away from the" + enemy + "!");
                }
                else if (input.equals("4")){
                    while (choice!=0) {
                        String output = in.nextLine();
                        System.out.printf("Choices:\n");
                        System.out.printf("1. To move north press 1\n");
                        System.out.printf("2. To move south press 2\n");
                        System.out.printf("3. To move east press 3\n");
                        System.out.printf("4. To move west press 4\n");
                       if (output.equals("1")){
                           System.out.println("You are on the North side");
                       }
                        else if (output.equals("2")){
                            System.out.println("You are on the South side");
                        }
                        else if (output.equals("3")){
                            System.out.println("You are on the East side");
                        }
                        else if (output.equals("4")){
                            System.out.println("You are on the West side");
                        }
                    }
                    }
                else if (input.equals("5")){
                    String weapon;
                    weapon = "torch";
                    System.out.println("You pick up a " + weapon);

                }
                else {
                      System.out.println("\tInvalid command!");
                }
            }

            if (health < 1) {
                System.out.println("You limp out of the dungeon, weak from battle.");
                break;
            }

            System.out.println("-------------------------------------");
            System.out.println(" # " + enemy + "was defeated! # ");
            System.out.println(" # You have " + health + "HP left. ");
            if(rand.nextInt(100) > healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion! # ");
                System.out.println(" # You now have " + numHealthPotions + " health potion(s). #");
            }
            System.out.println("---------------------------------------------");
            System.out.println("What would you like to do?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            String input = in.nextLine();

            while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command!");
                input = in.nextLine();
            }
            if(input.equals("1")) {
                System.out.println("You continue on your adventure!");
            }
            else if(input.equals("2")) {
                System.out.println("You exit the dungeon, successful from your adventures!");
                break;
            }
        }

        System.out.println("#############");
        System.out.println("# THANKS FOR PLAYING THE DEMO! #");
        System.out.println("");

    }
}
