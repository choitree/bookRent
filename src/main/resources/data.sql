INSERT IGNORE INTO `user`(id, login_id, name, email, password)
VALUES (1, 'tree', '최희윤', 'tree@gmail.com', '$2a$10$TAK8zT78BdabREx5L6ap4OI6R1AMPdj1oFiYrzjOcKSZoZfhSJpWm');
/*password: 1234*/

INSERT IGNORE INTO `user_roles`(user_id, roles)
VALUES (1, 'USER');

INSERT IGNORE INTO `book`(id, name, isbn, is_rental)
VALUES (1, 'book1', '1234', false);

INSERT IGNORE INTO `book`(id, name, isbn, is_rental)
VALUES (2, 'book2', '5678', false);

