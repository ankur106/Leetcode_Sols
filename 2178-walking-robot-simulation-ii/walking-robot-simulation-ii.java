class Robot {
    int width, height, perimeter;
    int stepsTaken;
    boolean moved;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height - 2);
        this.stepsTaken = 0;
        this.moved = false;
    }
    
    public void step(int num) {
        moved = true;
        stepsTaken = (stepsTaken + num) % perimeter;
    }
    
    public int[] getPos() {
        int s = stepsTaken;
        if (s <= width - 1) return new int[]{s, 0};
        s -= (width - 1);

        if (s <= height - 1) return new int[]{width - 1, s};
        s -= (height - 1);

        if (s <= width - 1) return new int[]{width - 1 - s, height - 1};
        s -= (width - 1);

        return new int[]{0, height - 1 - s};
    }
    
    public String getDir() {
        int s = stepsTaken;

        if (moved && s == 0) return "South";

        if (s > 0 && s <= width - 1) return "East";
        if (s > width - 1 && s <= (width + height - 2)) return "North";
        if (s > (width + height - 2) && s <= (2 * width + height - 3)) return "West";
        
        return (s == 0 && !moved) ? "East" : "South";
    }
}