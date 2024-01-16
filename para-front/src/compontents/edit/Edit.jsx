import axios from "axios";
import {useState} from "react";
import {useNavigate} from "react-router-dom";

function Edit(){
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [price, setPrice] = useState("");
    const [genres, setGenres] = useState("");
    const [id, setId] = useState("");

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
                alert("Added game");
            }, fail => {
                console.error(fail); // Error!
                alert("KEK");
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
                alert("Deleted game");
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
                    <h2>Add Game</h2>
                    <hr/>
                </div>

                <div className="row">
                    <div className="col-sm-6">

                        <form>
                            <div className="form-group">
                                <label>Title</label>
                                <input type="text"  className="form-control" id="title" placeholder="Enter title"
                                       value={title}
                                       onChange={(event) => {
                                           setTitle(event.target.value);
                                       }}
                                />
                            </div>
                            <div className="form-group">
                                <label>Description</label>
                                <input type="text" className="form-control" id="description" placeholder="Enter description"
                                       value={description}
                                       onChange={(event) => {
                                           setDescription(event.target.value);
                                       }}
                                />
                            </div>
                            <div className="form-group">
                                <label>Price</label>
                                <input type="number" className="form-control" id="price" placeholder="Enter price"
                                       value={price}
                                       onChange={(event) => {
                                           setPrice(event.target.value);
                                       }}
                                />
                            </div>
                            <div className="form-group">
                                <label>Genres</label>
                                <input type="text" className="form-control" id="genres" placeholder="Enter genres"
                                       value={genres}
                                       onChange={(event) => {
                                           setGenres(event.target.value);
                                       }}
                                />
                            </div>
                            <button type="submit" className="btn btn-primary" onClick={addGame} >Add</button>
                        </form>
                        <h2>Delete Game</h2>
                        <form>
                            <div className="form-group">
                                <label>Id</label>
                                <input type="text" className="form-control" id="id" placeholder="Enter id"
                                       value={id}
                                       onChange={(event) => {
                                           setId(event.target.value);
                                       }}
                                />
                            </div>
                            <button type="submit" className="btn btn-primary" onClick={delGame}>Delete</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    );
}
export default Edit;