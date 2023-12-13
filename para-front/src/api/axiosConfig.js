import axios from 'axios';

export default axios.create({
    baseURL: 'https://9c96-103-106-239-104.ap.ngrok.io/',
    headers: {"ngrok-skip-browser-warning": "true"}
});

//https://youtu.be/5PdEmeopJVQ?t=6767&si=8Gf8j2qveJso32Dp
//1:52:47 create home and hero component