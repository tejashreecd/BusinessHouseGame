public class Hotel extends Cell {

    public static final int HOTEL_WORTH = -200;
    public static final int HOTEL_RENT = -50;

    private Player owner;

    Hotel(int index) {
        super(index);
    }

    public boolean ifOwnerPresent() {
        return owner != null;
    }

    public void changeOwner(Player player) {
        owner = player;
    }

    public void transferRent() {
        owner.transact(Math.abs(HOTEL_RENT));
    }
   // public int returnR
}
