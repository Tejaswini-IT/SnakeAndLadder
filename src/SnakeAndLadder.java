
import java.util.Random;

    public class SnakeAndLadder {
        private static final int WINNING_POSITION = 100;
        private static final int START_POSITION = 0;
        private static final Random random = new Random();

        public static int rollDice() {
            return random.nextInt(6) + 1; // Rolling a fair six-sided die
        }

        public static int checkOption() {
            return random.nextInt(3); // 0: No Play, 1: Ladder, 2: Snake
        }

        public static int playSinglePlayerGame() {
            int playerPosition = START_POSITION;
            int diceRolls = 0;

            while (playerPosition < WINNING_POSITION) {
                int diceValue = rollDice();
                int option = checkOption();

                diceRolls++;
                switch (option) {
                    case 0:
                        // No play, stay at the same position
                        break;
                    case 1:
                        // Ladder, move forward by dice value
                        playerPosition += diceValue;
                        break;
                    case 2:
                        // Snake, move backward by dice value
                        playerPosition -= diceValue;
                        break;
                }

                // Ensure player position doesn't go below 0
                playerPosition = Math.max(playerPosition, START_POSITION);

                // Ensure player position doesn't exceed winning position
                if (playerPosition > WINNING_POSITION)
                    playerPosition -= diceValue;
            }

            return diceRolls;
        }

        public static void main(String[] args) {
            int numPlayers = 4; // Hardcoded number of players

            int[] diceRolls = new int[numPlayers];

            for (int i = 0; i < numPlayers; i++) {
                diceRolls[i] = playSinglePlayerGame();
                System.out.println("Player " + (i+1) + " wins after " + diceRolls[i] + " dice rolls.");
            }

            int minRolls = Integer.MAX_VALUE;
            int winner = -1;
            for (int i = 0; i < numPlayers; i++) {
                if (diceRolls[i] < minRolls) {
                    minRolls = diceRolls[i];
                    winner = i + 1;
                }
            }

            System.out.println("Player " + winner + " wins with the minimum number of dice rolls: " + minRolls);
        }
    }


