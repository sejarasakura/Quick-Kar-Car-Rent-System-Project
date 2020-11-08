SELECT *
FROM(
    SELECT 
        c.cust_id as temp_cust_id, 
        (c.first_name || ' ' || c.last_name) as temp_cust_name, 
        r.rating_star as temp_rating_star, 
        r.cust_comments as temp_cust_comments, 
        r.rating_datetime as temp_rating_datetime,
        b.driver_id as temp_driver_id
    FROM Driver D, Booking B, Customer C, Rating R 
    WHERE D.driver_id = B.driver_id AND
        B.cust_id = C.cust_id AND 
        R.rating_id = B.rating_id
) AS TEMP WHERE temp_driver_id = ?