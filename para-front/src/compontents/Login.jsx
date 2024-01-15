import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import axios from "axios";
import {Toggle} from'./toggle/Toggle';
import {Footer} from'./footer/Footer';
import './Login.css';


function Login() {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();


    async function login(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8080/auth/loginMess", {
                username: username,
                password: password,
            }).then((res) =>
            {

                console.log(res.data);

                if (res.data.message === "Username not exits")
                {
                    alert("Username not exits");
                }
                else if(res.data.message === "Login Success")
                {
                    navigate('/shop');
                }
                else
                {
                    alert("Given credentials does not match");
                }
            }, fail => {
                console.error(fail); // Error!
            });
        }


        catch (err) {
            alert(err);
        }

    }
    const navigateToHome = () => {
        navigate('/');
    };

    return (
        <div>
            <div className="logo-container">
                <div onClick={navigateToHome}>
                    <img src="/path/to/your/logo.png" alt="App Logo" className="app-logo"/>
                </div>
                <div className="switch-container">
                    <Toggle/>
                </div>
            </div>
            <div className="container">
                <div className="row">
                    <h2>Login</h2>
                    <hr/>
                </div>

                <div className="row">
                    <div className="col-sm-6">

                        <form>
                            <div className="form-group">
                                <label>Username</label>
                                <input type="email" className="form-control" id="username" placeholder="Enter Username"

                                       value={username}
                                       onChange={(event) => {
                                           setUsername(event.target.value);
                                       }}

                                />

                            </div>

                            <div className="form-group">
                                <label>password</label>
                                <input type="password" className="form-control" id="password"
                                       placeholder="Enter Password"

                                       value={password}
                                       onChange={(event) => {
                                           setPassword(event.target.value);
                                       }}

                                />
                            </div>
                            <button type="submit" className="btn btn-primary" onClick={login}>Login</button>
                        </form>

                    </div>
                </div>
            </div>
        <Footer/>
        </div>
    );
}

export default Login;