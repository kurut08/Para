import React, { useState } from 'react';
import './SortPanel.css';
import { useTranslation } from "react-i18next";

const SortPanel = ({ onGenreChange, onMaxPriceChange, onSearch }) => {
    const [sliderValue, setSliderValue] = useState(200);
    const { t, i18n } = useTranslation();

    const handleSliderChange = (event) => {
        const value = event.target.valueAsNumber || event.target.value;
        setSliderValue(value);
        onMaxPriceChange(value);
    };
    return (
        <div className="sort-panel">
            <input
                type="text"
                placeholder={t("searchByTitle.label")}
                onChange={e => onSearch(e.target.value)}
                className="search-bar"
            />
            <select onChange={e => onGenreChange(e.target.value)} className="genre-select">
                <option value="">{t("selectGenre.label")}</option>
                <option value="Action">{t("actionGenre.label")}</option>
                <option value="Adventure">{t("adventureGenre.label")}</option>
                <option value="Base building">{t("baseBuildingGenre.label")}</option>
                <option value="City building">{t("cityBuilderGenre.label")}</option>
                <option value="FPS">{t("fpsGenre.label")}</option>
                <option value="Idle">{t("idleGenre.label")}</option>
                <option value="RPG">{t("rpgGenre.label")}</option>
                <option value="Simulation">{t("simulationGenre.label")}</option>
                <option value="Sports">{t("sportsRacingGenre.label")}</option>
                <option value="Strategy">{t("strategyGenre.label")}</option>
                <option value="Survival">{t("survivalGenre.label")}</option>
            </select>
            <div className="price-slider-container">
                <label htmlFor="price-slider" className="price-label">{t("maxPrice.label")}: {sliderValue}$</label>
                <input
                    type="range"
                    id="price-slider"
                    min="0"
                    max="200"
                    value={sliderValue}
                    onChange={handleSliderChange}
                />
            </div>
        </div>
    );
};

export default SortPanel;