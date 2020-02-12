create table Make
(
	mid int primary key auto_increment, 
	make_name varchar(16) UNIQUE NOT NULL
);

INSERT INTO  Make values (1, 'BMW');
INSERT INTO  Make values (2, 'Mercedes-Benz');
INSERT INTO  Make values (3, 'Audi');

create table VehicleInfo
(
	vid int primary key auto_increment, 
	Year varchar(16) NOT NULL, 
	mid int NOT NULL, 
	model varchar(32) NOT NULL, 
	comb_cons DECIMAL(4,1), 
	foreign key (mid) REFERENCES Make(mid)
);

INSERT INTO  VehicleInfo values (1, '2019',1,'M4 Cabriolet',12.7);
INSERT INTO  VehicleInfo values (2, '2019',1,'M4 Cabriolet Competition',12.7);
INSERT INTO  VehicleInfo values (3, '2019',1,'M4 Coupe',12.6);
INSERT INTO  VehicleInfo values (4, '2019',1,'M4 CS',12.6);
INSERT INTO  VehicleInfo values (5, '2019',1,'X3 M40i',8.7);

create table User
(
	uid int primary key auto_increment, 
	username varchar(16) UNIQUE NOT NULL,
	password varchar(16) NOT NULL,
    user_type varchar(16) NOT NULL
);

/*DELIMITER //

create trigger CheckUserType
before insert on User
for each row
BEGIN 
	IF (NEW.user_type not in ('Admin','Manufacturer','Buyer')) THEN SET NEW.user_type = NULL;
    END IF;
END;//

DELIMITER ;*/

INSERT INTO  User values (1, 'w22yuan','yuanwei', 'Admin');
INSERT INTO  User values (2, 'h93yang','yaohaochen', 'Admin');
INSERT INTO  User values (3, 'x6lian','lianxin', 'Admin');
INSERT INTO  User values (4, 'x558li','nancy', 'Admin');
INSERT INTO  User values (5, 'manufacturer0','cs348', 'Manufacturer');
INSERT INTO  User values (6, 'manufacturer1','cs348', 'Manufacturer');
INSERT INTO  User values (7, 'manufacturer2','cs348', 'Manufacturer');
INSERT INTO  User values (8, 'customer0','cs348', 'Buyer');
INSERT INTO  User values (9, 'customer1','cs348', 'Buyer');
INSERT INTO  User values (10, 'customer2','cs348', 'Buyer');

create table Admin
(	
	uid int UNIQUE,
    user_type varchar(16) CHECK (user_type = 'Admin'),
	foreign key (uid) REFERENCES User(uid)
);

INSERT INTO  Admin values (1, 'Admin');
INSERT INTO  Admin values (2, 'Admin');
INSERT INTO  Admin values (3, 'Admin');
INSERT INTO  Admin values (4, 'Admin'); 

create table Manufacturer
(
	uid int UNIQUE, 
	pid int UNIQUE,
    user_type varchar(16) not null,
    CHECK (user_type in ('Manufacturer')),
	foreign key (uid) REFERENCES User(uid)
);


INSERT INTO  Manufacturer values (5, 1, 'Manufacturer');
INSERT INTO  Manufacturer values (6, 2, 'Manufacturer');
INSERT INTO  Manufacturer values (7, 3, 'Manufacturer');

create table Buyer
(	
	uid int UNIQUE, 
	cid int UNIQUE,
    user_type varchar(16) CHECK (user_type = 'Buyer'),
	foreign key (uid) REFERENCES User(uid)
);

INSERT INTO  Buyer values (8, 1, 'Buyer');
INSERT INTO  Buyer values (9, 2, 'Buyer');
INSERT INTO  Buyer values (10, 3, 'Buyer');


create table Produce
(
	pid int,
	vid int, 
	PRIMARY KEY (pid, vid),
	foreign key (vid) REFERENCES VehicleInfo(vid),
    foreign key (pid) REFERENCES Manufacturer(pid)
);


INSERT INTO Produce values (1, 1);
INSERT INTO Produce values (1, 2);
INSERT INTO Produce values (1, 3);
INSERT INTO Produce values (2, 4);
INSERT INTO Produce values (3, 5);


create table Cart
(
	cid int, 
	vid int, 
    PRIMARY KEY (cid, vid),
	foreign key (vid) REFERENCES VehicleInfo(vid),
    foreign key (cid) REFERENCES Buyer(cid)
);

INSERT INTO Cart values (1, 1);
INSERT INTO Cart values (1, 2);
INSERT INTO Cart values (1, 3);
INSERT INTO Cart values (2, 1);
INSERT INTO Cart values (2, 5);
INSERT INTO Cart values (3, 1);
INSERT INTO Cart values (3, 3);



