
-- ---------------------- web ---------------------------------- --
DROP TABLE IF EXISTS point;
DROP TABLE if EXISTS member;

CREATE TABLE member (
    mno   INT UNSIGNED AUTO_INCREMENT,  -- 회원 번호 (기본키)
    mid   VARCHAR(50) NOT NULL UNIQUE,     -- 회원 아이디
    mpwd  VARCHAR(255) NOT NULL,           -- 비밀번호
    mname VARCHAR(100) NOT NULL,           -- 회원 이름
    mimg  VARCHAR(255) DEFAULT NULL,        -- 프로필 이미지 URL
    CONSTRAINT PRIMARY KEY(mno)
);

CREATE TABLE point (
    pno     INT UNSIGNED AUTO_INCREMENT,  -- 포인트 번호 (기본키)
    mno     INT UNSIGNED NOT NULL,         -- 회원 번호 (외래키)
    amount  INT NOT NULL DEFAULT 0,        -- 지급된 포인트
    pdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 지급 시간
    CONSTRAINT PRIMARY KEY(pno),
    CONSTRAINT FK_point_member FOREIGN KEY(mno) REFERENCES member(mno) ON DELETE CASCADE
);

-- ---------------------- day11 ---------------------------------- --
DROP TABLE IF EXISTS day11products;
CREATE TABLE day11products (
    product_id INT PRIMARY KEY AUTO_INCREMENT, -- 상품 ID (자동 증가)
    product_name VARCHAR(255) NOT NULL,        -- 상품명
    stock_quantity INT NOT NULL                -- 재고 수량
);

-- ---------------------- day08 ---------------------------------- --
DROP TABLE if EXISTS productsample;
create table productsample(
	id int auto_increment ,
    name varchar(20) ,
    price int ,
    comment longtext ,
    constraint primary key ( id )
);
-- ---------------------- ------ ---------------------------------- --


-- ---------------------- day05 ---------------------------------- --
-- 학생 테이블
DROP TABLE if EXISTS student_score;
DROP TABLE if EXISTS student;

CREATE TABLE student (
    sno INT AUTO_INCREMENT,              -- 학생 번호 (자동 증가)
    name VARCHAR(50) NOT NULL,           -- 이름
    kor INT NOT NULL,                    -- 국어 점수
    math INT NOT NULL,                    -- 수학 점수
    CONSTRAINT  PRIMARY KEY (sno)  -- 기본키 제약 조건 추가
);
-- 성적 기록 테이블 (트랜잭션 실습용)
CREATE TABLE student_score (
    score_id INT AUTO_INCREMENT,          -- 성적 ID (자동 증가)
    sno INT NOT NULL,                     -- 학생 번호 (외래키)
    subject VARCHAR(20) NOT NULL,         -- 과목명 ('국어' 또는 '수학')
    score INT NOT NULL,                   -- 점수
    CONSTRAINT  PRIMARY KEY (score_id),  -- 기본키 제약 조건 추가
    CONSTRAINT  FOREIGN KEY (sno) REFERENCES student(sno)  -- 외래키 제약 조건 추가
);
-- ---------------------- ------ ---------------------------------- --
