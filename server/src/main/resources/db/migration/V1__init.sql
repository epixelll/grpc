CREATE TABLE account(
  id SERIAL PRIMARY KEY
);

CREATE TABLE wallet(
  id SERIAL PRIMARY KEY,
  account_id INTEGER NOT NULL,
  currency VARCHAR(3) NOT NULL,
  amount DECIMAL(20, 2) NOT NULL DEFAULT 0,
  FOREIGN KEY (account_id) REFERENCES account(id),
  UNIQUE (account_id, currency)
);