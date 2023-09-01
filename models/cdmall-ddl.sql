-- Drop Table
DROP TABLE IF EXISTS `album` RESTRICT;
DROP TABLE IF EXISTS `song` RESTRICT;
DROP TABLE IF EXISTS `company` RESTRICT;
DROP TABLE IF EXISTS `artist` RESTRICT;
DROP TABLE IF EXISTS `genre` RESTRICT;
DROP TABLE IF EXISTS `genre_song` RESTRICT;

-- Drop
ALTER TABLE `album`
	DROP FOREIGN KEY `FK_company_TO_album`; -- 배급사 -> 앨범
ALTER TABLE `song`
	DROP FOREIGN KEY `FK_album_TO_song`; -- 앨범 -> 노래
ALTER TABLE `song`
	DROP FOREIGN KEY `FK_artist_TO_song`; -- 가수 -> 노래
ALTER TABLE `genre_song`
	DROP FOREIGN KEY `FK_song_TO_genre_song`; -- 노래 -> 장르_노래
ALTER TABLE `genre_song`
	DROP FOREIGN KEY `FK_genre_TO_genre_song`; -- 장르 -> 장르_노래

-- Create Table
-- 앨범
CREATE TABLE `album` (
	`no`         int         NOT NULL COMMENT '번호', -- 번호
	`title`      varchar(45) NOT NULL COMMENT '제목', -- 제목
	`company_no` int         NOT NULL COMMENT '배급사번호' -- 배급사번호
)
COMMENT '앨범';

ALTER TABLE `album`
	ADD CONSTRAINT `PK_album` -- 앨범 기본키
		PRIMARY KEY (
			`no` -- 번호
		);

ALTER TABLE `album`
	MODIFY COLUMN `no` int NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 노래
CREATE TABLE `song` (
	`no`        int          NOT NULL COMMENT '번호', -- 번호
	`title`     varchar(100) NOT NULL COMMENT '제목', -- 제목
	`album_no`  int          NOT NULL COMMENT '앨범번호', -- 앨범번호
	`artist_no` int          NOT NULL COMMENT '가수번호' -- 가수번호
)
COMMENT '노래';

ALTER TABLE `song`
	ADD CONSTRAINT `PK_song` -- 노래 기본키
		PRIMARY KEY (
			`no` -- 번호
		);

ALTER TABLE `song`
	MODIFY COLUMN `no` int NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 배급사
CREATE TABLE `company` (
	`no`   int         NOT NULL COMMENT '번호', -- 번호
	`name` varchar(45) NOT NULL COMMENT '이름', -- 이름
	`ceo`  varchar(45) NULL     COMMENT '대표자' -- 대표자
)
COMMENT '배급사';

ALTER TABLE `company`
	ADD CONSTRAINT `PK_company` -- 배급사 기본키
		PRIMARY KEY (
			`no` -- 번호
		);

ALTER TABLE `company`
	MODIFY COLUMN `no` int NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 가수
CREATE TABLE `artist` (
	`no`      int         NOT NULL COMMENT '번호', -- 번호
	`name`    varchar(45) NULL     COMMENT '이름', -- 이름
	`profile` text        NULL     COMMENT '프로필' -- 프로필
)
COMMENT '가수';

ALTER TABLE `artist`
	ADD CONSTRAINT `PK_artist` -- 가수 기본키
		PRIMARY KEY (
			`no` -- 번호
		);

ALTER TABLE `artist`
	MODIFY COLUMN `no` int NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 장르
CREATE TABLE `genre` (
	`no`   int         NOT NULL COMMENT '번호', -- 번호
	`name` varchar(45) NOT NULL COMMENT '이름', -- 이름
	`abbr` varchar(10) NOT NULL COMMENT '약어' -- 약어
)
COMMENT '장르';

ALTER TABLE `genre`
	ADD CONSTRAINT `PK_genre` -- 장르 기본키
		PRIMARY KEY (
			`no` -- 번호
		);

ALTER TABLE `genre`
	MODIFY COLUMN `no` int NOT NULL AUTO_INCREMENT COMMENT '번호';

-- 장르_노래
CREATE TABLE `genre_song` (
	`song_no`  int NOT NULL COMMENT '노래번호', -- 노래번호
	`genre_no` int NOT NULL COMMENT '장르번호' -- 장르번호
)
COMMENT '장르_노래';

-- 앨범
ALTER TABLE `album`
	ADD CONSTRAINT `FK_company_TO_album` -- 배급사 -> 앨범
		FOREIGN KEY (
			`company_no` -- 배급사번호
		)
		REFERENCES `company` ( -- 배급사
			`no` -- 번호
		);

-- 노래
ALTER TABLE `song`
	ADD CONSTRAINT `FK_album_TO_song` -- 앨범 -> 노래
		FOREIGN KEY (
			`album_no` -- 앨범번호
		)
		REFERENCES `album` ( -- 앨범
			`no` -- 번호
		);

ALTER TABLE `song`
	ADD CONSTRAINT `FK_artist_TO_song` -- 가수 -> 노래
		FOREIGN KEY (
			`artist_no` -- 가수번호
		)
		REFERENCES `artist` ( -- 가수
			`no` -- 번호
		);

-- 장르_노래
ALTER TABLE `genre_song`
	ADD CONSTRAINT `FK_song_TO_genre_song` -- 노래 -> 장르_노래
		FOREIGN KEY (
			`song_no` -- 노래번호
		)
		REFERENCES `song` ( -- 노래
			`no` -- 번호
		);

ALTER TABLE `genre_song`
	ADD CONSTRAINT `FK_genre_TO_genre_song` -- 장르 -> 장르_노래
		FOREIGN KEY (
			`genre_no` -- 장르번호
		)
		REFERENCES `genre` ( -- 장르
			`no` -- 번호
		);