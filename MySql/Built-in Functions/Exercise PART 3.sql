-- 12. Games from 2011 and 2012 Year

SELECT name, DATE_FORMAT(start, '%Y-%m-%d') AS start FROM  games
WHERE EXTRACT(YEAR FROM start) IN (2011,2012)
ORDER BY start
LIMIT 50;

-- 13. User Email Providers

SELECT user_name, SUBSTRING(email, LOCATE('@', email) + 1) AS 'email provider' FROM users 
ORDER BY `email provider`;

-- 14. Get Users with IP Address Like Pattern

SELECT user_name, ip_address FROM users AS u
WHERE ip_address LIKE '___.1%.%.___'
ORDER BY user_name;

-- 15. Show All Games with Duration and Part of the Day

SELECT name AS 'game', IF(EXTRACT(HOUR FROM start) >= 0 AND EXTRACT(HOUR FROM start) < 12, 'Morning',
						IF(EXTRACT(HOUR FROM start) >= 12 AND EXTRACT(HOUR FROM start) < 18, 'Afternoon', 'Evening')) AS 'Part og the day',
                        IF(duration <= 3, 'Extra Short', 
                        IF(duration > 3 AND duration <= 6, 'Short',
                        IF(duration > 6 AND duration <= 10, 'Long', 'Extra Long'))) AS 'Duration' FROM games;

