CREATE TABLE `tbl_board` (
	`bno` INT(11) NOT NULL AUTO_INCREMENT COMMENT '게시글 번호',
	`title` VARCHAR(50) NULL DEFAULT '0' COMMENT '제목' COLLATE 'utf8_bin',
	`writer` VARCHAR(50) NOT NULL DEFAULT '0' COMMENT '글쓴이' COLLATE 'utf8_bin',
	`content` VARCHAR(2000) NOT NULL DEFAULT '0' COMMENT '내용' COLLATE 'utf8_bin',
	`regDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '쓴 날짜',
	`updateDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '업데이트 날짜',
	`ip_address` VARCHAR(100) NULL DEFAULT NULL COMMENT '아이피 주소' COLLATE 'utf8_bin',
	`state` VARCHAR(10) NOT NULL DEFAULT 'NORMAL' COMMENT '상태' COLLATE 'utf8_bin',
	`password` TEXT NULL COMMENT '비밀번호' COLLATE 'utf8_bin',
	PRIMARY KEY (`bno`)
)
COLLATE='utf8_bin'
ENGINE=InnoDB
;


CREATE TABLE `tbl_board_history` (
	`hbno` INT(11) NOT NULL AUTO_INCREMENT,
	`bno` INT(11) NOT NULL DEFAULT '0',
	`title` VARCHAR(50) NULL DEFAULT '0' COLLATE 'utf8_bin',
	`writer` VARCHAR(50) NOT NULL DEFAULT '0' COLLATE 'utf8_bin',
	`content` VARCHAR(2000) NOT NULL DEFAULT '0' COLLATE 'utf8_bin',
	`regDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updateDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`ip_address` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8_bin',
	`state` VARCHAR(10) NOT NULL DEFAULT 'UPDATE' COLLATE 'utf8_bin',
	`password` TEXT NULL COLLATE 'utf8_bin',
	PRIMARY KEY (`hbno`),
	INDEX `FK_tbl_board_edit_tbl_board` (`bno`),
	CONSTRAINT `FK_tbl_board_edit_tbl_board` FOREIGN KEY (`bno`) REFERENCES `tbl_board` (`bno`)
)
COLLATE='utf8_bin'
ENGINE=InnoDB
;



CREATE TABLE `tbl_reply` (
	`rno` INT(11) NOT NULL AUTO_INCREMENT,
	`bno` INT(11) NOT NULL,
	`writer` VARCHAR(50) NOT NULL COLLATE 'utf8_bin',
	`content` TEXT NOT NULL COLLATE 'utf8_bin',
	`regDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updateDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`ip_adress` VARCHAR(50) NOT NULL COLLATE 'utf8_bin',
	`state` VARCHAR(10) NOT NULL COLLATE 'utf8_bin',
	`password` TEXT NULL COLLATE 'utf8_bin',
	PRIMARY KEY (`rno`)
)
COLLATE='utf8_bin'
ENGINE=InnoDB
;

CREATE TABLE `tbl_reply_history` (
	`hrno` INT(11) NOT NULL AUTO_INCREMENT,
	`rno` INT(11) NOT NULL,
	`bno` INT(11) NOT NULL,
	`writer` VARCHAR(50) NOT NULL COLLATE 'utf8_bin',
	`content` TEXT NOT NULL COLLATE 'utf8_bin',
	`regDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updateDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`ip_adress` VARCHAR(50) NOT NULL COLLATE 'utf8_bin',
	`state` VARCHAR(10) NOT NULL COLLATE 'utf8_bin',
	`password` TEXT NOT NULL COLLATE 'utf8_bin',
	PRIMARY KEY (`hrno`)
)
COLLATE='utf8_bin'
ENGINE=InnoDB
;
