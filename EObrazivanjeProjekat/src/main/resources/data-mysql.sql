INSERT INTO role(id, name, code) VALUES(1, 'ROLE_STUDENT', 'st');
INSERT INTO role(id, name, code) VALUES(2, 'ROLE_ADMINISTRATOR', 'admin');
INSERT INTO role(id, name, code) VALUES(3, 'ROLE_TEACHER', 'teach');

INSERT INTO USER(id, first_name, last_name, email, username, password)--maric99
VALUES(1, 'Mihailo', 'Maric', 'maric@gmail.com', 'maric99', '$2a$12$XlgmvSXFkvNAF4dzxZ/gvebt9QnMavqw54w8Bf2SkH5rOxeABtG2K');
INSERT INTO USER(id, first_name, last_name, email, username, password)-- ivan99
VALUES(4, 'Ivan', 'Stankovic', 'stankovic@gmail.com', 'ivan99', '$2a$12$21qZE5wGxTy2XYZVts0Ahe9mwi8sYNwF4z2nRkObIlo9bvz25SEiq');
INSERT INTO USER(id, first_name, last_name, email, username, password)-- ziga99
VALUES(2, 'Dario', 'Ziga', 'ziga@gmail.com', 'ziga99', '$2a$12$aEvdU3Zn9HHwGSuwmmPsI.Wx/g8oXbYJMmF54GcKPFfR.pVZIHzLC');
INSERT INTO USER(id, first_name, last_name, email, username, password)-- kruna99
VALUES(3, 'Milan', 'Krunic', 'krunic@gmail.com', 'kruna99', '$2a$12$zdUwdyVKM0ngD/a4UbFs.OkPTmrh70Jjn24obI3in88YChRH.7oRu');



INSERT INTO user_role(user_id, role_id) VALUES(1, 1);
INSERT INTO user_role(user_id, role_id) VALUES(4, 1);
INSERT INTO user_role(user_id, role_id) VALUES(2, 2);
INSERT INTO user_role(user_id, role_id) VALUES(3, 3);

INSERT INTO Admin(id_admin, id_user) VALUES (1,3);

INSERT INTO teacher(id_teacher, id_user) VALUES (1,4);


INSERT INTO Student(id_student, card_number, id_user) VALUES (1, 'SF-12-2020',1);
INSERT INTO Student(id_student, card_number, id_user) VALUES (2, 'SF-19-2020',2);


INSERT INTO document_type(id_dokument_type, name, code) VALUES (1, 'document1','D1');
INSERT INTO document_type(id_dokument_type, name, code) VALUES (2, 'document2','D2');

INSERT INTO Document(id_dokument, title,url,student,document_type) VALUES (1, 'nesto1','nesto1.com',2,1);
INSERT INTO Document(id_dokument, title,url,student,document_type) VALUES (2, 'nesto2','nesto2.com',1,2);

INSERT INTO course_specification(id,title,ects,code) VALUES (1,'Matematika1',8,'mat1');
INSERT INTO course_specification(id,title,ects,code) VALUES (2,'Web programiranje',8,'wpro');
INSERT INTO course_specification(id,title,ects,code) VALUES (3,'Matematika2',8,'mat2');

INSERT INTO course_instance(id_course_instance,start_date,end_date,course_specification) VALUES (1, '25-02-2021','19-06-2021', 3);
INSERT INTO course_instance(id_course_instance,start_date,end_date,course_specification) VALUES (2,'02-10-2020','20-12-2020', 1);
INSERT INTO course_instance(id_course_instance,start_date,end_date,course_specification) VALUES (3,'25-02-2021','19-06-2021', 2);

INSERT INTO account(id_account,amount, student) VALUES (1,2000.00, 2);
INSERT INTO account(id_account,amount, student) VALUES (2,1500.00,1);


INSERT INTO Enrollment(id_enrollment,course_instance, student) VALUES (1, 2, 1);
INSERT INTO Enrollment(id_enrollment,course_instance, student) VALUES (2, 1, 2);

INSERT INTO exam(id_exam,points, grade, enrollment) VALUES (1, 40, 3, 1);
INSERT INTO exam(id_exam,points, grade, enrollment) VALUES (2, 70, 1, 2);

INSERT INTO exam_part_status(id_exam_part_status,name, code) VALUES (1, 'ZAKAZAN', 'ZA');
INSERT INTO exam_part_status(id_exam_part_status,name, code) VALUES (2, 'OTKAZAN', 'OT');

INSERT INTO exam_part_type(id_exam_part_type,name, code) VALUES (1, 'KOLOKVIJUM', 'KOL');
INSERT INTO exam_part_type(id_exam_part_type,name, code) VALUES (2, 'USMENI_ISPIT', 'UI');
INSERT INTO exam_part_type(id_exam_part_type,name, code) VALUES (3, 'TEST', 'TE');

INSERT INTO exam_part(id_exam_part,date_exam_part, location, points, exam, exam_part_type, exam_part_status) VALUES (1, '2021-09-25','NTP-301', 30, 1, 3, 2);
INSERT INTO exam_part(id_exam_part,date_exam_part, location, points, exam, exam_part_type, exam_part_status) VALUES (2, '2021-09-10','NTP-310', 50, 2, 2, 1);
INSERT INTO exam_part(id_exam_part,date_exam_part, location, points, exam, exam_part_type, exam_part_status) VALUES (3, '2021-10-17','NTP-307', 70, 2, 1, 1);

INSERT INTO student_payments(id_student_payments,amount, date, name, account) VALUES (1, 200, '2021-04-12', 'prijava ispita', 1);
INSERT INTO student_payments(id_student_payments,amount, date, name, account) VALUES (2, 400, '2021-01-05', 'prijava ispita', 2);

INSERT INTO Teaching_type(id_teaching_type,name_teaching_type, code) VALUES (1, 'PREDAVANJE', 'PR');
INSERT INTO Teaching_type(id_teaching_type,name_teaching_type, code) VALUES (2, 'VEZBE', 'VE');

INSERT INTO Teaching(id_teaching,course_instance, teacher, teaching_type) VALUES (1, 3, 1, 1);
INSERT INTO Teaching(id_teaching,course_instance, teacher, teaching_type) VALUES (2, 1, 1, 2);
INSERT INTO Teaching(id_teaching,course_instance, teacher, teaching_type) VALUES (3, 2, 1, 1);