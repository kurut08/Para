import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import axios from "axios";
import {Toggle} from '../toggle/Toggle';
import {Footer} from '../footer/Footer';
import './Login.css';
import { isEmpty } from "validator";


function Login() {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();


    async function login(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8080/auth/login", {
                username: username,
                password: password,
            }).then((res) =>
            {

                console.log(res.data);
                console.log(res.data.jwt)

                if (res.data.message === "Username not exits")
                {
                    alert("Username not exits");
                }
                else if(!isEmpty(res.data.jwt))
                {
                    localStorage.setItem("user", JSON.stringify(res.data))
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
        <div className="login-container">
            <header className="login-header">
                <div onClick={navigateToHome} className="login-logo">
                    <img src="/path/to/your/logo.png" alt="App Logo" />
                </div>
                <div className="login-toggle">
                    <Toggle />
                </div>
            </header>
            <main className="login-main">
                <h2>Login</h2>
                <hr />
                <form onSubmit={login} className="login-form">
                    <div className="form-group">
                        <label htmlFor="username">Username</label>
                        <input
                            type="email"
                            id="username"
                            placeholder="Enter Username"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <input
                            type="password"
                            id="password"
                            placeholder="Enter Password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                    </div>
                    <button type="submit" className="btn btn-primary">Login</button>
                </form>
            </main>
            <Footer />
        </div>
    );
}

export default Login;