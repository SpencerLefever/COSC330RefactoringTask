package bad.robot.refactoring.chapter1;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    //private int priceCode;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    private void setPriceCode(int priceCode) {
        switch (priceCode) {
            case CHILDREN:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case REGULAR:
                price = new RegularPrice();
                break;
            default:
                throw new IllegalArgumentException("invalid price code");
        }
    }

    private int getPriceCode() {
        return price.getPriceCode();
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
            // add bonus for a two day new release rental
            if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
                return 2;

        return 1;
    }

}
