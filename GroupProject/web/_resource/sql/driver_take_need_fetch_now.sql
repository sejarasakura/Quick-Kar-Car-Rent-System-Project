SELECT *
FROM(
    SELECT 
        c.cust_id as temp_cust_id, 
        (c.first_name || ' ' || c.last_name) as temp_cust_name, 
        c.phone_num, 
        c.membership_level, 
        b.fetch_date as temp_fetch_date, 
        b.start_location_code,
        b.end_location_code
    FROM Driver D, Booking B, Customer C
    WHERE D.driver_id = B.driver_id AND
        B.cust_id = C.cust_id
) AS TEMP WHERE temp_fetch_date >= CURRENT_TIMESTAMP