# assignment-simple-stock-analyser
A simple java API and react UI to host a stock analyser

Testing instructions:
Download or clone: https://github.com/shuchigaur/assignment-simple-stock-analyser/

Java API component:
a. Requires Itellij Idea v2018.x
b. Database: H2
    -- the DB will be setup and loaded with BSE SENSEX and DJI Industrial average history data from 10-Dec-2013 to 10-Dec-2018 on server    start
    -- the currency difference between the two indices has been ignored for simplicity (data has been taken as-is)
 c. simple-stock-analyser-UI is assumed to be the only consumer of the API, meaning that the input formats are controlled by the UI
 d. http://localhost:3000/ has been explicitly added as an allowed cross origin to facilitate testing

1. Open Intellij --> Go to 'File' --> 'Open' --> browse to 'assignment-simple-stock-analyser/stock-history/pom.xml' --> 'Open as project' to load the project
2. Go to Maven Projects -> clean --> install ==> all tests should be successful
3. Go to Run --> Edit Configuration --> click on '+' --> Select Application --> Enter a Name of your choice --> Set 'com.assignment.stockhistory.StockHistoryApplication' as Main Class --> click on 'Apply' --> Click on 'Ok'
4. Run the application server
5. Open http://localhost:8080/indexSummary to test the APIs response

React UI Component:
a. Rquires create-react-app
b. User input annotations of time-windows is not yet implemented
c. If no inputs are selected, the graph is rendered for all the data available for both BSE and DJI 

1. Open 'Powershell'
2. cd to assignment-simple-stock-analyser/simple-stock-analyser-ui
3. run npm install
4. run npm start ==> this will launch http://localhost:3000/ a new browser window
5. Select the desired inputs and click on 'Go' to render the graph
