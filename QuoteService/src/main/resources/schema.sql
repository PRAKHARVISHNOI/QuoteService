DROP TABLE IF EXISTS QUOTES;
 
CREATE TABLE QUOTES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  symbol VARCHAR(250),
  shares_traded VARCHAR(250),
  timestamp VARCHAR(250),
  change_direction VARCHAR(250),
  price_traded DECIMAL,
  change_amount DECIMAL
);

-- select symbol, count(*) from QUOTES group by symbol order by 2 desc, symbol asc;