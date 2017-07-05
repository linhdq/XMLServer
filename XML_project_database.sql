CREATE DATABASE XMLProjectDB;
GO
USE XMLProjectDB
GO
CREATE TABLE Users(
	Username_ VARCHAR(255) NOT NULL PRIMARY KEY,
	Password_ VARCHAR(255) NOT NULL,
	Fullname_ VARCHAR(255),
	PhoneNumber_ VARCHAR(15),
	Role_ INTEGER DEFAULT 0,
	CreatedBy_ VARCHAR(255)
);
GO
CREATE TABLE Table_De(
	Username_ VARCHAR(255) FOREIGN KEY REFERENCES Users(Username_),
	Number_ INTEGER,
	Price_ INTEGER,
	Date_ VARCHAR(20)
);
GO
CREATE TABLE Table_ba_cang(
	Username_ VARCHAR(255) FOREIGN KEY REFERENCES Users(Username_),
	Number_ INTEGER,
	Price_ INTEGER,
	Date_ VARCHAR(20)
);
GO
CREATE TABLE Table_lo(
	Username_ VARCHAR(255) FOREIGN KEY REFERENCES Users(Username_),
	Number_ INTEGER,
	Point_ FLOAT,
	Date_ VARCHAR(20)
);
GO
CREATE TABLE Table_lo_xien_2(
	Username_ VARCHAR(255) FOREIGN KEY REFERENCES Users(Username_),
	Number_1 INTEGER,
	Number_2 INTEGER,
	Point_ FLOAT,
	Date_ VARCHAR(20)
);
GO
CREATE TABLE Table_lo_xien_3(
	Username_ VARCHAR(255) FOREIGN KEY REFERENCES Users(Username_),
	Number_1 INTEGER,
	Number_2 INTEGER,
	Number_3 INTEGER,
	Point_ FLOAT,
	Date_ VARCHAR(20)
);
GO
CREATE TABLE Table_lo_xien_4(
	Username_ VARCHAR(255) FOREIGN KEY REFERENCES Users(Username_),
	Number_1 INTEGER,
	Number_2 INTEGER,
	Number_3 INTEGER,
	Number_4 INTEGER,
	Point_ FLOAT,
	Date_ VARCHAR(20)
);
GO
CREATE TABLE Table_price(
	Username_ VARCHAR(255) FOREIGN KEY REFERENCES Users(Username_),
	DePrice_ INTEGER,
	BaCangPrice_ INTEGER,
	LoNhanPrice_ INTEGER,
	LoTraPrice_ INTEGER,
	LoXien2NhanPrice_ INTEGER,
	LoXien2TraPrice_ INTEGER,
	LoXien3NhanPrice_ INTEGER,
	LoXien3TraPrice_ INTEGER,
	LoXien4NhanPrice_ INTEGER,
	LoXien4TraPrice_ INTEGER
);
GO
INSERT INTO Users(Username_, Password_, Fullname_, PhoneNumber_, Role_, CreatedBy_)
VALUES('admin', 'admin','Dao Quang Linh', '0976678404', 0,'');
INSERT INTO Users(Username_, Password_, Fullname_, PhoneNumber_, Role_, CreatedBy_)
VALUES('tungnt', '123456','Nguyen Thanh Tung', '0976678404', 1,'admin');
INSERT INTO Users(Username_, Password_, Fullname_, PhoneNumber_, Role_, CreatedBy_)
VALUES('linhdq', '123456','Dao Quang Linh', '0976678404', 1,'admin');
INSERT INTO Users(Username_, Password_, Fullname_, PhoneNumber_, Role_, CreatedBy_)
VALUES('truongtn', '123456','Tran Nhat Truong', '0976678404', 2,'tungnt');
INSERT INTO Users(Username_, Password_, Fullname_, PhoneNumber_, Role_, CreatedBy_)
VALUES('tribm', '123456','Bui Manh Tri', '0976678404', 2,'linhdq');
INSERT INTO Users(Username_, Password_, Fullname_, PhoneNumber_, Role_, CreatedBy_)
VALUES('chinhnd', '123456','Nguyen Duc Chinh', '0976678404', 2,'linhdq');

INSERT INTO Table_De(Username_, Number_, Price_, Date_)
VALUES('truongtn', 25, 10000, '06/07/2017');
INSERT INTO Table_De(Username_, Number_, Price_, Date_)
VALUES('tribm', 26, 50000, '06/07/2017');
INSERT INTO Table_De(Username_, Number_, Price_, Date_)
VALUES('chinhnd', 27, 30000, '06/07/2017');

INSERT INTO Table_ba_cang(Username_, Number_, Price_, Date_)
VALUES('truongtn', 253, 10000, '06/07/2017');
INSERT INTO Table_ba_cang(Username_, Number_, Price_, Date_)
VALUES('tribm', 264, 50000, '06/07/2017');
INSERT INTO Table_ba_cang(Username_, Number_, Price_, Date_)
VALUES('chinhnd', 275, 30000, '06/07/2017');

INSERT INTO Table_lo(Username_, Number_, Point_, Date_)
VALUES('truongtn', 25, 20, '06/07/2017');
INSERT INTO Table_lo(Username_, Number_, Point_, Date_)
VALUES('tribm', 26, 30, '06/07/2017');
INSERT INTO Table_lo(Username_, Number_, Point_, Date_)
VALUES('chinhnd', 27, 40, '06/07/2017');

INSERT INTO Table_lo_xien_2(Username_, Number_1, Number_2, Point_, Date_)
VALUES('truongtn', 25, 26, 20, '06/07/2017');
INSERT INTO Table_lo_xien_2(Username_, Number_1, Number_2, Point_, Date_)
VALUES('tribm', 26, 27, 30, '06/07/2017');
INSERT INTO Table_lo_xien_2(Username_, Number_1, Number_2, Point_, Date_)
VALUES('chinhnd', 27, 28, 40, '06/07/2017');

INSERT INTO Table_lo_xien_3(Username_, Number_1, Number_2, Number_3, Point_, Date_)
VALUES('truongtn', 25, 26, 27, 20, '06/07/2017');
INSERT INTO Table_lo_xien_3(Username_, Number_1, Number_2, Number_3, Point_, Date_)
VALUES('tribm', 26, 27, 28, 30, '06/07/2017');
INSERT INTO Table_lo_xien_3(Username_, Number_1, Number_2, Number_3, Point_, Date_)
VALUES('chinhnd', 27, 28, 29, 40, '06/07/2017');

INSERT INTO Table_lo_xien_4(Username_, Number_1, Number_2, Number_3, Number_4, Point_, Date_)
VALUES('truongtn', 25, 26, 27, 28, 20, '06/07/2017');
INSERT INTO Table_lo_xien_4(Username_, Number_1, Number_2, Number_3, Number_4, Point_, Date_)
VALUES('tribm', 26, 27, 28, 29, 30, '06/07/2017');
INSERT INTO Table_lo_xien_4(Username_, Number_1, Number_2, Number_3, Number_4, Point_, Date_)
VALUES('chinhnd', 27, 28, 29, 30, 40, '06/07/2017');