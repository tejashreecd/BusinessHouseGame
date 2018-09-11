import java.util.ArrayList;

public class Board {
    private ArrayList<Cell> cells;

    Board(int numberOfCells) {
        cells = new ArrayList<>(numberOfCells);
    }

    public void add(Cell cell) {
        cells.add(cell);
    }

    public Cell getStartingCell() {
        return cells.get(0);
    }

    public void move(Player player, int diceValue) {
        int position = (player.getPosition() + diceValue) % BusinessHouseGame.NUMBER_CELLS;
        Cell nextCell = cells.get(position);
        player.changePosition(nextCell);
        if (nextCell.getClass() == Jail.class) {
            player.transact(Jail.JAIL_MONEY);
        }
        if (nextCell.getClass() == Treasure.class) {
            player.transact(Treasure.TREASURE_MONEY);
        }
        if(nextCell.getClass() == Hotel.class){
            Hotel hotelCell = (Hotel)nextCell;
            if(hotelCell.ifOwnerPresent()){
                player.transact(Hotel.HOTEL_RENT);
                hotelCell.transferRent();
            }
            else{
                player.transact(Hotel.HOTEL_WORTH);
                hotelCell.changeOwner(player);
            }
        }
    }
}
