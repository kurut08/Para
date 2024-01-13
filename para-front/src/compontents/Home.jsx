import Item from './item/Item';
import React, {useState, useEffect} from 'react';
import './Home.css';
import {Toggle} from'./toggle/Toggle';
import {Footer} from'./footer/Footer';
import {Routes, Route, useNavigate} from 'react-router-dom';
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



    return (
        <div className="App">
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
                            <a href="https://example.com/link-to-image1" target="_blank" rel="noopener noreferrer">
                                <img src="https://example.com/image1.jpg" alt="Image 1"/>
                            </a>
                        </div>
                        <div className="image-panel">
                            <a href="https://example.com/link-to-image1" target="_blank" rel="noopener noreferrer">
                                <img src="https://example.com/image1.jpg" alt="Image 1"/>
                            </a>
                        </div>
                        <div className="image-panel">
                            <a href="https://example.com/link-to-image1" target="_blank" rel="noopener noreferrer">
                                <img src="https://example.com/image1.jpg" alt="Image 1"/>
                            </a>
                        </div>
                        {/* Row 2 */}
                        <div className="image-panel">
                            <a href="https://example.com/link-to-image1" target="_blank" rel="noopener noreferrer">
                                <img src="https://example.com/image1.jpg" alt="Image 1"/>
                            </a>
                        </div>
                        <div className="image-panel">
                            <a href="https://example.com/link-to-image1" target="_blank" rel="noopener noreferrer">
                                <img src="https://example.com/image1.jpg" alt="Image 1"/>
                            </a>
                        </div>
                        <div className="image-panel">
                            <a href="https://example.com/link-to-image1" target="_blank" rel="noopener noreferrer">
                                <img src="https://example.com/image1.jpg" alt="Image 1"/>
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