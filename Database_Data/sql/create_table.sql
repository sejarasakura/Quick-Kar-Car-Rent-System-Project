CREATE TABLE QuicKarAdmin.Rating (
    rating_id varchar(9),
    rating_star varchar(2),
    cust_comments varchar(100),
    rating_datetime timestamp NOT NULL,
    PRIMARY KEY (rating_id) 
);

CREATE TABLE QuicKarAdmin.CarType (
    car_type_id varchar(8),
    car_series_name varchar(20) NOT NULL,
    cust_capacity integer NOT NULL,
    PRIMARY KEY (car_type_id) 
);

CREATE TABLE QuicKarAdmin.Customer (
    cust_id varchar(11),
    first_name varchar(20),
    last_name varchar(20),
    phone_num varchar(13) NOT NULL,
    password varchar(30) NOT NULL,
    ic_num varchar(14) NOT NULL,
    proc_pic blob(2M),
    point_amount integer,
    membership_level varchar(2) NOT NULL,
    PRIMARY KEY (cust_id)
);

CREATE TABLE QuicKarAdmin.Driver (
    driver_id varchar(8),
    first_name varchar(20),
    last_name varchar(20),
    phone_num varchar(13) NOT NULL,
    password varchar(30) NOT NULL,
	proc_pic blob(2M),
    ic_num varchar(14),
    license varchar(8) NOT NULL,
    year_of_drive integer,
    PRIMARY KEY (driver_id)
);

CREATE TABLE QuicKarAdmin.Payment_method (
    pay_method_id varchar(15),
    user_id varchar(11) NOT NULL,
    payment_method varchar(2) NOT NULL,
    card_num varchar (20),
    PRIMARY KEY(pay_method_id) 
);

CREATE TABLE QuicKarAdmin.Payment (
    payment_id varchar(19),
    payment_method varchar(15) NOT NULL,
    payment_status varchar(2),
    payment_date timestamp NOT NULL,
	pay_amount double,
    PRIMARY KEY(payment_id),
    FOREIGN KEY(payment_method) REFERENCES Payment_method(pay_method_id)
);

CREATE TABLE QuicKarAdmin.Car (
    car_plate_num varchar(8),
    car_type_id varchar(8) NOT NULL,
    owner_name varchar(20) NOT NULL,
    quickar_type varchar(2) NOT NULL,
    driver_id varchar(8) NOT NULL,
    PRIMARY KEY(car_plate_num),
    FOREIGN KEY(car_type_id) REFERENCES CarType(car_type_id),
    FOREIGN KEY(driver_id) REFERENCES Driver(driver_id)
);

CREATE TABLE QuicKarAdmin.Booking (
    booking_id varchar(18),
    rating_id varchar(9),
    cust_id varchar(11) NOT NULL,
    driver_id varchar(8) NOT NULL,
    payment_id varchar(19),
    booking_date timestamp NOT NULL,
    fetch_date timestamp,
    booking_status varchar(1),
    start_location_code varchar(10) NOT NULL,
    end_location_code varchar(10) NOT NULL,
    PRIMARY KEY(booking_id),
    FOREIGN KEY(rating_id) REFERENCES Rating(rating_id),
    FOREIGN KEY(cust_id) REFERENCES Customer(cust_id),
    FOREIGN KEY(driver_id) REFERENCES Driver(driver_id),
    FOREIGN KEY(payment_id) REFERENCES Payment(payment_id)
);
