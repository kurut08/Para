import React, { useState } from 'react';
import Box from '@mui/material/Box';
import Slider from '@mui/material/Slider';
import './PriceRangeBar.css';
function valuetext(value) {
    return `${value}$`;
}
export const PriceRangeBar = () =>{
    const [value, setValue] = React.useState([0, 2000]);

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    return (
        <div className="box">
            <Slider
                getAriaLabel={() => 'Temperature range'}
                value={value}
                min={0}
                max={2000}
                onChange={handleChange}
                valueLabelDisplay="auto"
                getAriaValueText={valuetext}
            />
        </div>
    );
};
