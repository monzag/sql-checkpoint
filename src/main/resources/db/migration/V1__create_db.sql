CREATE TABLE IF NOT EXISTS `customers` (
  `id`	INTEGER NOT NULL UNIQUE,
  `name`	TEXT NOT NULL,
  `surname`	TEXT NOT NULL,
  `birthyear`	INTEGER NOT NULL,
  `gender`	TEXT NOT NULL,
  PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `sales` (
  `id`           INTEGER NOT NULL UNIQUE,
  `customer_id`  INTEGER NOT NULL,
  `product_name` TEXT    NOT NULL,
  `net_value`    INTEGER NOT NULL,
  `tax_rate`     INTEGER NOT NULL,
  FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)
    ON DELETE SET NULL,
  PRIMARY KEY (`id`)
);