import { useState } from "react"

export default function Player({ name, symbol, isActive, onChangeName }) {

    const [isEditing, setIsEditing] = useState(false);
    const [playerName, setPlayerName] = useState(name);

    const handleEditClick = (name) => {
        setIsEditing(() => !isEditing);
        if(isEditing){
            onChangeName(symbol, playerName)
        }
    };

    const handleChange = (event) => {
        setPlayerName(event.target.value);
    };

    let playerField = <span className="player-name">{playerName}</span>;

    if(isEditing) {
        playerField = <input type="text" placeholder="Enter name" defaultValue={playerName} onChange={handleChange} />;
    }

  return (
    <li className={isActive ? "active" : ""}>
      <span className="player">
        {playerField}
        <span className="player-symbol">{symbol}</span>  
      </span>
      <button onClick={() => handleEditClick()}>{isEditing ? "Save" : "Edit"}</button>
    </li>
  )
}