

CREATE DATABASE mypostgresql;

drop table t_tester;

CREATE TABLE t_tester (
    id INT,
    name VARCHAR(255),
    address VARCHAR(500),
    PRIMARY KEY (id)
);

delete from t_tester;

INSERT INTO t_tester (id, name, address) VALUES
(1, 'cucu', '123 Maple Street, Springfield'),
(2, 'xuxu', '456 Oak Avenue, Greenfield'),
(3, 'dudu', '789 Pine Road, Willow Creek'),
(4, 'zeze', '321 Cedar Lane, Oakwood'),
(5, 'boyangyang', '654 Birch Street, Maplewood'),
(6, 'Diana Miller', '987 Beech Avenue, Pineview'),
(7, 'Frank Davis', '555 Cherry Road, Woodland'),
(8, 'Grace Taylor', '888 Walnut Street, Forest Hills'),
(9, 'Henry White', '777 Hickory Lane, Brookside'),
(10, 'Isabella Harris', '999 Elm Avenue, Riverview');

SELECT * from t_tester