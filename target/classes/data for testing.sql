
-- ALL OF ROLES:

INSERT INTO user_role (username, role, granted_date)
VALUES ('admin', 'ADMIN', NOW());

INSERT INTO user_role (username, role, granted_date)
VALUES ('customer', 'CUSTOMER', NOW());

SELECT * FROM USER_ROLE;

-- ALL OF USUARIO:

INSERT INTO usuario (username, password, email, locked, disabled)
VALUES ('admin', '$2y$10$FgwVgyMFTWq7UKpaWUCsHuk2jLfmfWO88pvEMTMlB0Iko24K35kwC', 'admin@example.com', false, false);

INSERT INTO usuario (username, password, email, locked, disabled)
VALUES ('customer', '$2y$10$gH8RFWavq49TfDgFe6qThuEZJswOfzT4jdb.93nUFbwGPLQAEhaEq', 'customer@example.com', false, false);

SELECT * FROM USUARIO;

-- ALL OF PRODUCTS:

INSERT INTO product (name, reference, price, weight, category, stock)
VALUES ('Product 1', 'REF-001', 10.00, 1.0, 'Electronic', 10);

INSERT INTO product (name, reference, price, weight, category, stock)
VALUES ('Product 2', 'REF-002', 20.00, 2.0, 'Food', 20);

INSERT INTO product (name, reference, price, weight, category, stock)
VALUES ('Product 3', 'REF-003', 30.0, 3.0, 'Transport', 30);

SELECT * FROM PRODUCT;