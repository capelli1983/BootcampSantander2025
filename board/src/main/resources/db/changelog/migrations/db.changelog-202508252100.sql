--liquibase formatted sql
--changeset rodrigo:202508252100
--comment: Create boards table with precondition
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:0 SELECT COUNT(*)
FROM information_schema.tables
WHERE table_name = 'BOARDS' AND table_schema = DATABASE();

CREATE TABLE BOARDS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

--rollback DROP TABLE BOARDS;
