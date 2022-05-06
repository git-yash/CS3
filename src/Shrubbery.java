public class Shrubbery implements Comparable {
    private final String name;
    private final int nicenessRating;
    private final double price;
    private final double volume;
    public static String sortBy;

    public Shrubbery(String name, int nicenessRating, double price, double volume) {
        this.name = name;
        this.nicenessRating = nicenessRating;
        this.price = price;
        this.volume = volume;
    }

    public int getNicenessRating() {
        return nicenessRating;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public int compareTo(Object o) {
        Shrubbery other = (Shrubbery) o;

        if (sortBy.equals("SIZE")) {
            if (getVolume() > other.getVolume()) {
                return -1;
            } else if (getVolume() < other.getVolume()) {
                return 1;
            }
        } else if (sortBy.equals("PRICE")) {
            if (getPrice() > other.getPrice()) {
                return 1;
            } else if (getPrice() < other.getPrice()) {
                return -1;
            }
        } else {
            if (getNicenessRating() > other.getNicenessRating()) {
                return -1;
            } else if (getNicenessRating() < other.getNicenessRating()) {
                return 1;
            }
        }

        return 0;
    }
}