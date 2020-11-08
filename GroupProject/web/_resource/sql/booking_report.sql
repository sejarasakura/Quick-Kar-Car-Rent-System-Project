SELECT 
b.booking_id,
(d.first_name || ' ' || d.last_name) as temp_driver_name, 
(c.first_name || ' ' || c.last_name) as temp_cust_name, 
Ca.car_plate_num, 
b.fetch_date,
b.booking_status,
p.pay_amount 
FROM BOOKING B, Payment P, Customer C, Driver D, Car Ca
WHERE 
B.payment_id = P.payment_id AND
B.cust_id = C.cust_id AND
B.driver_id = D.driver_id AND
B.driver_id = Ca.driver_id AND
day(b.booking_date) = ? AND
month(b.booking_date) = ? AND
year(b.booking_date) = ? 