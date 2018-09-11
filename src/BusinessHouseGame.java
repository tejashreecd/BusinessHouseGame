
import java.util.ArrayList;
import java.util.Scanner;

public class BusinessHouseGame {
    public static final int NUMBER_CELLS = 46;
    private static final int DICE_VALUES = 30;

    public static void main(String[] args) {
        Board board = new Board(NUMBER_CELLS);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cell type for " + NUMBER_CELLS + " positions:");
        Cell startingCell = new Cell(0);
        board.add(startingCell);
        for (int index = 1; index < NUMBER_CELLS; index++) {
            String value = scanner.next();
            if (value.equals("E")) {
                Cell cell = new Cell(index);
                board.add(cell);
            }
            if (value.equals("J")) {
                Jail jailCell = new Jail(index);
                board.add(jailCell);
            }
            if (value.equals("T")) {
                Treasure treasureCell = new Treasure(index);
                board.add(treasureCell);
            }
            if (value.equals("H")) {
                Hotel hotelCell = new Hotel(index);
                board.add(hotelCell);
            }
        }
        System.out.println("Enter number of players:");
        int numberOfPlayers = scanner.nextInt();
        ArrayList<Player> players = new ArrayList<>(numberOfPlayers);
        for (int index = 0; index < numberOfPlayers; index++) {
            players.add(new Player(board.getStartingCell()));
        }
        System.out.println("Enter dice input");
        int[] diceValues = new int[DICE_VALUES];
        for (int index = 0; index < DICE_VALUES; index++) {
            diceValues[index] = scanner.nextInt();
        }
        int playerIndex = 0;
        for (int index = 0; index < DICE_VALUES; index++) {
            board.move(players.get(playerIndex), diceValues[index]);
            playerIndex = (playerIndex + 1) % numberOfPlayers;
        }
        for (Player player : players) {
            System.out.println(player.balance());
        }

    }
}
