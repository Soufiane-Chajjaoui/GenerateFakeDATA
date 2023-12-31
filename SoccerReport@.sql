SELECT c.customer_code, COUNT(*) AS totalTransactions, SUM(t.sales_amount * t.sales_qty) AS totalSales
FROM customers AS c
 JOIN transactions AS t ON c.customer_code = t.customer_code WHERE t.currency = "INR"
GROUP BY c.customer_code;


SELECT COUNT(*) FROM products ;

SELECT SUM(transactions.sales_qty) AS revenue FROM transactions;


SELECT DISTINCT(YEAR(transactions.order_date)) AS od , count(*) as nb_transactions from date AS d JOIN transactions ON 
 
d.date = transactions.order_date

GROUP BY od ;
 soccerreport
CREATE TABLE FootballMatch (
    idMatch INT PRIMARY KEY,
    HomeTeam INT,
    AwayTeam INT,
    StadiumID INT,
    Attendance INT,
    RefereeID INT,
    DateID INT,
    GoalsHome INT,
    GoalsAway INT,
    FOREIGN KEY (HomeTeam) REFERENCES Team(TeamID),
    FOREIGN KEY (AwayTeam) REFERENCES Team(TeamID),
    FOREIGN KEY (StadiumID) REFERENCES Stadium(StadiumID),
    FOREIGN KEY footballmatch(RefereeID) REFERENCES Referee(RefereeID),
    FOREIGN KEY (DateID) REFERENCES DateMatch(DateID)
);

	SELECT COUNT(*) AS numberOfMatchWinned  , team.TeamName
	FROM footballmatch  JOIN team ON footballmatch.HomeTeam = team.TeamID
	GROUP BY team.TeamName;
	
	SELECT
    COUNT(CASE WHEN footballmatch.GoalsHome > footballmatch.GoalsAway THEN 1 END) AS numberOfMatch,
    team.TeamName
	FROM
	    footballmatch
	JOIN
	    team ON footballmatch.HomeTeam = team.TeamID
	GROUP BY
	    team.TeamName;
	    
	    
	    
	SELECT
	    team.TeamName,
	    COUNT(*) AS numberofWins
	FROM
	    team
	JOIN
	    footballmatch ON team.TeamID = footballmatch.HomeTeam
	WHERE
	    footballmatch.GoalsHome > footballmatch.GoalsAway
	GROUP BY
	    team.TeamName;
 



