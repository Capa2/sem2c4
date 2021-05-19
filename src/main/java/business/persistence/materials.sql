USE fog_carport;

DELETE FROM `materialCategory`;

INSERT INTO `materialCategory` (name)
VALUES ('rafter'),
       ('rem'),
       ('flatRoof'),
       ('slopedRoof'),
       ('cladding'),
       ('post');

DELETE FROM `material`;

INSERT INTO `material` (name, cost, length, width, materialCategoryId)
VALUES ('trykimp. stolpe', '300', '300', '97', (SELECT id from materialCategory WHERE name='post')),
       ('spærtræ ubh.', '250', '600', '195', (SELECT id from materialCategory WHERE name='rafter')),
       ('spærtræ ubh.', '250', '600', '195', (SELECT id from materialCategory WHERE name='rem')),
       ('Plastmo Ecolite blåtonet', '500', '600', '600', (SELECT id from materialCategory WHERE name='flatRoof')),
       ('trykimp. brædt', '200', '210', '100', (SELECT id from materialCategory WHERE name='cladding'));


INSERT INTO `material` (name, cost)
VALUES ('plastmo bundskruer 200 stk.', 80),
       ('skruer 4,5x7mm 400 stk.', 50),
       ('skruer 4,5x7mm 300 stk.', 50),
       ('firkantsskiver 40x40mm', 70);
