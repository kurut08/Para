import Item from '../item/Item';
import React, { Component } from "react";
import {useState, useEffect} from 'react';
import './Home.css';
import {Toggle} from'../toggle/Toggle';
import {Footer} from'../footer/Footer';
import {Routes, Route, useNavigate} from 'react-router-dom';
import UserService from "../../services/user.service";


function Home() {
    const xd = ({games}) => {
        return (
            <Item games={games}/>
        )
    }
    const navigate = useNavigate();
    const navigateToShop = () => {
        navigate('/shop');
    };
    const navigateToLibrary = () => {
        navigate('/library');
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
                    <h2>Store</h2>
                    <div className="image-panels">
                        {/* Row 1 */}
                        <div className="image-panel">
                            <a href="https://cdn.akamai.steamstatic.com/steam/apps/526870/header.jpg?t=1701857353" target="_blank" rel="noopener noreferrer">
                                <img src="https://cdn.akamai.steamstatic.com/steam/apps/526870/header.jpg?t=1701857353" alt="Image 1"/>
                            </a>
                        </div>
                        <div className="image-panel">
                            <a href="https://cdn.akamai.steamstatic.com/steam/apps/383870/header.jpg?t=1688484486" target="_blank" rel="noopener noreferrer">
                                <img src="https://cdn.akamai.steamstatic.com/steam/apps/383870/header.jpg?t=1688484486" alt="Image 1"/>
                            </a>
                        </div>
                        <div className="image-panel">
                            <a href="https://cdn.akamai.steamstatic.com/steam/apps/323190/header.jpg?t=1701879213" target="_blank" rel="noopener noreferrer">
                                <img src="https://cdn.akamai.steamstatic.com/steam/apps/323190/header.jpg?t=1701879213" alt="Image 1"/>
                            </a>
                        </div>
                        {/* Row 2 */}
                        <div className="image-panel">
                            <a href="https://cdn.akamai.steamstatic.com/steam/apps/1086940/header.jpg?t=1703250718" target="_blank" rel="noopener noreferrer">
                                <img src="https://cdn.akamai.steamstatic.com/steam/apps/1086940/header.jpg?t=1703250718" alt="Image 1"/>
                            </a>
                        </div>
                        <div className="image-panel">
                            <a href="https://cdn.cloudflare.steamstatic.com/steam/apps/2207490/header.jpg?t=1705005734" target="_blank" rel="noopener noreferrer">
                                <img src="https://cdn.cloudflare.steamstatic.com/steam/apps/2207490/header.jpg?t=1705005734" alt="Image 1"/>
                            </a>
                        </div>
                        <div className="image-panel">
                            <a href="https://cdn.cloudflare.steamstatic.com/steam/apps/1222690/header.jpg?t=1668811031" target="_blank" rel="noopener noreferrer">
                                <img src="https://cdn.cloudflare.steamstatic.com/steam/apps/1222690/header.jpg?t=1668811031" alt="Image 1"/>
                            </a>
                        </div>
                    </div>
                </div>
                <div className="section-container library-section" onClick={navigateToLibrary}>
                    <h2>Library</h2>
                    {/* Add library content here */}
                </div>
                <div className="section-container profile-section" onClick={navigateToProfile}>
                    <h2>Profile</h2>
                    {/* Add profile content here */}
                </div>
            </div>
            <Footer/>
        </div>
    );
}
export default Home;
