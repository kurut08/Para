import {useEffect, useState} from "react";
import axios from "axios";
import {Routes, Route, useNavigate} from 'react-router-dom';
import {Toggle} from'./toggle/Toggle';
import {Footer} from'./footer/Footer';
import GameList from './gamelist/GameList';
import SortPanel from './sortpanel/SortPanel';
import {PriceRangeBar} from './pricerangebar/PriceRangeBar'
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
                <div className="sort">
                    <SortPanel
                        onSearch={setSearchTerm}
                        onGenreChange={setSelectedGenre}
                        onMaxPriceChange={price => setMaxPrice(Number(price))}
                    />
                </div>
                <GameList games={filteredGames} />
            </div>
            <Footer/>
        </div>
    )
}

export default Shop;