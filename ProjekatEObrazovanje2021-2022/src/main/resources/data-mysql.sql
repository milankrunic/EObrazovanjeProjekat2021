INSERT INTO role(id, name, code) VALUES(1, 'ROLE_STUDENT', 'st');
INSERT INTO role(id, name, code) VALUES(2, 'ROLE_ADMINISTRATOR', 'admin');
INSERT INTO role(id, name, code) VALUES(3, 'ROLE_TEACHER', 'teach');

INSERT INTO USERS(id, first_name, last_name, username, password)--password: student2
VALUES(1, 'Svetozar', 'Brboric', 'brboric99', '$2y$12$.deK12/GGYtlWVM6ymDEkO0rhXBIkyKTdwog3174yx6R/6FD4Y7V2');
INSERT INTO USERS(id, first_name, last_name, username, password)--password: student1
VALUES(4, 'Dejan', 'Rakin', 'rakin99', '$2a$10$ICJS6CRYqX636bjUsKPQEenmASoFSycNdTKe78GEN9u2FINXSkHya');
INSERT INTO USERS(id, first_name, last_name, username, password)--password: admin
VALUES(2, 'Milos', 'Milosevic', 'milosevoic123', '$2y$12$/0/Hb9rthBfdtIFQ9xo5..7PIM59xYH6F4/WI5tFg1etygn5kajDa');
INSERT INTO USERS(id, first_name, last_name, username, password)--password: teacher1
VALUES(3, 'Goran', 'Savic', 'savic123', '$2y$12$gdPJQKybWvH6wbDOexRJjOX7MS8rJjNxDJf7uUTNJuW/46OM6D24y');

INSERT INTO user_role(user_id, role_id) VALUES(1, 1);
INSERT INTO user_role(user_id, role_id) VALUES(4, 1);
INSERT INTO user_role(user_id, role_id) VALUES(2, 2);
INSERT INTO user_role(user_id, role_id) VALUES(3, 3);

INSERT INTO STUDENTS(id, card_number, user_id) VALUES(1, 'SF-21-2018', 1);
INSERT INTO STUDENTS(id, card_number, user_id) VALUES(2, 'SF-27-2018', 4);

INSERT INTO administrators(id, user_id) VALUES(1, 2);

INSERT INTO teachers(id, user_id) VALUES(1, 3);

INSERT INTO ACCOUNTS(id, amount, student_id) VALUES(1, 1000, 1);
INSERT INTO ACCOUNTS(id, amount, student_id) VALUES(2, 500, 2);

INSERT INTO course_specification(id, title, ects, code) VALUE(1, 'eObrazovanje', 7, 'eObr');
INSERT INTO course_specification(id, title, ects, code) VALUE(2, 'eUprava', 6, 'eUpr');
INSERT INTO course_specification(id, title, ects, code) VALUE(3, 'mreze', 6, 'mr');

INSERT INTO course_instance(id, start_date, end_date, course_specification_id) VALUES(1, '2020-02-10', '2021-07-07', 1);
INSERT INTO course_instance(id, start_date, end_date, course_specification_id) VALUES(2, '2020-02-10', '2021-07-07', 2);
INSERT INTO course_instance(id, start_date, end_date, course_specification_id) VALUES(3, '2020-02-10', '2021-07-07', 3);

INSERT INTO teaching_type(id, name, code) VALUES(1, 'exercise', 'ex');
INSERT INTO teaching_type(id, name, code) VALUES(2, 'lecture', 'lec');

INSERT INTO enrollments(id, student_id, course_instance_id) VALUES(1, 1, 1);
INSERT INTO enrollments(id, student_id, course_instance_id) VALUES(2, 2, 1);
INSERT INTO enrollments(id, student_id, course_instance_id) VALUES(3, 1, 2);
INSERT INTO enrollments(id, student_id, course_instance_id) VALUES(4, 1, 3);

INSERT INTO teachings(id, teaching_type_id, teacher_id, course_instance_id) VALUES(1, 2, 1, 1);

INSERT INTO type_document(id, name, code) VALUES(1,'Diploma','di');
INSERT INTO type_document(id, name, code) VALUES(2,'Form','fo');

INSERT INTO exams(id, points, gradle, enrollment_id) VALUES(1, 0, 0, 1);
INSERT INTO exams(id, points, gradle, enrollment_id) VALUES(2, 0, 0, 2);
INSERT INTO exams(id, points, gradle, enrollment_id) VALUES(3, 0, 0, 3);
INSERT INTO exams(id, points, gradle, enrollment_id) VALUES(4, 0, 0, 4);

INSERT INTO exam_part_types(id,name,code) VALUES (1,'Colloquium','colloq');
INSERT INTO exam_part_types(id,name,code) VALUES (2,'Oral exam','oral');

INSERT INTO exam_part_status(id,name,code) VALUES (1,'Passed','pa');
INSERT INTO exam_part_status(id,name,code) VALUES (2,'Created','cr');
INSERT INTO exam_part_status(id,name,code) VALUES (3,'False','fa');
INSERT INTO exam_part_status(id,name,code) VALUES (4,'Canceled','ca');
INSERT INTO exam_part_status(id,name,code) VALUES (5,'Registred','re');

INSERT INTO exam_parts(id, date_exam_part, location, points,won_points,exam_id,exam_part_type_id,exam_part_status_id,code) 
VALUES(1, '2021-03-21 13:15:00', 'Location1', 30,0, 1, 1, 2,'1-1');

INSERT INTO exam_parts(id, date_exam_part, location, points,won_points,exam_id,exam_part_type_id,exam_part_status_id,code) 
VALUES(2, '2021-03-21 13:15:00', 'Location1', 30,0, 2, 1, 2,'1-1');
INSERT INTO exam_parts(id, date_exam_part, location, points, won_points,exam_id,exam_part_type_id,exam_part_status_id,code) 
VALUES(3, '2021-03-21 13:17:00', 'Location2', 15,0, 4, 1, 3,'2-1');

INSERT INTO payments(id, currency, amount, date_payment, urgently, note, account_id)
VALUES (id, 'RSD', 3000, '2021-03-21', 0, 'Overa semestra', 1);

INSERT INTO payments(id, currency, amount, date_payment, urgently, note, account_id)
VALUES (id, 'RSD', 500, '2021-03-21', 0, 'Prijava ispita', 2)