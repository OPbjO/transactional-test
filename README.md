# transactional-test
用于测试spring事务工程

数据库sql

从user_a到user_i

```sql
  CREATE TABLE `user_a` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(225) DEFAULT NULL,
  `age` INT(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4
```

