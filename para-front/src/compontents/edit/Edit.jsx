import axios from "axios";
import {useState} from "react";
import {useNavigate} from "react-router-dom";
import { useTranslation } from "react-i18next";

function Edit(){
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [price, setPrice] = useState("");
    const [genres, setGenres] = useState("");
    const [id, setId] = useState("");
    const { t, i18n } = useTranslation();

    async function addGame(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8080/auth/addgame", {
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
            await axios.post("http://localhost:8080/auth/delgame"+{id}, {mode:'cors'}).then((res) =>
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
    return (
        <div>
            <div className="container">
                <div className="row">
                    <h2>{t("addGame.label")}</h2>
                    <hr/>
                </div>

                <div className="row">
                    <div className="col-sm-6">

                        <form>
                            <div className="form-group">
                                <label>{t("title.label")}</label>
                                <input type="text"  className="form-control" id="title" placeholder={t("enterTitle.label")}
                                       value={title}
                                       onChange={(event) => {
                                           setTitle(event.target.value);
                                       }}
                                />
                            </div>
                            <div className="form-group">
                                <label>{t("description.label")}</label>
                                <input type="text" className="form-control" id="description" placeholder={t("enterDescription.label")}
                                       value={description}
                                       onChange={(event) => {
                                           setDescription(event.target.value);
                                       }}
                                />
                            </div>
                            <div className="form-group">
                                <label>{t("price.label")}</label>
                                <input type="number" className="form-control" id="price" placeholder={t("enterPrice.label")}
                                       value={price}
                                       onChange={(event) => {
                                           setPrice(event.target.value);
                                       }}
                                />
                            </div>
                            <div className="form-group">
                                <label>{t("genre.label")}</label>
                                <input type="text" className="form-control" id="genres" placeholder={t("enterGenre.label")}
                                       value={genres}
                                       onChange={(event) => {
                                           setGenres(event.target.value);
                                       }}
                                />
                            </div>
                            <button type="submit" className="btn btn-primary" onClick={addGame} >{t("add.label")}</button>
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
                            <button type="submit" className="btn btn-primary" onClick={delGame}>{t("delete.label")}</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    );
}
export default Edit;