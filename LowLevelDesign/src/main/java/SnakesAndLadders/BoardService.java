package SnakesAndLadders;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BoardService {
	private Board snakeAndLadderBoard;
	private int playerCount;
	private Queue<Player> players;

	public BoardService(int boardSize) {
		this.snakeAndLadderBoard = new Board(boardSize);
		this.players = new LinkedList<Player>();
	}

	public void initializeBoard(List<Player> players, List<Snake> snakes, List<Ladder> ladders) {
		setPlayers(players);
		setSnakes(snakes);
		setLadders(ladders);
	}

	private void setPlayers(List<Player> players) {
		this.playerCount = players.size();
		Map<String, Integer> playerPieces = new HashMap<>();
		for (Player player : players) {
			this.players.add(player);
			playerPieces.put(player.getId(), 0);
		}
		snakeAndLadderBoard.setPlayerPieces(playerPieces);
	}

	private void setSnakes(List<Snake> snakes) {
		snakeAndLadderBoard.setSnakes(snakes);
	}

	private void setLadders(List<Ladder> ladders) {
		snakeAndLadderBoard.setLadders(ladders);
	}

	private int getNewPositionAfterGoingThroughSnakesAndLadders(int newPosition) {
		int previousPosition;
		do {
			previousPosition = newPosition;
			for (Snake snake : snakeAndLadderBoard.getSnakes()) {
				if (snake.getStart() == newPosition)
					newPosition = snake.getEnd(); 
			}
			for (Ladder ladder : snakeAndLadderBoard.getLadders()) {
				if (ladder.getStart() == newPosition)
					newPosition = ladder.getEnd(); 
			}
		} while (newPosition != previousPosition);
		return newPosition;
	}

	public void makeMove(Player player, int movement) {
		int oldPosition = snakeAndLadderBoard.getPlayerPieces().get(player.getId());
		int newPosition = oldPosition + movement;
		int boardSize = snakeAndLadderBoard.getSize();
		if (newPosition > boardSize) {
			newPosition = oldPosition;
		} else {
			newPosition = getNewPositionAfterGoingThroughSnakesAndLadders(newPosition);
		}
		snakeAndLadderBoard.getPlayerPieces().put(player.getId(), newPosition);
		System.out.println(
				player.getName() + " rolled a " + movement + " and moved from " + oldPosition + " to " + newPosition);
	}

    private boolean hasPlayerWon(Player player) {
        int playerPosition = snakeAndLadderBoard.getPlayerPieces().get(player.getId());
        int winningPosition = snakeAndLadderBoard.getSize();
        return playerPosition == winningPosition;
    }
	
    private int getDiceValue() {
        return DiceService.roll();
    }

	public boolean isGameCompleted() {
	    int currentNumberOfPlayers = players.size();
        return currentNumberOfPlayers < playerCount; // we remove winner from queue
	}

	public void startGame() {
		while (!isGameCompleted()) {
            Player currentPlayer = players.poll();
            int totalDiceValue = getDiceValue();
            makeMove(currentPlayer, totalDiceValue);
            if (hasPlayerWon(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " wins the game");
                snakeAndLadderBoard.getPlayerPieces().remove(currentPlayer.getId());
            } else {
                players.add(currentPlayer);
            }
        }
	}
}
