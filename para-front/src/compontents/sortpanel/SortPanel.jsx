import React, { useState } from 'react';
import './SortPanel.css';

const SortPanel = ({ onGenreChange, onMaxPriceChange, onSearch }) => {
    const [sliderValue, setSliderValue] = useState(1000);

    const handleSliderChange = (value) => {
        setSliderValue(value);
        onMaxPriceChange(value);
    };
    return (
        <div className="sort-panel">
            <input
                type="text"
                placeholder="Search by title..."
                onChange={e => onSearch(e.target.value)}
                className="search-bar"
            />
            <select onChange={e => onGenreChange(e.target.value)} className="genre-select">
                <option value="">Select Genre</option>
                <option value="Action">Action</option>
                <option value="Adventure">Adventure</option>
                <option value="Base building">Base building</option>
                <option value="City building">City building</option>
                <option value="FPS">FPS</option>
                <option value="Idle">Idle</option>
                <option value="RPG">RPG</option>
                <option value="Simulation">Simulation</option>
                <option value="Sports">Sports & Racing</option>
                <option value="Strategy">Strategy</option>
                <option value="Survival">Survival</option>
            </select>
            <div className="price-slider-container">
                <label htmlFor="price-slider">Max Price: {sliderValue}$</label>
                <input
                    type="range"
                    id="price-slider"
                    min="0"
                    max="1000"
                    value={sliderValue}
                    onChange={e => handleSliderChange(e.target.value)}
                />
                <input
                    type="number"
                    className="price-input"
                    value={sliderValue}
                    onChange={e => handleSliderChange(e.target.value)}
                    min="0"
                    max="1000"
                />
            </div>
        </div>
    );
};

export default SortPanel;