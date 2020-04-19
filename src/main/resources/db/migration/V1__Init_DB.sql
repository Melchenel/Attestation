CREATE TABLE auth_information
(
    login character varying(30) NOT NULL,
    password character varying(60) NOT NULL,
    code character varying(10),
    PRIMARY KEY (login)
);


CREATE TABLE user_information
(
    login character varying(30) NOT NULL,
    firstname character varying(50) NOT NULL,
    lastname character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    phonenumber character varying(50) NOT NULL,
    role integer NOT NULL,
    PRIMARY KEY (login)
);

INSERT INTO auth_information(
	login, password)
	VALUES ('Melchenel', MD5('123'));

INSERT INTO auth_information(
	login, password)
	VALUES ('User1',  MD5('1'));

INSERT INTO auth_information(
	login, password)
	VALUES ('User2',  MD5('2'));

INSERT INTO user_information(
	login, firstname, lastname, email, phonenumber, role)
	VALUES ('Melchenel', 'Anna', 'Ryaskina', 'melchenelann@gmail.com', '+79998663869', 2);

INSERT INTO user_information(
	login, firstname, lastname, email, phonenumber, role)
	VALUES ('User1', 'Test1', '1test', 'melchenelann@gmail.com',  '+79998663869', 1);

INSERT INTO user_information(
	login, firstname, lastname, email, phonenumber, role)
	VALUES ('User2', 'Test2', '2test', 'melchenelann@gmail.com',  '+79998663869', 1);