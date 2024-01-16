import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import axios from "axios";
import {Toggle} from '../toggle/Toggle';
import {Footer} from '../footer/Footer';
import './Login.css';
import { isEmpty } from "validator";
import { useTranslation } from "react-i18next";

function Login() {
    const { t, i18n } = useTranslation();

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
                    alert(t("loginUsernameNotExists.label"));
                }
                else if(!isEmpty(res.data.jwt))
                {
                    localStorage.setItem("user", JSON.stringify(res.data))
                    navigate('/shop');
                }
                else
                {
                    alert(t("credentialsDontMatch.label"));
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
                <h2>{t("login.label")}</h2>
                <hr />
                <form onSubmit={login} className="login-form">
                    <div className="form-group">
                        <label htmlFor="username">{t("username.label")}</label>
                        <input
                            type="text"
                            id="username"
                            placeholder={t("enterUsername.label")}
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">{t("password.label")}</label>
                        <input
                            type="password"
                            id="password"
                            placeholder={t("enterPassword.label")}
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                    </div>
                    <button type="submit" className="btn btn-primary">{t("login.label")}</button>
                </form>
            </main>
            <Footer />
        </div>
    );
}

export default Login;