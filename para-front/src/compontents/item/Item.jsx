import './Item.css';
import Carousel from 'react-material-ui-carousel';
import { Paper } from '@mui/material';

const Item = ({games}) => {
    return (
        <div className ='movie-carousel-container'>
            <Carousel>
                {
                    games?.map((game) =>{
                        return(
                            <Paper key={game.id}>
                                <div className = 'game-card-container'>
                                    <div className="game-card" style={{"--img": `url(${game.backdrops[0]})`}}>
                                        <div className="game-detail">
                                            <div className="game-poster">
                                                <img src={game.poster} alt="" />
                                            </div>
                                            <div className="game-title">
                                                <h4>{game.title}</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </Paper>
                        )
                    })
                }
            </Carousel>
        </div>
    )
}

export default Item