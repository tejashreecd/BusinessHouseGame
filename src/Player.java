public class Player {
    private static final int STARTING_MONEY = 1000;

    private int money;
    private Cell positionCell;

    Player(Cell startingCell) {
        this.money = STARTING_MONEY;
        positionCell = startingCell;
    }

    public int getPosition() {
        return positionCell.cellIndex();
    }

    public void changePosition(Cell nextCell) {
        positionCell = nextCell;
    }

    public void transact(int transactionMoney) {
        money += transactionMoney;
    }

    public int balance() {
        return money;
    }

}
