SELECT *
FROM(
    SELECT c.cust_id as temp_cust_id,
        (c.first_name || ' ' || c.last_name) as temp_cust_name, 
        COUNT(P.pay_amount) as temp_total_booking,
        AVG(P.pay_amount) as temp_avg_payment,
        SUM(P.pay_amount) as temp_pay_amount
    FROM Booking B, Customer C, Payment P, Rating R
    WHERE 
        B.cust_id = C.cust_id AND 
        B.payment_id = P.payment_id AND
        R.rating_id = B.rating_id AND 
        MONTH(P.payment_date) = ? AND 
        YEAR(P.payment_date) = ? 
        GROUP BY C.cust_id, C.first_name, C.last_name
) AS TEMP ORDER BY temp_pay_amount desc