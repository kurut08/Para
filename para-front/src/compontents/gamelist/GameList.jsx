import React from 'react';
import './GameList.css';

const GameList = ({ games }) => {
    return (
        <div className="game-list">
            {games.map(game => (
                <div className="game-item" key={game.id}>
                    <img className="game-image" src={game.url} alt={game.title}/>
                    <div className="game-info">
                        <h2 className="game-title">{game.title}</h2>
                        <p className="game-release-date">{games.genres}</p>
                        <p className="game-price">{game.price}$</p>
                    </div>
                </div>
            ))}
        </div>
    );
};
export default GameList;