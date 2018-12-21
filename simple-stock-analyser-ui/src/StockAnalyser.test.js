import React from 'react';
import ReactDOM from 'react-dom';
import StockAnalyser from './StockAnalyser';

it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<StockAnalyser />, div);
  ReactDOM.unmountComponentAtNode(div);
});
