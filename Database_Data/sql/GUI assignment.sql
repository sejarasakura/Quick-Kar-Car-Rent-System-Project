CREATE TABLE Rating (
    rating_id varchar(9),
    rating_star varchar(2),
    cust_comments varchar(100),
    rating_datetime timestamp NOT NULL,
    PRIMARY KEY (rating_id) 
);

CREATE TABLE Location (
    location_code varchar(10),
    x_longtitude double,
    y_latitude double,
    location_name varchar(40),
    address varchar(255),
    PRIMARY KEY (location_code)
);

CREATE TABLE CarType (
    car_type_id varchar(8),
    car_series_name varchar(20) NOT NULL,
    cust_capacity integer NOT NULL,
    PRIMARY KEY (car_type_id) 
);

CREATE TABLE Customer (
    cust_id varchar(10),
    first_name varchar(20),
    last_name varchar(20),
    phone_num varchar(13) NOT NULL,
    ic_num varchar(14) NOT NULL,
    point_amount integer,
    membership_level varchar(2) NOT NULL,
    proc_pic blob(2M),
    PRIMARY KEY (cust_id)
);

CREATE TABLE Driver (
    driver_id varchar(8),
    first_name varchar(20),
    last_name varchar(20),
    phone_num varchar(13) NOT NULL,
    ic_num varchar(14),
    license varchar(8) NOT NULL,
    year_of_drive integer,
    proc_pic blob(2M),
    PRIMARY KEY (driver_id)
);

CREATE TABLE Payment_method (
    pay_method_id varchar(14),
    user_id varchar(10) NOT NULL,
    payment_method varchar(2) NOT NULL,
    card_num varchar (20),
    pay_amount double, 
    PRIMARY KEY(pay_method_id) 
);

CREATE TABLE Payment (
    payment_id varchar(18),
    payment_method varchar(14) NOT NULL,
    payment_status varchar(2),
    payment_date timestamp NOT NULL,
    PRIMARY KEY(payment_id),
    FOREIGN KEY(payment_method) REFERENCES Payment_method(pay_method_id)
);

CREATE TABLE Car (
    car_plate_num varchar(8),
    car_type_id varchar(8) NOT NULL,
    owner_name varchar(20) NOT NULL,
    quickar_type varchar(2) NOT NULL,
    driver_id varchar(8) NOT NULL,
    PRIMARY KEY(car_plate_num),
    FOREIGN KEY(car_type_id) REFERENCES CarType(car_type_id),
    FOREIGN KEY(driver_id) REFERENCES Driver(driver_id)
);

CREATE TABLE Booking (
    booking_id varchar(18),
    rating_id varchar(9),
    cust_id varchar(10) NOT NULL,
    driver_id varchar(8) NOT NULL,
    payment_id varchar(18),
    booking_date timestamp NOT NULL,
    fetch_date timestamp,
    booking_status varchar(1),
    start_location_code varchar(10) NOT NULL,
    end_location_code varchar(10) NOT NULL,
    PRIMARY KEY(booking_id),
    FOREIGN KEY(rating_id) REFERENCES Rating(rating_id),
    FOREIGN KEY(cust_id) REFERENCES Customer(cust_id),
    FOREIGN KEY(driver_id) REFERENCES Driver(driver_id),
    FOREIGN KEY(payment_id) REFERENCES Payment(payment_id),
    FOREIGN KEY(start_location_code) REFERENCES Location(location_code),
    FOREIGN KEY(end_location_code) REFERENCES Location(location_code)
);

INSERT INTO Rating(rating_id, rating_star, cust_comments, rating_datetime)
VALUES (?,?,?,?);

INSERT INTO Location(location_code, point, location_name)
VALUES (?,?,?);

INSERT INTO CarType(car_type_id, car_series_name, cust_capacity)
VALUES (?,?,?);

INSERT INTO Customer(Cust_id, first_name, last_name, phone_num, ic_num, point_amount, membership_level, proc_pic)
VALUES (?,?,?,?,?,?,?,?);

INSERT INTO Payment_method(pay_method_id, user_id, payment_method, card_num, pay_amount)
VALUES (?,?,?,?,?);

INSERT INTO Payment(payment_id, payment_method, payment_status, payment_date)
VALUES(?,?,?,?);

INSERT INTO Driver(driver_id, first_name, last_name, phone_num, ic_num, license, year_of_drive, proc_pic)
VALUES(?,?,?,?,?,?,?,?);

INSERT INTO Car(car_plate_num, car_type_id, owner_name, quickar_type, driver_id)
VALUES(?,?,?,?,?);

INSERT INTO Booking(booking_id, rating_id, cust_id, driver_id, payment_id, booking_date, fetch_date, booking_status, start_location_code, end_location_code)
VALUES(?,?,?,?,?,?,?,?,?,?);