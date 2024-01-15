import React, { Component } from "react";
import { Routes, Route, Link, BrowserRouter } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import AuthService from "./services/auth.service";

import api from './api/axiosConfig';
import Header from './compontents/header/Header';
import Register from "./compontents/register/Register";
import Login from "./compontents/login/Login";
import Home from "./compontents/home/Home";
import Verify from "./compontents/verify/Verify";
import Shop from "./compontents/shop/Shop";
import Library from "./compontents/library/Library";
import Profile from "./compontents/profile/Profile";
import Edit from "./compontents/edit/Edit";

class App extends Component {
    constructor(props) {
        super(props);
        this.logOut = this.logOut.bind(this);

        this.state = {
            showModeratorBoard: false,
            showAdminBoard: false,
            currentUser: undefined,
        };
    }

    componentDidMount() {
        const user = AuthService.getCurrentUser();

        if (user) {
            this.setState({
                currentUser: user,
                showAdminBoard: user.user.authorities.includes("ADMIN"),
            });
        }
    }

    logOut() {
        AuthService.logout();
        this.setState({
            showModeratorBoard: false,
            showAdminBoard: false,
            currentUser: undefined,
        });
    }
    render() {

        return (
            <div className="App">
                <BrowserRouter>
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/home" element={<Home />} />
                        <Route path="/login" element={<Login />} />
                        <Route path="/register" element={<Register />} />
                        <Route path="/verify" element={<Verify />} />
                        <Route path="/profile" element={<Profile />} />
                        <Route path="/shop" element={ <Shop/>} />
                        <Route path="/library" element={ <Library/>} />
                        <Route path="/edit" element={ <Edit/>} />
                    </Routes>
                </BrowserRouter>

            </div>
        );
    }
}

export default App;