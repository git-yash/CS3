import java.awt.*;

public class Virus {
    private final Person[][] peopleArray;

    public Picture picture;

    public Virus(int width, int height) {
        this.peopleArray = new Person[width][height];
        this.picture = new Picture(width, height);
        int firstPersonX = (int) (Math.random() * width);
        int firstPersonY = (int) (Math.random() * height);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == firstPersonX && j == firstPersonY) {
                    peopleArray[i][j] = new Person(true);
                } else {
                    peopleArray[i][j] = new Person(false);
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < peopleArray.length; i++) {
            for (int j = 0; j < peopleArray[0].length; j++) {
                if (peopleArray[i][j].isImmune) {
                    picture.set(i, j, Color.green);
                } else if (peopleArray[i][j].isDead) {
                    picture.set(i, j, Color.red);
                } else {
                    picture.set(i, j, Color.white);
                }
            }
        }

        for (int i = 0; i < peopleArray.length; i++) {
            for (int j = 0; j < peopleArray[0].length; j++) {
                if (peopleArray[i][j].isInfected) {
                    spread(i, j);
                }
            }
        }

        picture.show();
        display();
    }

    private void spread(int i, int j) {
        int[] xMoves = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] yMoves = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < xMoves.length; k++) {
            boolean isValid = (i + xMoves[k] >= 0 && i + xMoves[k] < peopleArray.length) && (j + yMoves[k] >= 0 && j + yMoves[k] < peopleArray.length && peopleArray[i][j].isInfected);

            if (isValid) {
                Person person = peopleArray[i + xMoves[k]][j + yMoves[k]];
                if (!person.isInfected && !person.isImmune) {
                    double chanceOfSpreading = Math.random();
                    if (person.getChanceOfGetting() >= chanceOfSpreading) {
                        person.isInfected = true;
                        if (Math.random() <= 0.5) {
                            person.isDead = true;
                        } else {
                            person.isImmune = true;
                            person.isInfected = false;
                        }
                    }
                }
            }
        }
    }
}