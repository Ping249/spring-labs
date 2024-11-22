INSERT INTO stocks (symbol, min_order, max_order)
VALUES ('IBM', 100, 5000);
INSERT INTO stocks (symbol, min_order, max_order)
VALUES ('GOOG', 200, 2500);
INSERT INTO stocks (symbol, min_order, max_order)
VALUES ('ORCL', 50, 1000);
INSERT INTO stocks (symbol, min_order, max_order)
VALUES ('AMZN', 1000, 25000);


INSERT INTO users (identifier_type, balance_held_on_account,  country_of_residence, email_address, first_name, government_identifier, last_name, phone_number)
VALUES(1, 0, 'UK', 'jdoe@aol.com', 'John', '555-55-5555', 'Doe', '555-555-5555');

INSERT INTO stocks (symbol, min_order, max_order) VALUES ('TSLA', 200, 2000);
INSERT INTO stocks (symbol, min_order, max_order) VALUES ('APPL', 100, 3500);
INSERT INTO stocks (symbol, min_order, max_order) VALUES ('MSFT', 50, 7500);

INSERT INTO users (first_name, last_name, email_address,
                    phone_number, country_of_residence, government_identifier,
                    balance_held_on_account, identifier_type) VALUES
                    ('Jane', 'Doe', 'jd@ltree.com', '0123456789',
                    'UK', 'AB12345678C', 0, 2);

INSERT INTO portfolios (name, user_id) VALUES ('Energy', 1);
INSERT INTO assets (portfolio_id, product_id, quantity, price) VALUES (1,2,500,887);

INSERT INTO portfolios (name, user_id) VALUES ('Automotive', 1);
INSERT INTO portfolios (name, user_id) VALUES ('Residential', 1);
INSERT INTO portfolios (name, user_id) VALUES ('Clothing', 1);