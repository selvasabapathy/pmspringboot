-- Data to use during development

INSERT INTO `pm`.`project` (name, start_date, end_date, priority) VALUES ('ProjJava', '2020-01-01', '2020-11-30', 4);
INSERT INTO `pm`.`project` (name, start_date, end_date, priority) VALUES ('ProjDotNet', '2020-01-02', '2020-12-31', 8);

INSERT INTO `pm`.`parent_task` (name) VALUES ('Dev');
INSERT INTO `pm`.`parent_task` (name) VALUES ('Test');

INSERT INTO `pm`.`task` (project_id, name, start_date, end_date, priority, status) VALUES (1, 'Requirements', '2020-01-01', '2020-01-05', 1, TRUE);
INSERT INTO `pm`.`task` (parent_task_id, project_id, name, start_date, end_date, priority, status) VALUES (1, 1, 'Angular Dev', CURDATE(), '2020-03-31', 3, FALSE);
INSERT INTO `pm`.`task` (parent_task_id, project_id, name, start_date, end_date, priority, status) VALUES (1, 1, 'Spring Dev', '2020-03-01', '2020-06-30', 6, FALSE);
INSERT INTO `pm`.`task` (parent_task_id, project_id, name, start_date, end_date, priority, status) VALUES (2, 1, 'Manual Test', '2020-04-01', '2020-07-31', 9, FALSE);
INSERT INTO `pm`.`task` (parent_task_id, project_id, name, start_date, end_date, priority, status) VALUES (2, 1, 'Automation', '2020-05-01', '2020-07-31', 12, FALSE);
INSERT INTO `pm`.`task` (project_id, name, start_date, end_date, priority, status) VALUES (1, 'Release', '2020-08-01', '2020-11-30', 1, FALSE);

INSERT INTO `pm`.`task` (project_id, name, start_date, end_date, priority, status) VALUES (2, 'Requirements', '2020-01-02', '2020-01-06', 1, TRUE);
INSERT INTO `pm`.`task` (parent_task_id, project_id, name, start_date, end_date, priority, status) VALUES (1, 2, 'Angular Dev', CURDATE(), '2020-04-30', 4, FALSE);
INSERT INTO `pm`.`task` (parent_task_id, project_id, name, start_date, end_date, priority, status) VALUES (1, 2, 'NodeJS Dev', '2020-03-01', '2020-07-31', 8, FALSE);
INSERT INTO `pm`.`task` (parent_task_id, project_id, name, start_date, end_date, priority, status) VALUES (2, 2, 'Manual Test', '2020-05-01', '2020-08-31', 12, FALSE);
INSERT INTO `pm`.`task` (parent_task_id, project_id, name, start_date, end_date, priority, status) VALUES (2, 2, 'Automation', '2020-06-01', '2020-08-31', 16, FALSE);
INSERT INTO `pm`.`task` (project_id, name, start_date, end_date, priority, status) VALUES (2, 'Release', '2020-09-01', '2020-12-31', 1, FALSE);

INSERT INTO `pm`.`user` (employee_id, first_name, last_name, project_id) VALUES (1, 'AngSpring', 'Manager', 1);
INSERT INTO `pm`.`user` (employee_id, first_name, last_name, project_id) VALUES (2, 'AngNodeJS', 'Manager', 2);
INSERT INTO `pm`.`user` (employee_id, first_name, last_name) VALUES (3, 'Floating', 'Analyst');
INSERT INTO `pm`.`user` (employee_id, first_name, last_name, task_id) VALUES (4, 'Ang', 'Developer', 2);
INSERT INTO `pm`.`user` (employee_id, first_name, last_name,task_id) VALUES (4, 'Ang', 'Developer', 8);
INSERT INTO `pm`.`user` (employee_id, first_name, last_name,task_id) VALUES (5, 'Spring', 'Developer', 3);
INSERT INTO `pm`.`user` (employee_id, first_name, last_name,task_id) VALUES (6, 'NodeJS', 'Developer', 9);
INSERT INTO `pm`.`user` (employee_id, first_name, last_name,task_id) VALUES (7, 'Manual', 'Tester', 4);
INSERT INTO `pm`.`user` (employee_id, first_name, last_name,task_id) VALUES (8, 'Automation', 'Tester', 11);
INSERT INTO `pm`.`user` (employee_id, first_name, last_name) VALUES (9, 'Floating', 'Release');
