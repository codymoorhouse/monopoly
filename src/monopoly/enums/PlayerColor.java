package monopoly.enums;

import java.awt.Color;

public enum PlayerColor {
    PLAYER_ONE(new Color(255, 249, 102)),
    PLAYER_TWO(new Color(66, 134, 244)),
    PLAYER_THREE(new Color(143, 99, 158)),
    PLAYER_FOUR(new Color(209, 155, 20)),
    PLAYER_FIVE(new Color(209, 96, 20)),
    PLAYER_SIX(new Color(120, 230, 30)),
    PLAYER_SEVEN(new Color(206, 57, 72)),
    PLAYER_EIGHT(new Color(72, 196, 188));

    private final Color color;

    private PlayerColor(Color color) {
        this.color = color;
    }
    
    public Color getColor() {
        return color;
    }
}
