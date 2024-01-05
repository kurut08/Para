import { BrowserRouter,Routes,Route } from "react-router-dom";
import api from './api/axiosConfig';
import Header from './compontents/Header';
import Register from "./compontents/Register";
import Login from "./compontents/Login";
import Home from "./compontents/Home";
import Verify from "./compontents/Verify";
import Shop from "./compontents/Shop";
import Library from "./compontents/Library";
import Profile from "./compontents/Profile";
import Edit from "./compontents/Edit";


function App() {
  return (

      <div className="App">

          <BrowserRouter>
          <Routes>
              <Route path="/verify" element= { <Verify/>} />
              <Route path="/" element= { <Home/>} />//NON-LOGIN
              <Route path="/register" element= { <Register/>} />
              <Route path="/login" element= { <Login/>} />
              <Route path="/shop" exact element={ <Shop/>} />//USER
              <Route path="/lib" element={ <Library/>} />//USER
              <Route path="/profile" element={ <Profile/>} />//USER
              <Route path="/edit" element={ <Edit/>} /> //ADMIN
          </Routes>
          </BrowserRouter>
      </div>
  );
}

export default App;