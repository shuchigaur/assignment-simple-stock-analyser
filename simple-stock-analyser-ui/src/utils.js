
export function getData(type, startDate, endDate) {

	var url = 'http://localhost:8080/indexSummary?'

	if (type != null) {
		url = url + 'type=' + type
	}

	if (startDate != null) {
		url = url + '&startDate=' + startDate
	}

	if (endDate != null) {
		url = url + '&endDate=' + endDate
	}
	console.log(startDate);
	console.log(endDate);
	console.log(url);

	const promiseStocks = fetch(url)
		.then(response => response.json())
		.then(data => data.reduce((i, j) => {
			(i[j.type] = i[j.type] || []).push(j);
			return i;
		}, {}));

	return promiseStocks;
}

export const divStyle = {
	margin: 20,
	padding: 40,
	border: '1px solid #DDD'
}
