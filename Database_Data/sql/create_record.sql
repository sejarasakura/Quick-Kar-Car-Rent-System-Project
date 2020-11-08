
/*====================== Rating =====================*/
INSERT INTO Rating(rating_id, rating_star, cust_comments, rating_datetime)
VALUES ('R00000119','S4','The driver is dam noob in do',TIMESTAMP('2019-06-24 05:47:49'));
INSERT INTO Rating(rating_id, rating_star, cust_comments, rating_datetime)
VALUES ('R00000219','S3','',TIMESTAMP());
INSERT INTO Rating(rating_id, rating_star, cust_comments, rating_datetime)
VALUES ('R00000319','S7',?,?);
INSERT INTO Rating(rating_id, rating_star, cust_comments, rating_datetime)
VALUES ('R00000419','S5',?,?);
INSERT INTO Rating(rating_id, rating_star, cust_comments, rating_datetime)
VALUES ('R00000519','S8',?,?);
INSERT INTO Rating(rating_id, rating_star, cust_comments, rating_datetime)
VALUES ('R00000619','S9',?,?);
INSERT INTO Rating(rating_id, rating_star, cust_comments, rating_datetime)
VALUES ('R00000719','S4',?,?);
INSERT INTO Rating(rating_id, rating_star, cust_comments, rating_datetime)
VALUES ('R00000819','S8',?,?);
INSERT INTO Rating(rating_id, rating_star, cust_comments, rating_datetime)
VALUES ('R00000919','S0',?,?);
INSERT INTO Rating(rating_id, rating_star, cust_comments, rating_datetime)
VALUES ('R00001019','S9',?,?);
/*====================== CarType =====================*/
INSERT INTO CarType(car_type_id, car_series_name, cust_capacity)
VALUES ('CTI00001','Sedan',04);
INSERT INTO CarType(car_type_id, car_series_name, cust_capacity)
VALUES ('CTI00002','SUV',04);
INSERT INTO CarType(car_type_id, car_series_name, cust_capacity)
VALUES ('CTI00003','MPV',06);
INSERT INTO CarType(car_type_id, car_series_name, cust_capacity)
VALUES ('CTI00004','SUV',04);
INSERT INTO CarType(car_type_id, car_series_name, cust_capacity)
VALUES ('CTI00005','SUV',04);
INSERT INTO CarType(car_type_id, car_series_name, cust_capacity)
VALUES ('CTI00006','Sedan',04);
INSERT INTO CarType(car_type_id, car_series_name, cust_capacity)
VALUES ('CTI00007','Sedan',04);
INSERT INTO CarType(car_type_id, car_series_name, cust_capacity)
VALUES ('CTI00008','MPV',06);
INSERT INTO CarType(car_type_id, car_series_name, cust_capacity)
VALUES ('CTI00009','MPV',06);
INSERT INTO CarType(car_type_id, car_series_name, cust_capacity)
VALUES ('CTI00010','Sedan',04);
/*====================== Customer =====================*/
INSERT INTO Customer(Cust_id, first_name, last_name, phone_num, ic_num, point_amount, membership_level, proc_pic, password)
VALUES ('BR001141219','Eric','Ong','6012-132-4568','210425-54-4521', 1000,'BR',NULL, '8454bfr23');
INSERT INTO Customer(Cust_id, first_name, last_name, phone_num, ic_num, point_amount, membership_level, proc_pic, password)
VALUES ('SL002141219','Cindy','Lim','6015-668-9879','900130-23-6523',1000,'SL',NULL, 'gbewut2134f');
INSERT INTO Customer(Cust_id, first_name, last_name, phone_num, ic_num, point_amount, membership_level, proc_pic, password)
VALUES ('AU003141219','Joey','Lee','6014-887-5099','801223-66-9865',1000,'AU',NULL, 'vnewt84v');
INSERT INTO Customer(Cust_id, first_name, last_name, phone_num, ic_num, point_amount, membership_level, proc_pic, password)
VALUES ('PL004141219','Johnny','Wong','6019-668-8899','851104-54-1457',1000,'PL',NULL, 'vgweituy49');
INSERT INTO Customer(Cust_id, first_name, last_name, phone_num, ic_num, point_amount, membership_level, proc_pic, password)
VALUES ('AU005141219','Tim','Chao','6017-150-6679','951112-44-2456',1000,'AU',NULL, 'tw9gh9ef');
INSERT INTO Customer(Cust_id, first_name, last_name, phone_num, ic_num, point_amount, membership_level, proc_pic, password)
VALUES ('SL006141219','Robert','How','6016-558-2356','850222-33-9007',1000,'SL',NULL, 't4u9jgvb');
INSERT INTO Customer(Cust_id, first_name, last_name, phone_num, ic_num, point_amount, membership_level, proc_pic, password)
VALUES ('PL007141219','Tristan','Seow','6012-933-9589','681116-09-1657',1000,'PL',NULL, 'gnwitg9');
INSERT INTO Customer(Cust_id, first_name, last_name, phone_num, ic_num, point_amount, membership_level, proc_pic, password)
VALUES ('BR008141219','Ronald','Heng','6011-911-1862','780731-20-2538',1000,'BR',NULL, 'veirgjwr');
INSERT INTO Customer(Cust_id, first_name, last_name, phone_num, ic_num, point_amount, membership_level, proc_pic, password)
VALUES ('AU009141219','Frankie','Yong','6010-720-3079','000814-22-3702',1000,'AU',NULL, 'vfweiufh');
INSERT INTO Customer(Cust_id, first_name, last_name, phone_num, ic_num, point_amount, membership_level, proc_pic, password)
VALUES ('BR010141219','Jocelyn','Ma','6013-488-9879', '680327-09-9166',1000,'BR',NULL, 'Hahaha');
/*====================== Driver =====================*/
INSERT INTO Driver(driver_id, first_name, last_name, phone_num, ic_num, license, year_of_drive, proc_pic, password)
VALUES('D2000001','Ben','Philips','6018-367-6754','123456-23-4567','65738925',20,NULL,'Aa73218324');
INSERT INTO Driver(driver_id, first_name, last_name, phone_num, ic_num, license, year_of_drive, proc_pic, password)
VALUES('D1600002','Mike','Leong','6016-688-7809','223456-18-2345','12345678',16,NULL,'Aa73218324');
INSERT INTO Driver(driver_id, first_name, last_name, phone_num, ic_num, license, year_of_drive, proc_pic, password)
VALUES('D3500003','Romeo','Parker','6013-335-9845','126019-24-1823','12396256',35,NULL,'Aa73218324');
INSERT INTO Driver(driver_id, first_name, last_name, phone_num, ic_num, license, year_of_drive, proc_pic, password)
VALUES('D1400004','Nelson','Ng','6012-276-4544','991402-32-1293','32345678',14,NULL,'Aa73218324');
INSERT INTO Driver(driver_id, first_name, last_name, phone_num, ic_num, license, year_of_drive, proc_pic, password)
VALUES('D1100005','Lino','Tino','6011-328-0967','939302-32-1293','39183432',11,NULL,'Aejrtg4');
INSERT INTO Driver(driver_id, first_name, last_name, phone_num, ic_num, license, year_of_drive, proc_pic, password)
VALUES('D2300006','Leito','Belle','6011-365-9887','991402-14-1193','32372848',23,NULL,'ugvhwg49');
INSERT INTO Driver(driver_id, first_name, last_name, phone_num, ic_num, license, year_of_drive, proc_pic, password)
VALUES('D2800007','Thomas','Yip','6019-979-5667','891233-19-8132','92938704',28,NULL,'fughe834');
INSERT INTO Driver(driver_id, first_name, last_name, phone_num, ic_num, license, year_of_drive, proc_pic, password)
VALUES('D3200008','Damian','Thomaso','6013-234-3922','829322-32-1283','32735438',32,NULL,'9345840');
INSERT INTO Driver(driver_id, first_name, last_name, phone_num, ic_num, license, year_of_drive, proc_pic, password)
VALUES('D3700009','David','Dave','6015-398-7935','923931-30-1239','99349348',37,NULL,'hvbwieth44f');
INSERT INTO Driver(driver_id, first_name, last_name, phone_num, ic_num, license, year_of_drive, proc_pic, password)
VALUES('D0800010','Alexinho','Thoi','6017-392-7135','391842-28-8724','09328023',08,NULL,'94bfd3749');
'vcbwie932');
/*====================== Payment method =====================*/
INSERT INTO Payment_method(pay_method_id, user_id, payment_method, card_num)
VALUES ('CDBR00814121901','BR008141219','CD','9999-9999-9999-9999');
/*====================== Payment =====================*/
INSERT INTO Payment(payment_id, payment_method, payment_status, payment_date, pay_amount)
VALUES('0001CDBR00814121901','CDBR00814121901','P2',TIMESTAMP('2019-04-11 15:30:22'),14.50);
/*====================== Car =====================*/
INSERT INTO Car(car_plate_num, car_type_id, owner_name, quickar_type, driver_id)
VALUES('BPM#7866','CTI00008','Damian Thomaso','SS','D3200008');
INSERT INTO Car(car_plate_num, car_type_id, owner_name, quickar_type, driver_id)
VALUES('BCN#3877',?,'David Dave',?,'D3700009');
INSERT INTO Car(car_plate_num, car_type_id, owner_name, quickar_type, driver_id)
VALUES('WSE#9123',?,'Alexinho Thoi',?,'D0800010');
INSERT INTO Car(car_plate_num, car_type_id, owner_name, quickar_type, driver_id)
VALUES('HSC#7658',?,'Ben Philips',?,'D2000001');
INSERT INTO Car(car_plate_num, car_type_id, owner_name, quickar_type, driver_id)
VALUES('WRY#2476',?,'Thomas Yip',?,'D2800007');
INSERT INTO Car(car_plate_num, car_type_id, owner_name, quickar_type, driver_id)
VALUES('VAY#6571',?,'Mike Leong',?,'D1600002');
INSERT INTO Car(car_plate_num, car_type_id, owner_name, quickar_type, driver_id)
VALUES('VBD#3651',?,'Nelson Ng',?,'D1400004');
INSERT INTO Car(car_plate_num, car_type_id, owner_name, quickar_type, driver_id)
VALUES('VPN#8270',?,'Leito Belle',?,'D2300006');
INSERT INTO Car(car_plate_num, car_type_id, owner_name, quickar_type, driver_id)
VALUES('WPK5387',?,'Romeo Parker',?,'D3500003');
INSERT INTO Car(car_plate_num, car_type_id, owner_name, quickar_type, driver_id)
VALUES('WPR8639',?,'Lino Tino',?,'D1100005');
/*====================== Booking =====================*/
INSERT INTO Booking(booking_id, rating_id, cust_id, driver_id, payment_id, booking_date, fetch_date, booking_status, start_location_code, end_location_code)
VALUES(?,?,?,?,?,?,?,?,?,?);