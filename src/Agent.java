public class Agent {
    public int color;
    public int budget;

    public Agent(int color){
        this.color = color;
        this.budget = (int)(Math.random() * 1000000);
    }

    public Agent(int color, int budget){
        this.color = color;
        this.budget = budget;
    }
}
