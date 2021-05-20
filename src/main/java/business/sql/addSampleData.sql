use fog_carport;

DELETE
FROM `query`;
DELETE
FROM `response`;

DELETE
FROM `user`;
INSERT INTO `user` (email, password, role, name, phone, street, town, zipCode)
VALUES ('johan@gmail.com', '1234', 'employee', 'Johan Karpantschof', 30229360, 'Guldbergsgade 33', 'København', 2200)
     , ('alex@gmail.com', '1234', 'employee', 'Alexander Mand', 12345678, 'Roskildevej 100', 'Roskilde', 4155)
     , ('kim@gmail.com', '1234', 'customer', 'Kim Paulsen', 50422205, 'Vejgade 15', 'Odense', 5450)
     , ('paul@gmail.com', '1234', 'customer', 'Paul Kimsen', 20204155, 'Gadevej 25', 'Horsens', 8250);

DELETE
FROM `carport`;
INSERT INTO `carport` (roofAngle, width, length, shedWidth, shedLength, name)
VALUES ('0', '300', '480', '0', '0', 'CAR01'),
       ('0', '300', '620', '270', '150', 'CAR01R'),
       ('0', '600', '540', '260', '185', 'CAR01DR'),
       ('0', '600', '480', '0', '0', 'CAR01DU'),
       ('45', '360', '540', '0', '0', 'CAR01H'),
       ('45', '360', '730', '320', '225', 'CAR01HR'),
       ('45', '360', '810', '320', '240', 'CARL01HR'),
       ('45', '360', '910', '320', '355', 'CARXL1HR'),
       ('0', '600', '780', '530', '210', 'CPO01DUR'),
       ('45', '390', '780', '330', '240', 'CPO01HR'),
       ('45', '600', '780', '530', '210', 'CP02HUR'),
       ('45', '600', '870', '530', '310', 'CP02HSR'),
       ('45', '600', '990', '530', '420', 'CP02HXL');

DELETE
FROM `materialCategory`;
INSERT INTO `materialCategory` (name)
VALUES ('rafter'),
       ('rem'),
       ('flatRoof'),
       ('slopedRoof'),
       ('cladding');

DELETE
FROM `material`;
INSERT INTO `material` (name, cost, length, width, materialCategoryId)
VALUES ('trykimp. stolpe', 300, 300, 97, 1),
       ('spærtræ ubh.', 150, 600, 195, 2),
       ('Plastmo Ecolite blåtonet', 500, 600, 600, 3),
       ('plastmo bundskruer 200 stk.', 80, 0, 0, 0),
       ('skruer 400 stk.', 50, 4, 7, 0),
       ('skruer 300 stk.', 4, 5, 0, 0),
       ('trykimp. brædt', 200, 19, 100, 5),
       ('firkantsskiver', 70, 40, 40, 0),
       ('bræddebolt', 100, 10, 120, 0),
       ('universal højre', 120, 190, 0, 0),
       ('universal venstre', 120, 190, 0, 0);