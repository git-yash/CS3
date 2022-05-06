public class Person {
    public boolean isImmune;
    public boolean isInfected;
    public boolean isDead;
    private final int age;

    public Person(boolean isInfected) {
        isDead = false;
        isImmune = false;
        this.isInfected = isInfected;
        this.age = (int) (Math.random() * 100);
    }

    public double getChanceOfGetting() {
        double chanceOfGetting;

        if (age <= 4 || age >= 80) {
            chanceOfGetting = 0.8;
        } else {
            chanceOfGetting = 0.5;
        }

        return chanceOfGetting;
    }
}
