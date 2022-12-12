package bad.robot.refactoring.chapter1;
public abstract class Price {
    abstract int getPriceCode();

    public double getCharge(int daysRented) {
        double thisAmount = 0;

        switch (getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case Movie.CHILDREN:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }

        return thisAmount;
    }
}
