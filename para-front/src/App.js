import { BrowserRouter,Routes,Route } from "react-router-dom";
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