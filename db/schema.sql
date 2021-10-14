# 사용자 생성
GRANT ALL PRIVILEGES ON *.* TO sbsst@`%` IDENTIFIED BY 'sbs123412';
CREATE USER  sbsst@`%` IDENTIFIED BY 'sbs123412';
GRANT ALL PRIVILEGES ON *.* TO sbsst@`%`;

# DB 생성
DROP DATABASE IF EXISTS sb_c_2021_2nd;
CREATE DATABASE sb_c_2021_2nd;

use sb_c_2021_2nd;

# 게시물 테이블 생성
DROP TABLE article;

CREATE TABLE article (
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
updateDate DATETIME NOT NULL,
title CHAR(100) NOT NULL,
body TEXT NOT NULL
);

# 게시물, 테스트 데이터 생성
INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목1',
body = '내용1';

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목2',
body = '내용2';

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목3',
body = '내용3';

SELECT * FROM article;

# 마지막 인서트된 ID
SELECT LAST_INSERT_ID();  

# 회원 테이블 생성
DROP TABLE member;

CREATE TABLE member(
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
updateDate DATETIME NOT NULL,
loginId CHAR(20) NOT NULL,
loginPw CHAR(60) NOT NULL,
authLevel SMALLINT(2) UNSIGNED DEFAULT 3 COMMENT '(3=일반, 7=관리자)', 
name CHAR(20) NOT NULL,
nickname CHAR(20) NOT NULL,
cellphoneNo CHAR(20) NOT NULL,
email CHAR(50) NOT NULL,
delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '탈퇴여부(9=탈퇴전, 1=탈퇴)',
delDate DATETIME COMMENT '탈퇴날짜'
);



# 회원 테스트 데이터 생성(관리자회원)
INSERT INTO member
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'admin',
loginPw = 'admin',
authLevel = 7, 
name = '관리자',
nickname = '관리자',
cellphoneNo = '01012341234',
email = 'mailislove@daum.net';

# 회원 테스트 데이터 생성(일반회원1)
INSERT INTO member
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user1',
loginPw = 'user1',
name = '사용자1',
nickname = '사용자1',
cellphoneNo = '01012341234',
email = 'mailislove@daum.net';

# 회원 테스트 데이터 생성(일반회원2)
INSERT INTO member
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user2',
loginPw = 'user2',
name = '사용자2',
nickname = '사용자2',
cellphoneNo = '01012341234',
email = 'mailislove@daum.net';

select * from member;