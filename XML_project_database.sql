CREATE DATABASE XMLProjectDB;
GO
USE XMLProjectDB
GO
CREATE TABLE Users(
	Username_ VARCHAR(255) NOT NULL PRIMARY KEY,
	Password_ VARCHAR(255) NOT NULL,
	Fullname_ VARCHAR(255),
	PhoneNumber_ VARCHAR(15),
	Role_ INTEGER DEFAULT 0
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
INSERT INTO Users(Username_, Password_, Fullname_, PhoneNumber_, Role_)
VALUES('admin', 'admin','Dao Quang Linh', '0976678404', 0);
INSERT INTO Users(Username_, Password_, Fullname_, PhoneNumber_, Role_)
VALUES('tungnt', '123456','Nguyen Thanh Tung', '0976678404', 1);
INSERT INTO Users(Username_, Password_, Fullname_, PhoneNumber_, Role_)
VALUES('truongtn', '123456','Tran Nhat Truong', '0976678404', 2);
INSERT INTO Users(Username_, Password_, Fullname_, PhoneNumber_, Role_)
VALUES('tribm', '123456','Bui Manh Tri', '0976678404', 2);
INSERT INTO Users(Username_, Password_, Fullname_, PhoneNumber_, Role_)
VALUES('chinhnd', '123456','Nguyen Duc Chinh', '0976678404', 2);

INSERT INTO Table_De(Username_, Number_, Price_, Date_)
VALUES('tungnt', 24, 20000, '03/07/2017');
INSERT INTO Table_De(Username_, Number_, Price_, Date_)
VALUES('truongtn', 25, 10000, '03/07/2017');
INSERT INTO Table_De(Username_, Number_, Price_, Date_)
VALUES('tribm', 26, 50000, '03/07/2017');
INSERT INTO Table_De(Username_, Number_, Price_, Date_)
VALUES('chinhnd', 27, 30000, '03/07/2017');