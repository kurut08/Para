import React from 'react';
import "./Toggle.css"


export const Toggle = () =>{
    const setDarkMode = () =>{
        document.querySelector("body").setAttribute('data-theme', 'dark');
        localStorage.setItem("selectedTheme", "dark");
    }
    const setLightMode = () =>{
        document.querySelector("body").setAttribute('data-theme', 'light');
        localStorage.setItem("selectedTheme", "light");
    }
    const selectedTheme = localStorage.getItem("selectedTheme");

    if (selectedTheme === "dark"){
        setDarkMode();
    }
    const toggleTheme = (e) =>{
        if(e.target.checked) setDarkMode();
        else setLightMode();
    }

    return (
        <div className="toggle-container">
            <input
                type="checkbox"
                id="dark_mode_toggle"
                className="toggle"
                onChange={toggleTheme}
                defaultChecked={selectedTheme === "dark"}
            />
            <label className="toggle_label" htmlFor= "dark_mode_toggle"></label>
        </div>
    );
}
