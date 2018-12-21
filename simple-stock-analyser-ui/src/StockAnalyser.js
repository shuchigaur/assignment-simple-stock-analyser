import React, { Component } from 'react';
import moment from 'moment';
import { getData, divStyle } from './utils';
import { HorizontalGridLines, LineSeries, XAxis, XYPlot, YAxis, DiscreteColorLegend } from 'react-vis';
import 'react-vis/dist/style.css';


class StockAnalyser extends Component {
	constructor (props) {
		super(props);

		this.state = {

		};

		this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleChange(e) {
		this.setState({
			...this.state,
			[e.target.name]: e.target.value
		});
	}

	handleSubmit() {
		getData('BSE & DJI' === this.state.indexType ? null : this.state.indexType,
			this.state.startDate,
			this.state.endDate)
		.then(data => {
			this.setState({
				...this.state,
				data: data
			})
		});
	}


	render() {
		return (
			<div style={divStyle}>
				<h1>Simple Stock Analyser</h1>
				<table>
					<tbody>
						<tr>
							<th>Index Name</th>
							<th>Start Date</th>
							<th>End Date</th>
						</tr>

						<tr>
							<td>
								<select
									name="indexType"
									value={this.state.indexType}
									onChange={this.handleChange}>
										<option value="BSE & DJI">BSE & DJI</option>
										<option value="BSE">BSE</option>
										<option value="DJI">DJI</option>
								</select>
							</td>

							<td>
								<input
									type="date"
									name="startDate"
									onChange={this.handleChange} />
							</td>

							<td>
							<input
								type="date"
								name="endDate"
								onChange={this.handleChange} />
							</td>

							<td>
								<button className="square"
									onClick={this.handleSubmit}>
									Go
								</button>
							</td>
						</tr>
					</tbody>
				</table>

				{this.state.data &&
					<XYPlot
						width={1200}
						height={550}
						xType='time'
						getX={d => d.date}
						getY={d => d.close}
						margin={{left: 50, bottom: 60}} >
							<HorizontalGridLines/>
							<DiscreteColorLegend
								orientation='horizontal'
								items={Object.keys(this.state.data)} >
							</DiscreteColorLegend>
							<XAxis
								title="Time"
								tickFormat={d => moment(d).format("D MMM YYYY")}
								tickLabelAngle={-45} />
							<YAxis title="Closing Points" />
							{Object.keys(this.state.data).map((i) => (
								<LineSeries	key={i} data={this.state.data[i]} >
								</LineSeries>
							))}
					</XYPlot>
				}
			</div>
		);
	}
}

export default StockAnalyser;
