import { useState } from "react";
import Gameboard from "./components/gameboard/GameBoard"
import Log from "./components/gameboard/Log"
import Player from "./components/player/Player"

import {WINNING_COMBINATIONS} from "./winning-combinations"
import GameOver from "./components/gameboard/GameOver";

const initialGameBoard = [
    [null, null, null],
    [null, null, null],
    [null, null, null]
];

function deriveActivePlayer(gameTurns) {
  let currentPlayer = 'X';

  if(gameTurns.length > 0 && gameTurns[0].player === 'X') {
    currentPlayer = 'O';
  }
  return currentPlayer;
}

function App() {

  const [players, setPlayers] = useState({
    X: "Player 1",
    O: "Player 2"
  });
  const [gameTurns, setGameTurns] = useState([]);

  const activePlayer = deriveActivePlayer(gameTurns);

  let gameBoard = [...initialGameBoard.map(array => [...array])];
  gameTurns.forEach(turn => {
      const { row, col } = turn.square;
      gameBoard[row][col] = turn.player;
  });

  let winner;

  WINNING_COMBINATIONS.forEach(combination => {
    // Logic to check for a winning combination can be added here
    const firstSquareSymbol = gameBoard[combination[0].row][combination[0].column];
    const secondSquareSymbol = gameBoard[combination[1].row][combination[1].column];
    const thirdSquareSymbol = gameBoard[combination[2].row][combination[2].column];

    if(firstSquareSymbol && firstSquareSymbol === secondSquareSymbol && firstSquareSymbol === thirdSquareSymbol) {
      console.log(`Player ${firstSquareSymbol} wins!`);
      winner = players[firstSquareSymbol];
    }
  });

  const hasDraw = gameTurns.length === 9 && !winner;

  function handleSelectSquare(rowIndex, colIndex) {
    setGameTurns(prevGameTurns => {
      let currentPlayer = deriveActivePlayer(prevGameTurns);
      const updatedTurns = [{ square: {row: rowIndex, col: colIndex}, player: currentPlayer } ,...prevGameTurns]
      return updatedTurns;
    });
  }

  function handleRematch() {
    console.log('rematch clicked')
    setGameTurns([]);
  }

  function handlePlayerNameChange(symbol, newName) {
    setPlayers(prevPlayers => ({
      ...prevPlayers,
      [symbol]: newName
    }));
  }
  

  return (
    <main>
      <div id="game-container">
        <ol id="players" className="highlight-player">
          <Player name="Player 1" symbol="X" isActive = {activePlayer === 'X'} onChangeName={handlePlayerNameChange}/>
          <Player name="Player 2" symbol="O" isActive = {activePlayer === 'O'} onChangeName={handlePlayerNameChange}/>
        </ol>
        {(winner || hasDraw) && <GameOver winner={winner} onRematch={handleRematch} />}
        <Gameboard onSelectSquare={handleSelectSquare} board={gameBoard} />
      </div>
      <Log turns={gameTurns} />
    </main>
  )
}

export default App
