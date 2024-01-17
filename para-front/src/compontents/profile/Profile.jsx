import React, { Component, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import AuthService from "../../services/auth.service";
import { useTranslation } from "react-i18next";
import axios from "axios";
import {Toggle} from'../toggle/Toggle';
import {Footer} from'../footer/Footer';
import './Profile.css';

function Profile(){
    const { t, i18n } = useTranslation();
    const defaultVaule = [];
    const [invite, setInvite] = useState(defaultVaule);
    const currentUser = AuthService.getCurrentUser();
    const [friends, setFriend] = useState(defaultVaule);
    const [query, setQuery] = useState(defaultVaule);
    const [userFrom, setUserFrom] = useState("");
    const [userTo, setUserTo] = useState("");
    const [userFrom1, setUserFrom1] = useState("");
    const [userTo1, setUserTo1] = useState("");
    const [bool, setBool] = useState("");
    const [games, setGames] = useState(defaultVaule);
    const navigate = useNavigate();


    const navigateToHome = () => {
        navigate('/');
    };

    const getGames = async () =>{
        try
            {   
                const response = await fetch('http://localhost:8080/auth/library/'+currentUser.user.userId, {mode:'cors'}).then((response) => response.json());
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

    const getInvite = async () =>{
    try
        {   
            const response = await fetch('http://localhost:8080/auth/user/inviteList/'+currentUser.user.userId, {mode:'cors'}).then((response) => response.json());
            console.log({ response });
            setInvite(response);
        }
        catch(err)
        {
            console.log(err);
        }

    };
    useEffect(() => {
        getInvite();
    }, []);

    const getFriends = async () =>{
        try
            {
                const response = await fetch('http://localhost:8080/auth/user/friendList/'+currentUser.user.userId, {mode:'cors'}).then((response) => response.json());
                console.log({ response });
                setFriend(response);
            }
            catch(err)
            {
                console.log(err);
            }
    
        };
        useEffect(() => {
            getFriends();
        }, []);
    
    
    async function createInvite(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8080/auth/user/createInvite", {
                userFrom: userFrom,
                userTo: userTo
            }).then((res) =>
            {
                alert("Invite SENT");
                console.log(res);
            }, fail => {
                console.error(fail); // Error!
            });
        }

        catch (err) {
            alert(err);
        }

    }
    async function accept(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8080/auth/user/acceptInvite/"+userFrom1, {
                userFrom: userFrom1,
                userTo: userTo1,
                bool: bool
            }).then((res) =>
            {
                alert("ACCEPTED/DECLINED")
                console.log(res);
            }, fail => {
                console.error(fail); // Error!
            });
        }

        catch (err) {
            alert(err);
        }

    }
const listInvites = invite.map((d) => <li key={d.inviteId}>{t("friendid.label")}: {d.userTo}</li>);
const listFriends = friends.map((d) => <li key={d.friendListId}> {d.owner.username}</li>);
const listGames = games.map((d) => <li key={d.id}>{d.game.title}</li>);
    return (

        <div className="main-container-profile">
             <div className="logo-container">
                <div onClick={navigateToHome}>
                    <img src="/path/to/your/logo.png" alt="App Logo" className="app-logo"/>
                </div>
                <div className="switch-container">
                    <Toggle/>
                </div>
            </div>

            <div className="profile-container">
                <div className="card-profile">
                    <div className="personal-info">
                        <p>
                        <strong>ID:</strong>{" "}
                        {currentUser.user.userId}
                        </p>
                        <p>
                        <strong>Email: </strong>{" "}
                        {currentUser.user.email}
                        </p>
                        <p>
                        <strong>{t("usernameprofile.label")}</strong>
                        {currentUser.user.username}
                        </p>
                    </div>
                    <br></br>
                    </div>
                    <div className="card-profile">
                        <p>
                            <strong>{t("owngames.label")}</strong>
                            {listGames}
                        </p>
                    </div>
                    <br></br>
                    <div className="card-profile">
                        <p>
                            <strong>{t("owninvites.label")}</strong>
                            {listInvites}
                        </p>
                    </div>
                    <br></br>
                    <div className="card-profile">
                        <p>
                            <strong>{t("ownfriends.label")}</strong>
                            {listFriends}
                        </p>
                    </div>
                    <br></br>
                <div className="card-profile">
                <form onSubmit={createInvite} className="profile-form">
                
                    <div className="form-group">
                        <label htmlFor="userFrom">{t("yourid.label")}</label>
                        <input
                            type="text"
                            id="userFrom"
                            placeholder={t("enteruserFrom.label")}
                            value={userFrom}
                            onChange={(e) => setUserFrom(e.target.value)}
                        />
                    </div>
                    
                    <div className="form-group">
                        <label htmlFor="userTo">{t("friendid.label")}</label>
                        <input
                            type="text"
                            id="userTo"
                            placeholder={t("enteruserTo.label")}
                            value={userTo}
                            onChange={(e) => setUserTo(e.target.value)}
                        />
                    </div>
                    
                    <button type="submit" className="btn btn-primary">{t("sendinv.label")}</button>
                    </form>
            </div>   
            <br></br> 
            <div className="card-profile">
                    <form onSubmit={accept} className="profile-form">
                    
                    <div className="form-group">
                        <label htmlFor="userTo">{t("yourid.label")}</label>
                        <input
                            type="text"
                            id="userFrom1"
                            placeholder={t("enteruserFrom.label")}
                            value={userFrom1}
                            onChange={(e) => setUserFrom1(e.target.value)}
                        />
                    </div>
                    
                    <div className="form-group">
                        <label htmlFor="userTo">{t("friendid.label")}</label>
                        <input
                            type="text"
                            id="userTo1"
                            placeholder={t("enteruserTo.label")}
                            value={userTo1}
                            onChange={(e) => setUserTo1(e.target.value)}
                        />
                    </div>
                    
                    <div className="form-group">
                        <label htmlFor="userTo">{t("acceptInvite.label")}</label>
                        <input
                            type="text"
                            id="bool"
                            placeholder={t("true.label")}
                            value={bool}
                            onChange={(e) => setBool(e.target.value)}
                        />
                    </div>
                    <button type="submit" className="btn btn-primary">{t("sendFriend.label")}</button>
                </form>
                </div>    
                </div>
                <Footer/>
            </div>
     );
}

export default Profile;
