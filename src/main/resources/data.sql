
-- ---------------------- web ---------------------------------- --
INSERT INTO member (mid, mpwd, mname) VALUES
('user1', 'password123', '김철수'),
('user2', 'qwerty456', '이영희'),
('user3', 'abcde789', '박민준'),
('user4', 'helloWorld', '정다은'),
('user5', 'son1234', '손흥민');
-- ---------------------- day13 ---------------------------------- --
INSERT INTO day13users (name, money) VALUES
('서장훈', 500000),
('신동엽', 300000);

-- ---------------------- day11 ---------------------------------- --
INSERT INTO day11products (product_name, stock_quantity) VALUES
('무선 이어폰', 25),
('스마트워치', 12),
('게이밍 키보드', 30),
('기계식 마우스', 8),
('휴대용 충전기', 15);


-- ---------------------- day08 ---------------------------------- --
insert into productsample( name , price , comment ) values ( '코카콜라' , 1000 , '맛있는 코카콜라' );
insert into productsample( name , price , comment ) values ( '사이다' , 1700 , '제로 사이다입니다.' );
insert into productsample( name , price , comment ) values ( '환타' , 2000 , '새로나온 환타 맛 입니다.' );
-- ---------------------- ------ ---------------------------------- --
-- ---------------------- day05 ---------------------------------- --
-- 학생 테이블 샘플 데이터 삽입
-- INSERT INTO student (name, kor, math) VALUES ('김철수', 90, 85);
-- INSERT INTO student (name, kor, math) VALUES ('이영희', 78, 92);
-- INSERT INTO student (name, kor, math) VALUES ('박민수', 88, 76);
INSERT
    INTO student (name, kor, math)
    VALUES ('김철수', 90, 85) ,
            ('이영희', 78, 92) ,
            ('박민수', 88, 76) ;

-- 성적 테이블 샘플 데이터 삽입 (트랜잭션 실습을 위해 일부 데이터만 추가)
INSERT INTO student_score (sno, subject, score) VALUES (1, '국어', 90);
INSERT INTO student_score (sno, subject, score) VALUES (1, '수학', 85);
INSERT INTO student_score (sno, subject, score) VALUES (2, '국어', 78);
INSERT INTO student_score (sno, subject, score) VALUES (2, '수학', 92);

-- ---------------------- ------ ---------------------------------- --