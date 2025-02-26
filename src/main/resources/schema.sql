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