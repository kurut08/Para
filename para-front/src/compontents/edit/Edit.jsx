import axios from "axios";
import {useState} from "react";
import {useNavigate} from "react-router-dom";
import { useTranslation } from "react-i18next";
import {Toggle} from '../toggle/Toggle';
import {Footer} from '../footer/Footer';
import './Edit.css';

function Edit(){
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [price, setPrice] = useState("");
    const [genres, setGenres] = useState("");
    const [id, setId] = useState("");
    const { t, i18n } = useTranslation();
    const navigate = useNavigate();

    async function addGame(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8080/auth/addGame", {
                title: title,
                description: description,
                price: price,
                genres: genres
            }).then((res) =>
            {
                alert(t("gameAdded.label"));
            }, fail => {
                console.error(fail); // Error!
                alert(t("gameAddingError.label"));
            });
        }
        catch (err) {
            console.log(err);
            alert(err);
        }
    }

    async function delGame(event) {
        event.preventDefault();
        try {
            console.log(id);
            await axios.post("http://localhost:8080/auth/deleteGame/"+ id, {mode:'cors'}).then((res) =>
            {
                alert(t("gameDeleted.label"));
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
            <div className="edit-container">
                <div className="logo-container">
                    <div onClick={navigateToHome}>
                        <img src="/path/to/your/logo.png" alt="App Logo" className="app-logo"/>
                    </div>
                    <div className="switch-container">
                        <Toggle/>
                    </div>
                </div>
                <div className="edit-main">
                    <div className="edit-card">
                        <h1>{t("addGame.label")}</h1>
                        <form>
                            <div className="form-group">
                                <label>{t("title.label")}</label>
                                <input type="text" className="form-control" id="title"
                                       placeholder={t("enterTitle.label")}
                                       value={title}
                                       onChange={(event) => {
                                           setTitle(event.target.value);
                                       }}
                                />
                            </div>
                            <div className="form-group">
                                <label>{t("description.label")}</label>
                                <input type="text" className="form-control" id="description"
                                       placeholder={t("enterDescription.label")}
                                       value={description}
                                       onChange={(event) => {
                                           setDescription(event.target.value);
                                       }}
                                />
                            </div>
                            <div className="form-group">
                                <label>{t("price.label")}</label>
                                <input type="number" className="form-control" id="price"
                                       placeholder={t("enterPrice.label")}
                                       value={price}
                                       onChange={(event) => {
                                           setPrice(event.target.value);
                                       }}
                                />
                            </div>
                            <div className="form-group">
                                <label>{t("genre.label")}</label>
                                <input type="text" className="form-control" id="genres"
                                       placeholder={t("enterGenre.label")}
                                       value={genres}
                                       onChange={(event) => {
                                           setGenres(event.target.value);
                                       }}
                                />
                            </div>
                            <button type="submit" className="btn btn-primary"
                                    onClick={addGame}>{t("add.label")}</button>
                        </form>
                        <h2>{t("deleteGame.label")}</h2>
                        <form>
                            <div className="form-group">
                                <label>{t("id.label")}</label>
                                <input type="text" className="form-control" id="id" placeholder={t("enterId.label")}
                                       value={id}
                                       onChange={(event) => {
                                           setId(event.target.value);
                                       }}
                                />
                            </div>
                            <button type="submit" className="btn btn-primary"
                                    onClick={delGame}>{t("delete.label")}</button>
                        </form>
                    </div>
                </div>
                <Footer/>
            </div>

    );
}

export default Edit;