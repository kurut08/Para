import AuthService from "../../services/auth.service";
import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import axios from "axios";
import GameList from '../gamelist/GameList';



function Library(){
    const defaultVaule = [];
    const URL = "http://localhost:8080/auth/library/";
    const navigate = useNavigate();
    const user = AuthService.getCurrentUser();
    const [games, setGames] = useState(defaultVaule);
    const getGames = async () =>{
        try
        {
            if(user == null){
                navigate("/home");
            }
            else{
                const response = await fetch(URL+user.user.userId,  {mode:'cors'}).then((response) => response.json());
                console.log({ response });
                setGames(response);
            }
        }
        catch(err)
        {
            console.log(err);
        }

    };
    useEffect(() => {
        getGames();
    }, []);
    if(user != null)
    {
        return(
            <div>
                <h1>Library page</h1>
                <h2>ID USERA:{user.user.userId}</h2>
                PRINTOWANIE GIER
            </div>
        )
    }

}
export default Library;