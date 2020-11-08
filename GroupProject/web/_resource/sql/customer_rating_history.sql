SELECT *
FROM(
    SELECT 
        d.driver_id as temp_driver_id, 
        (d.first_name || ' ' || d.last_name) as temp_driver_name, 
        r.rating_star as temp_rating_star, 
        r.cust_comments as temp_cust_comments, 
        r.rating_datetime as temp_rating_datetime,
        r.rating_id as temp_rating_id,
        p.pay_amount as temp_7,
        p.payment_status as temp_8,
        c.cust_id as temp_cust_id
    FROM Driver D, Booking B, Customer C, Rating R, Payment P
    WHERE D.driver_id = B.driver_id AND
        B.cust_id = C.cust_id AND 
        R.rating_id = B.rating_id AND
        P.payment_id = B.payment_id
) AS TEMP WHERE temp_cust_id = ? 