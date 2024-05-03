-- 테이블 생성
CREATE TABLE tutorial (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   title VARCHAR(255),
   description VARCHAR(255),
   published BOOLEAN
);

-- 더미 데이터 삽입
INSERT INTO tutorial (title, description, published) VALUES ('Java Basics', 'A tutorial about Java basics', true);
INSERT INTO tutorial (title, description, published) VALUES ('Spring Boot Intro', 'Introduction to Spring Boot', true);
INSERT INTO tutorial (title, description, published) VALUES ('HTML for Beginners', 'Learn the basics of HTML', false);
INSERT INTO tutorial (title, description, published) VALUES ('CSS Essentials', 'Essential tips for using CSS', true);
INSERT INTO tutorial (title, description, published) VALUES ('JavaScript Advanced', 'Advanced concepts of JavaScript', false);
