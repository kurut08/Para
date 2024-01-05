import {useEffect, useState} from "react";
import axios from "axios";
function Shop(){
    const defaultVaule = [];
    const [games, setGames] = useState(defaultVaule);

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
    return(
        <div className="shop">
          <h1>SHOP</h1>
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
    )
}
export default Shop;