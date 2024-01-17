import Item from '../item/Item';
import React, { Component } from "react";
import {useState, useEffect} from 'react';
import AuthService from "../../services/auth.service";
import './Home.css';
import {Toggle} from'../toggle/Toggle';
import {Footer} from'../footer/Footer';
import {Routes, Route, useNavigate} from 'react-router-dom';
import UserService from "../../services/user.service";
import { useTranslation } from "react-i18next";
import { Link } from 'react-router-dom';


function Home() {
    const xd = ({games}) => {
        return (
            <Item games={games}/>
        )
    }
    const navigate = useNavigate();
    const userString = localStorage.getItem("user");
    const user = JSON.parse(userString);

    const navigateToShop = () => {
        navigate('/shop');
    };
    const navigateToProfile = () => {
        navigate('/profile');
    };
    const navigateToHome = () => {
        navigate('/');
    };

    function componentDidMount() {
        UserService.getPublicContent().then(
            response => {
                this.setState({
                    content: response.data
                });
            },
            error => {
                this.setState({
                    content:
                        (error.response && error.response.data) ||
                        error.message ||
                        error.toString()
                });
            }
        );
    }

    const { t, i18n } = useTranslation();
    if(user != null){
        return(
            <div>
                <div className="App">
                    {componentDidMount}
                    <div className="logo-container">
                        <div onClick={navigateToHome}>
                            <img src="/path/to/your/logo.png" alt="App Logo" className="app-logo"/>
                        </div>
                        <div className="switch-container">
                            <Toggle/>
                        </div>
                    </div>
                    <div className="main-content">
                        <div className="section-container store-section" onClick={navigateToShop}>
                            <h2>{t("store.label")}</h2>
                            <div className="image-panels">
                                {/* Row 1 */}
                                <div className="image-panel">

                                        <img
                                            src="https://cdn.akamai.steamstatic.com/steam/apps/526870/header.jpg?t=1701857353"
                                            alt="Image 1"/>

                                </div>
                                <div className="image-panel">

                                        <img
                                            src="https://cdn.akamai.steamstatic.com/steam/apps/383870/header.jpg?t=1688484486"
                                            alt="Image 1"/>

                                </div>
                                <div className="image-panel">

                                        <img
                                            src="https://cdn.akamai.steamstatic.com/steam/apps/323190/header.jpg?t=1701879213"
                                            alt="Image 1"/>

                                </div>
                                {/* Row 2 */}
                                <div className="image-panel">

                                        <img
                                            src="https://cdn.akamai.steamstatic.com/steam/apps/1086940/header.jpg?t=1703250718"
                                            alt="Image 1"/>

                                </div>
                                <div className="image-panel">

                                        <img
                                            src="https://cdn.cloudflare.steamstatic.com/steam/apps/2207490/header.jpg?t=1705005734"
                                            alt="Image 1"/>

                                </div>
                                <div className="image-panel">
                                        <img
                                            src="https://cdn.cloudflare.steamstatic.com/steam/apps/1222690/header.jpg?t=1668811031"
                                            alt="Image 1"/>
                                </div>
                            </div>
                        </div>
                        <div className="section-container profile-section" onClick={navigateToProfile}>
                            <h2>{t("profile.label")}</h2>
                            <div className="profile-content">
                                <div className="profile-image">
                                        <img
                                            src="https://cdn.discordapp.com/attachments/1112468265529258126/1197159700312109087/RDT_20240111_0717142314283480111283957.jpg?ex=65ba40da&is=65a7cbda&hm=cd89b09f2452f6734ba70c271fe21b25882be84bd38c1ddafd7e4f8c7ba87d75&"
                                            alt="User_Avatar"/>
                                </div>
                                <h3 className="profile-username">{user.user.username}</h3>
                            </div>
                        </div>
                    </div>
                    <Footer/>
                </div>
            </div>
        )
    } else {
        return (
            <div className="App">
                {componentDidMount}
                <div className="logo-container">
                    <div onClick={navigateToHome}>
                        <img src="/path/to/your/logo.png" alt="App Logo" className="app-logo"/>
                    </div>
                    <div className="switch-container">
                        <Toggle/>
                    </div>
                </div>
                <div className="main-content">
                    <div className="section-container store-section" onClick={navigateToShop}>
                        <h2>{t("store.label")}</h2>
                        <div className="image-panels">
                            {/* Row 1 */}
                            <div className="image-panel">
                                <a href="https://cdn.akamai.steamstatic.com/steam/apps/526870/header.jpg?t=1701857353"
                                   target="_blank" rel="noopener noreferrer">
                                    <img
                                        src="https://cdn.akamai.steamstatic.com/steam/apps/526870/header.jpg?t=1701857353"
                                        alt="Image 1"/>
                                </a>
                            </div>
                            <div className="image-panel">
                                <a href="https://cdn.akamai.steamstatic.com/steam/apps/383870/header.jpg?t=1688484486"
                                   target="_blank" rel="noopener noreferrer">
                                    <img
                                        src="https://cdn.akamai.steamstatic.com/steam/apps/383870/header.jpg?t=1688484486"
                                        alt="Image 1"/>
                                </a>
                            </div>
                            <div className="image-panel">
                                <a href="https://cdn.akamai.steamstatic.com/steam/apps/323190/header.jpg?t=1701879213"
                                   target="_blank" rel="noopener noreferrer">
                                    <img
                                        src="https://cdn.akamai.steamstatic.com/steam/apps/323190/header.jpg?t=1701879213"
                                        alt="Image 1"/>
                                </a>
                            </div>
                            {/* Row 2 */}
                            <div className="image-panel">
                                <a href="https://cdn.akamai.steamstatic.com/steam/apps/1086940/header.jpg?t=1703250718"
                                   target="_blank" rel="noopener noreferrer">
                                    <img
                                        src="https://cdn.akamai.steamstatic.com/steam/apps/1086940/header.jpg?t=1703250718"
                                        alt="Image 1"/>
                                </a>
                            </div>
                            <div className="image-panel">
                                <a href="https://cdn.cloudflare.steamstatic.com/steam/apps/2207490/header.jpg?t=1705005734"
                                   target="_blank" rel="noopener noreferrer">
                                    <img
                                        src="https://cdn.cloudflare.steamstatic.com/steam/apps/2207490/header.jpg?t=1705005734"
                                        alt="Image 1"/>
                                </a>
                            </div>
                            <div className="image-panel">
                                <a href="https://cdn.cloudflare.steamstatic.com/steam/apps/1222690/header.jpg?t=1668811031"
                                   target="_blank" rel="noopener noreferrer">
                                    <img
                                        src="https://cdn.cloudflare.steamstatic.com/steam/apps/1222690/header.jpg?t=1668811031"
                                        alt="Image 1"/>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div className="section-container login-section">
                        <Link to={'/login'}>
                        <h2 className="logreg">Sign in</h2>
                        </Link>
                        <Link to={'/register'}>
                        <h2 className="logreg">Register</h2>
                        </Link>
                    </div>
                </div>
            <Footer/>
        </div>
    )}
}
export default Home;
