import java.awt.*;
import java.util.ArrayList;

public class Segregation {
    private final Agent[][] agentArray;
    private final double percentage;

    public Segregation(int width, int height, double percentage) {
        this.percentage = percentage;

        this.agentArray = new Agent[width][height];

        for (int i = 0; i < agentArray[0].length; i++) {
            for (int j = 0; j < agentArray.length; j++) {
                int randomAgentValue = (int) (Math.random() * 3);
                agentArray[i][j] = new Agent(randomAgentValue);
            }
        }

    }

    private boolean isSatisfied(int i, int j, int value) {
        int totalCount = 0;
        int numberSimilar = 0;
        int[] xMoves = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] yMoves = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < xMoves.length; k++) {
            if ((i + xMoves[k] >= 0 && i + xMoves[k] < agentArray.length) && (j + yMoves[k] >= 0 && j + yMoves[k] < agentArray.length)) {
                if (agentArray[i + xMoves[k]][j + yMoves[k]].color != 0) {
                    totalCount++;
                    if (value == agentArray[i + xMoves[k]][j + yMoves[k]].color) {
                        numberSimilar++;
                    }
                }
            }
        }

        if (totalCount == 0) {
            return false;
        }

        return ((((double) numberSimilar) / totalCount) >= percentage);
    }

    private void move() {
        ArrayList<Agent> dissatisfiedStuff = new ArrayList<>();

        for (int i = 0; i < agentArray.length; i++) {
            for (int j = 0; j < agentArray[0].length; j++) {
                if (!isSatisfied(i, j, agentArray[i][j].color)) {
                    dissatisfiedStuff.add(agentArray[i][j]);
                    agentArray[i][j] = new Agent(0);
                }
            }
        }

        for (int i = 0; i < agentArray.length; i++) {
            for (int j = 0; j < agentArray[0].length; j++) {
                if (agentArray[i][j].color == 0) {
                    int random = (int) Math.floor(Math.random() * dissatisfiedStuff.size());
                    if(dissatisfiedStuff.get(random).budget >= agentArray[i][j].budget) {
                        Agent randomDissatisfiedAgent = dissatisfiedStuff.get(random);
                        agentArray[i][j] = new Agent(randomDissatisfiedAgent.color, randomDissatisfiedAgent.budget);
                        dissatisfiedStuff.remove(random);
                    }
                }
            }
        }

    }

    public void doSimulation() {
        Picture picture = new Picture(agentArray.length, agentArray[0].length);
        while (true) {
            move();
            display(picture);
        }
    }

    private void display(Picture simulation) {
        for (int i = 0; i < agentArray.length; i++) {
            for (int j = 0; j < agentArray[0].length; j++) {
                if (agentArray[i][j].color == 0) {
                    simulation.set(i, j, Color.white);
                } else if (agentArray[i][j].color == 1) {
                    simulation.set(i, j, Color.red);
                } else {
                    simulation.set(i, j, Color.blue);
                }
            }
            simulation.show();
        }

    }
}