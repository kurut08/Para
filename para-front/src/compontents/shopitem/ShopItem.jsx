import {useEffect, useState} from "react";
import axios from "axios";
import {Routes, Route, useNavigate, Link} from 'react-router-dom';
import {Toggle} from '../toggle/Toggle';
import {Footer} from '../footer/Footer';
import { useParams } from 'react-router-dom';
import './ShopItem.css';

function ShopItem(){

    const [game, setGame] = useState();
    const navigate = useNavigate();
    const params = useParams();
    const gameId = params.itemID;

    const getGame = async () =>{
        try
        {
            const response = await fetch('http://localhost:8080/auth/shop/'+gameId, {mode:'cors'}).then((response) => response.json());
            console.log({ response });
            setGame(response);

        }
        catch(err)
        {
            console.log(err);
        }

    };
    useEffect(() => {
        getGame();
    }, [gameId]);
    const navigateToHome = () => {
        navigate('/');
    };
    return(
        <div className="shopItem">
            <div className="logo-container">
                <div onClick={navigateToHome}>
                    <img src="/path/to/your/logo.png" alt="App Logo" className="app-logo"/>
                </div>
                <div className="switch-container">
                    <Toggle/>
                </div>
            </div>
            <div className="shopItem-main">
                {game && (
                    <div className="gameItem-info">
                        <div className="game-title-container">
                            <h1 className="gameItem-title">{game.title}</h1>
                        </div>
                        <div className="game-content">
                            <img src={game.url} alt={game.title} className="gameItem-image"/>
                            <div className="game-details">
                                <p className="gameItem-description">{game.description}</p>
                                <p className="gameItem-genre">Genre: {game.genre}</p>
                                <div className="purchase-container">
                                    <span className="gameItem-price">{game.price}$</span>
                                    <button className="buy-button">Buy</button>
                                </div>
                            </div>
                        </div>
                    </div>
                )}
                <div className="reviews">

                </div>
            </div>
            <Footer/>
        </div>
    );
}

export default ShopItem;