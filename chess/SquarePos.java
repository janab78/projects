public class SquarePos {
    int xPos;
    int yPos;

    public SquarePos(String p) {
        xPos = (int)(p.charAt(0)) - 96;
        yPos = (int)(p.charAt(1)) - 48;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
}