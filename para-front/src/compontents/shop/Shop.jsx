import {useEffect, useState} from "react";
import axios from "axios";
import {Routes, Route, useNavigate, Link} from 'react-router-dom';
import {Toggle} from '../toggle/Toggle';
import {Footer} from '../footer/Footer';
import GameList from '../gamelist/GameList';
import SortPanel from '../sortpanel/SortPanel';
import { useTranslation } from "react-i18next";
import './Shop.css';
import { debounce } from 'lodash';
function Shop(){
    const defaultVaule = [];
    const [games, setGames] = useState(defaultVaule);
    const navigate = useNavigate();
    const [filteredGames, setFilteredGames] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    const [selectedGenre, setSelectedGenre] = useState('');
    const [maxPrice, setMaxPrice] = useState(Infinity);
    const userString = localStorage.getItem("user");
    const user = JSON.parse(userString);
    const { t, i18n } = useTranslation();

    const getGames = async () =>{
        try
        {
            const response = await fetch('http://localhost:8080/auth/shop', {mode:'cors'}).then((response) => response.json());
            console.log({ response });
            setGames(response);
            setFilteredGames(response);
        }
        catch(err)
        {
            console.log(err);
        }

    };
    useEffect(() => {
        getGames();
    }, []);

    const handleFilterLogic = debounce(() => {
        let filtered = games;

        if (searchTerm) {
            filtered = filtered.filter(game =>
                game.title.toLowerCase().includes(searchTerm.toLowerCase())
            );
        }

        if (selectedGenre) {
            filtered = filtered.filter(game => game.genre === selectedGenre);
        }

        if (maxPrice !== Infinity) {
            filtered = filtered.filter(game => game.price <= maxPrice);
        }

        setFilteredGames(filtered);
    }, 500);

    useEffect(() => {
        handleFilterLogic();
        return () => {
            handleFilterLogic.cancel();
        }
    }, [searchTerm, selectedGenre, maxPrice, games]);

    const navigateToHome = () => {
        navigate('/');
    };

    const navigateToProfile = () => {
        navigate('/profile');
    };


    if(userString != null){
    return(
        <div className="shop">
            <div className="logo-container">
                <div onClick={navigateToHome}>
                    <img src="/path/to/your/logo.png" alt="App Logo" className="app-logo"/>
                </div>
                <div className="user-container">
                    <img onClick={navigateToProfile}
                        src="https://cdn.discordapp.com/attachments/1112468265529258126/1197159700312109087/RDT_20240111_0717142314283480111283957.jpg?ex=65ba40da&is=65a7cbda&hm=cd89b09f2452f6734ba70c271fe21b25882be84bd38c1ddafd7e4f8c7ba87d75&"
                        alt="User" className="user-image"/>
                    <span className="user-name">{user.user.username}</span>
                </div>
                <div className="switch-container">
                    <Toggle/>
                </div>
            </div>
            <div className="content-shop">
                <div className="sort">
                    <SortPanel
                        onSearch={setSearchTerm}
                        onGenreChange={setSelectedGenre}
                        onMaxPriceChange={price => setMaxPrice(Number(price))}
                    />
                </div>
                <GameList games={filteredGames}/>
            </div>
            <Footer/>
        </div>
    )
    }else{
    return(
        <div className="shop">
            <div className="logo-container">
                <div onClick={navigateToHome}>
                    <img src="/path/to/your/logo.png" alt="App Logo" className="app-logo"/>
                </div>
                <div className="user-container">
                    <Link to={'/login'} >{t("login.label")}</Link>
                </div>
                <div className="switch-container">
                    <Toggle/>
                </div>
            </div>
            <div className="content-shop">
                <div className="sort">
                    <SortPanel
                        onSearch={setSearchTerm}
                        onGenreChange={setSelectedGenre}
                        onMaxPriceChange={price => setMaxPrice(Number(price))}
                    />
                </div>
                <GameList games={filteredGames}/>
            </div>
            <Footer/>
        </div>
    )}
}

export default Shop;