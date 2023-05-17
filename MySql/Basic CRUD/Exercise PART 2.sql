-- 21. All Mountain Peaks

SELECT peak_name FROM peaks AS p
ORDER BY p.peak_name ASC;

-- 22. Biggest Countries by Population

SELECT country_name, population FROM countries AS c
WHERE c.continent_code = 'EU'
ORDER BY c.population DESC;

-- 23. Countries and Currency (Euro / Not Euro)

SELECT country_name, country_code,IF (currency_code = 'EUR', 'Euro', 'Not Euro') AS currency FROM countries AS c
ORDER BY c.country_name ASC;