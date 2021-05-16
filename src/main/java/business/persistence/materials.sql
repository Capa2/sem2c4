USE fog_carport;

DELETE FROM TABLE `materialCategory` WHERE `id` IS NOT NULL;

INSERT INTO `materialCategory` (name)
VALUES ('rafter'),
       ('rem'),
       ('flatRoof'),
       ('slopedRoof'),
       ('cladding');

DELETE FROM TABLE `material` WHERE `id` IS NOT NULL;

INSERT INTO `material` (name, cost, length, width, materialCategoryId)
VALUES ('trykimp. stolpe', '300', '300', '97', '1'),
       ('spærtræ ubh.', '150', '600', '195', '2'),
       ('Plastmo Ecolite blåtonet', '500', '600', '600', '3'),
       ('trykimp. brædt', '200', '19', '100', '5');


INSERT INTO `material` (name, cost)
VALUES ('plastmo bundskruer 200 stk.', 80),
       ('skruer 4,5x7mm 400 stk.', 50),
       ('skruer 4,5x7mm 300 stk.', 50),
       ('firkantsskiver 40x40mm', 70);
