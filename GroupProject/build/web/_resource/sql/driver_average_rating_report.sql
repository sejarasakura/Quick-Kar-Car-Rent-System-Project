SELECT 
d.driver_id as temp_driver_id, 
(d.first_name || ' ' || d.last_name) as temp_driver_name, 
d.phone_num as temp_phone_num,
d.year_of_drive as temp_year_of_drive,
COUNT(number_rating_star) as temp_fetch,
SUM(number_rating_star) as total_rating_star, 
AVG(number_rating_star) as avg_rating_star
FROM(
SELECT case 
    WHEN R.rating_star = 'SS' then 0 
    WHEN R.rating_star = 'S0' then 0.5 
    WHEN R.rating_star = 'S1' then 1.0 
    WHEN R.rating_star = 'S2' then 1.5 
    WHEN R.rating_star = 'S3' then 2.0 
    WHEN R.rating_star = 'S4' then 2.5 
    WHEN R.rating_star = 'S5' then 3.0 
    WHEN R.rating_star = 'S6' then 3.5 
    WHEN R.rating_star = 'S7' then 4.0 
    WHEN R.rating_star = 'S8' then 4.5
    WHEN R.rating_star = 'S9' then 5.0 
    end as number_rating_star, 
    R.rating_id as temp_rating_id, 
    R.rating_datetime as temp_rating_datetime
    FROM Rating R
) as TempRating, Driver D, Booking B 
WHERE temp_rating_id = B.rating_id AND D.driver_id = B.driver_id
GROUP BY d.last_name, d.first_name, d.driver_id, d.phone_num, d.year_of_drive, d.license 
ORDER BY total_rating_star DESC