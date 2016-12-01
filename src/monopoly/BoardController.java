package monopoly;

import java.util.ArrayList;
import java.util.List;
import monopoly.enums.PlayerColor;

public class BoardController {
    public static final int MAX_PLAYER = 8;
    
    private GameBoard gameBoard;
    private int outOfGamePlayers = 0;
    private int playerTurnIndex = 0;
    private final List<Player> players = new ArrayList<>();

    public BoardController(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }
    
    public Player getCurrentPlayer() {
        return getPlayer(playerTurnIndex);
    }

    public int getCurrentPositionIndex(Player player) {
        Cell currentPosition = player.getPosition();
        return gameBoard.queryCellIndex(currentPosition.getName());
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public int getNewPositionIndex(int positionIndex, int diceValue) {
        return (positionIndex + diceValue) % gameBoard.getCellSize();    
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public int getOutOfGamePlayersNumber() {
        return outOfGamePlayers;
    }
    
    public Player getPlayer(int index) {
        return players.get(index);
    }
    
    public int getPlayerIndex(Player player) {
        return players.indexOf(player);
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    
    public int getTurn() {
        return playerTurnIndex;
    }
	
    public void movePlayer(Player player, int diceValue) {
        int positionIndex = getCurrentPositionIndex(player);
        int newIndex = getNewPositionIndex(positionIndex, diceValue);
        if (newIndex <= positionIndex || diceValue > gameBoard.getCellSize())
            player.setMoney(player.getMoney() + 200);
        player.setPosition(gameBoard.getCell(newIndex));
    }
    
    public void removePlayer() {
        outOfGamePlayers++;
    }
    
    public void reset() {    
        for (int i = 0; i < getNumberOfPlayers(); i++) {
            Player player = players.get(i);
            player.setPosition(gameBoard.getCell(0));
        }
        playerTurnIndex = 0;
    }
    
    public void setGameBoard(GameBoard board) {
        this.gameBoard = board;
    }
    
    public void setNumberOfPlayers(int number) {
        players.clear();
        for (int i = 0; i < number; i++) {
            Player player = new Player(gameBoard.getCell(0));
            player.setPlayerColor(PlayerColor.values()[i].getColor());
            players.add(player);
        }
    }
    
    public void switchTurn() {
        playerTurnIndex = (playerTurnIndex + 1) % getNumberOfPlayers();
    }
}
