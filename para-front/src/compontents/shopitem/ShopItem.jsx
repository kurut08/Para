import {useEffect, useState} from "react";
import axios from "axios";
import {Routes, Route, useNavigate, Link} from 'react-router-dom';
import {Toggle} from '../toggle/Toggle';
import {Footer} from '../footer/Footer';
import { useParams } from 'react-router-dom';
import { useTranslation } from "react-i18next";
import { debounce } from 'lodash';
import './ShopItem.css';

function ShopItem(){

    const [game, setGame] = useState();
    const [usergames, setuserGames] = useState();
    const navigate = useNavigate();
    const [contains, setContains] = useState()
    const params = useParams();
    const gameId = params.itemID;
    const { t, i18n } = useTranslation();

    const userString = localStorage.getItem("user");
    const user = JSON.parse(userString);


    const getGame = async () =>{
        try
        {
            const response = await fetch('http://localhost:8080/auth/shop/'+gameId, {mode:'cors'}).then((response) => response.json());
            setGame(response);

        }
        catch(err)
        {
            console.log(err);
        }

    };

        const getuserGames = async () => {
            try {
                const response = await fetch('http://localhost:8080/auth/library/' + user.user.userId, {mode: 'cors'}).then((response) => response.json());
                const containsGameWithId13 = response.some(item => item.game.id == gameId);
                setContains(containsGameWithId13);

            } catch (err) {
                console.log(err);
            }

        };

        async function buy(event) {
            event.preventDefault();
            try {
                await axios.post("http://localhost:8080/auth/buy/" + user.user.userId + "/" + gameId, {});
                alert(t("registerSuccessful.label"));
                window.location.reload();

            } catch (err) {
                alert(err);
            }
        }

    useEffect(() => {
        getGame();
    }, [gameId]);

    useEffect(() => {
        if(userString != null) {
            getuserGames();
        }
    }, [gameId, contains]);


    const navigateToHome = () => {
        navigate('/');
    };
    const navigateToLogin = () => {
        navigate('/login');
    };

    const navigateToProfile = () => {
        navigate('/profile');
    };

    if(userString!=null && contains == false)
    {
        return (
            <div className="shopItem">
                <div className="logo-container">
                    <div onClick={navigateToHome}>
                        <img src="/path/to/your/logo.png" alt="App Logo" className="app-logo"/>
                    </div>
                    <div className="user-container">
                        <img src="https://cdn.discordapp.com/attachments/1112468265529258126/1197159700312109087/RDT_20240111_0717142314283480111283957.jpg?ex=65ba40da&is=65a7cbda&hm=cd89b09f2452f6734ba70c271fe21b25882be84bd38c1ddafd7e4f8c7ba87d75&" onClick={navigateToProfile} alt="User" className="user-image"/>
                        <span
                            className="user-name">{user.user.username}</span>
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
                                        <button className="buy-button" onClick={buy}>{t("buy.label")}</button>
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
    }else if(userString!=null && contains == true){
        return(
            <div className="shopItem">
                <div className="logo-container">
                    <div onClick={navigateToHome}>
                        <img src="/path/to/your/logo.png" alt="App Logo" className="app-logo"/>
                    </div>
                    <div className="user-container">
                        <img src="https://cdn.discordapp.com/attachments/1112468265529258126/1197159700312109087/RDT_20240111_0717142314283480111283957.jpg?ex=65ba40da&is=65a7cbda&hm=cd89b09f2452f6734ba70c271fe21b25882be84bd38c1ddafd7e4f8c7ba87d75&" onClick={navigateToProfile} alt="User" className="user-image"/>
                        <span
                            className="user-name">{user.user.username}</span>
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
                                        <button className="buy-buttonOff" disabled={true}>{t("owned.label")}</button>
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
    }else{
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
                                        <button className="buy-button" onClick={navigateToLogin}>{t("login.label")}</button>
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
}

export default ShopItem;