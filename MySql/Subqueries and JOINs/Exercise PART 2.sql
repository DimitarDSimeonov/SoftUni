-- 12. Highest Peaks in Bulgaria

SELECT c.country_code, m.mountain_range, p.peak_name, p.elevation FROM countries AS c
JOIN mountains_countries AS mc ON c.country_code = mc.country_code
JOIN mountains AS m ON mc.mountain_id = m.id
JOIN peaks AS p ON m.id = p.mountain_id
WHERE c.country_name = 'Bulgaria' AND p.elevation > 2835
ORDER BY p.elevation DESC;

-- 13. Count Mountain Ranges

SELECT c.country_code, COUNT(mc.mountain_id) AS mountain_range FROM countries AS c
JOIN mountains_countries AS mc ON mc.country_code = c.country_code
WHERE c.country_name IN ('Bulgaria', 'Russia', 'United States')
GROUP BY c.country_code
ORDER BY mountain_range DESC;

-- 14. Countries with Rivers

SELECT c.country_name, r.river_name FROM countries AS c
LEFT JOIN countries_rivers AS cr ON c.country_code = cr.country_code
LEFT JOIN rivers AS r ON cr.river_id = r.id
JOIN continents AS con ON c.continent_code = con.continent_code
WHERE con.continent_name = 'Africa'
ORDER BY c.country_name
LIMIT 5;

-- 16. Countries Without Any Mountains

SELECT COUNT(c.country_code) AS country_count  FROM countries AS c 
LEFT JOIN mountains_countries AS mc ON c.country_code = mc.country_code
WHERE mountain_id IS NULL;

-- 17. Highest Peak and Longest River by Country

SELECT c.country_name, MAX(p.elevation) AS highest_peak_elevation, MAX(r.length) AS highest_peak_elevation FROM countries AS c
LEFT JOIN countries_rivers AS cr ON c.country_code = cr.country_code
JOIN rivers AS r ON cr.river_id = r.id
LEFT JOIN mountains_countries AS mc ON mc.country_code = c.country_code
JOIN mountains AS m ON mc.mountain_id = m.id
JOIN peaks AS p ON p.mountain_id = m.id
GROUP BY c.country_name
ORDER BY highest_peak_elevation DESC, highest_peak_elevation DESC, c.country_name
LIMIT 5;
