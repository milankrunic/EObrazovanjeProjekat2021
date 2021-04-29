INSERT INTO user(username, password) VALUES ('perap','pera123');
INSERT INTO user(username, password) VALUES ('jovaj','jova123');
INSERT INTO user(username, password) VALUES ('laza','laza123');
INSERT INTO user(username, password) VALUES ('mikam','mika123');
INSERT INTO user(username, password) VALUES ('zikaz','zika123');
INSERT INTO user(username, password) VALUES ('simas','sima123');
INSERT INTO user(username, password) VALUES ('markom','marko123');

INSERT INTO Admin(first_name,last_name,email,user) VALUES ('Marko','Markovic','marko@gmail.com',7);

INSERT INTO teacher(first_name,last_name,email,id_user) VALUES ('Pera','Peric','pera@gmail.com',1);
INSERT INTO teacher(first_name,last_name,email,id_user) VALUES ('Jova','Jovic','jova@gmail.com',2);
INSERT INTO teacher(first_name,last_name,email,id_user) VALUES ('Laza','Lazic','laza@gmail.com',3);

INSERT INTO Student(first_name,last_name,card_number,email, user) VALUES ('Mika','Mikic', 'SF-12-2020','mika@gmail.com',4);
INSERT INTO Student(first_name,last_name,card_number,email, user) VALUES ('Zika','Zikic', 'SF-19-2020','zika@gmail.com',5);
INSERT INTO Student(first_name,last_name,card_number,email, user) VALUES ('Sima','Simic', 'SF-25-2020','sima@gmail.com',6);

INSERT INTO document_type(name, code) VALUES ('document1','D1');
INSERT INTO document_type(name, code) VALUES ('document2','D2');

INSERT INTO Document(title,url,student,document_type) VALUES ('nesto1','nesto1.com',2,1);
INSERT INTO Document(title,url,student,document_type) VALUES ('nesto2','nesto2.com',1,2);

INSERT INTO course_specification(title,ects,code) VALUES ('Matematika1',8,'mat1');
INSERT INTO course_specification(title,ects,code) VALUES ('Web programiranje',8,'wpro');
INSERT INTO course_specification(title,ects,code) VALUES ('Matematika2',8,'mat2');

INSERT INTO course_instance(start_date,end_date,course_specification) VALUES ('25-02-2021','19-06-2021', 3);
INSERT INTO course_instance(start_date,end_date,course_specification) VALUES ('02-10-2020','20-12-2020', 1);
INSERT INTO course_instance(start_date,end_date,course_specification) VALUES ('25-02-2021','19-06-2021', 2);

INSERT INTO account(amount, student) VALUES (2000.00, 2);
INSERT INTO account(amount, student) VALUES (1500.00,1);
INSERT INTO account(amount, student) VALUES (500.00,3);

INSERT INTO Enrollment(course_instance, student) VALUES (2, 1);
INSERT INTO Enrollment(course_instance, student) VALUES (3, 3);
INSERT INTO Enrollment(course_instance, student) VALUES (1, 2);

INSERT INTO exam(points, grade, enrollment) VALUES (40, 3, 1);
INSERT INTO exam(points, grade, enrollment) VALUES (50, 4, 2);
INSERT INTO exam(points, grade, enrollment) VALUES (70, 1, 3);

INSERT INTO exam_part_status(name, code) VALUES ('ZAKAZAN', 'ZA');
INSERT INTO exam_part_status(name, code) VALUES ('OTKAZAN', 'OT');

INSERT INTO exam_part_type(name, code) VALUES ('KOLOKVIJUM', 'KOL');
INSERT INTO exam_part_type(name, code) VALUES ('USMENI_ISPIT', 'UI');
INSERT INTO exam_part_type(name, code) VALUES ('TEST', 'TE');

INSERT INTO exam_part(date_exam_part, location, points, exam, exam_part_type, exam_part_status) VALUES ('2021-09-25','NTP-301', 30, 1, 3, 2);
INSERT INTO exam_part(date_exam_part, location, points, exam, exam_part_type, exam_part_status) VALUES ('2021-09-10','NTP-310', 50, 3, 2, 1);
INSERT INTO exam_part(date_exam_part, location, points, exam, exam_part_type, exam_part_status) VALUES ('2021-10-17','NTP-307', 70, 2, 1, 1);

INSERT INTO student_payments(amount, date, name, account) VALUES (200, '2021-04-12', 'prijava ispita', 1);
INSERT INTO student_payments(amount, date, name, account) VALUES (400, '2021-01-05', 'prijava ispita', 3);

INSERT INTO Teaching_type(name_teaching_type, code) VALUES ('PREDAVANJE', 'PR');
INSERT INTO Teaching_type(name_teaching_type, code) VALUES ('VEZBE', 'VE');

INSERT INTO Teaching(course_instance, teacher, teaching_type) VALUES (3, 2, 1);
INSERT INTO Teaching(course_instance, teacher, teaching_type) VALUES (1, 2, 2);
INSERT INTO Teaching(course_instance, teacher, teaching_type) VALUES (2, 1, 1);