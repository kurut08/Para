import {useEffect, useState} from "react";
import axios from "axios";
import {Routes, Route, useNavigate} from 'react-router-dom';
import {Toggle} from'./toggle/Toggle';
import {Footer} from'./footer/Footer';
import {PriceRangeBar} from './pricerangebar/PriceRangeBar'
import './Shop.css';
function Shop(){
    const defaultVaule = [];
    const [games, setGames] = useState(defaultVaule);
    const navigate = useNavigate();

    const getGames = async () =>{
        try
        {
            const response = await fetch('http://localhost:8080/auth/shop', {mode:'cors'}).then((response) => response.json());
            console.log({ response });
            setGames(response);
        }
        catch(err)
        {
            console.log(err);
        }
        
    };
    useEffect(() => {
        getGames();
      }, []);

    const navigateToHome = () => {
        navigate('/');
    };
    return(
        <div className="shop">
            <div className="logo-container">
                <div onClick={navigateToHome}>
                    <img src="/path/to/your/logo.png" alt="App Logo" className="app-logo"/>
                </div>
                <div className="switch-container">
                    <Toggle/>
                </div>
            </div>
            <div className="content-shop">
                <h1>SHOP</h1>
                <div className="sort">
                    <PriceRangeBar/>
                </div>
                <div>
                    {games.map((game) => (
                        <div className="item-container">
                            <p>Id: {game.id}</p>
                            <p>Title: {game.title} </p>
                            <p>Description: {game.description}</p>
                            <p>Price: {game.price} </p>
                            <p>ImageURL: {game.imageUrl} </p>
                            <p>Genres: {game.genres}</p>
                            <p>{'\n'}</p>
                        </div>
                    ))}
                </div>
            </div>
            <Footer/>
        </div>
    )
}

export default Shop;