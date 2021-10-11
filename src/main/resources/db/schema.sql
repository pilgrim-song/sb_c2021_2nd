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

articleINSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목3',
body = '내용3';

SELECT * FROM article;