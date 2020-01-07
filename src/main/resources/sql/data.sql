INSERT INTO `pm`.`user` (employee_id, first_name, last_name) VALUES (1, 'Nithish', 'Sabapathy');
INSERT INTO `pm`.`user` (employee_id, first_name, last_name) VALUES (2, 'Harish', 'Sabapathy');

INSERT INTO `pm`.`project` (name, start_date, end_date, priority) VALUES ('ProjONE', CURDATE(), '2020-11-30', 1);
INSERT INTO `pm`.`project` (name, start_date, end_date, priority) VALUES ('ProjTWO', CURDATE(), '2020-12-31', 2);

INSERT INTO `pm`.`parent_task` (name) VALUES ('ParentTaskONE');
INSERT INTO `pm`.`parent_task` (name) VALUES ('ParentTaskTWO');
