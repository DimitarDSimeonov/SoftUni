-- 10. Countries Holding 'A' 3 or More Times

SELECT country_name, iso_code FROM countries AS c
WHERE UPPER(c.country_name) LIKE '%A%A%A%'
ORDER BY c.iso_code;

-- 11. Mix of Peak and River Names

SELECT peak_name, river_name, LOWER(CONCAT(p.peak_name, SUBSTRING(r.river_name, 2))) AS 'mix' FROM peaks AS p, rivers AS r
WHERE RIGHT(p.peak_name, 1) = LEFT(r.river_name, 1)
ORDER BY mix;
