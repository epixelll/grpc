INSERT INTO account (id)
SELECT g.id
FROM generate_series(1, 10000) as g (id);

SELECT setval(pg_get_serial_sequence('account', 'id'), 10000, true);

INSERT INTO wallet (account_id, currency, amount)
SELECT g.id, 'USD', 0
FROM generate_series(1, 10000) AS g (id) ;


INSERT INTO wallet (account_id, currency, amount)
SELECT g.id, 'EUR', 0
FROM generate_series(1, 10000) AS g (id) ;

INSERT INTO wallet (account_id, currency, amount)
SELECT g.id, 'GBP', 0
FROM generate_series(1, 10000) AS g (id) ;