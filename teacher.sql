CREATE DATABASE teacher;
use teacher;

DROP TABLE IF EXISTS t_root;
CREATE TABLE t_root (
    id int(11) NOT NULL AUTO_INCREMENT,
    admin_name varchar(255) NOT NULL,
    admin_password VARCHAR(255) NOT NULL,
    create_time TIMESTAMP NOT NULL default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    PRIMARY KEY (id),
    UNIQUE KEY UK_NAME (admin_name)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO t_root (admin_name, admin_password) VALUE ("root", "123456");

DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
    id INT(11) NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_nickname VARCHAR(255) NOT NULL,
    user_images VARCHAR(255) DEFAULT NULL COMMENT "头像",
    user_birthday TIMESTAMP NOT NULL,
    user_type INT(10) NOT NULL,
    user_title VARCHAR(255) DEFAULT "助教" COMMENT "职称",
    user_flag INT(10) DEFAULT 1,
    create_time TIMESTAMP NOT NULL default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    PRIMARY KEY (id),
    UNIQUE KEY UK_NAME (user_name)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO t_user(user_name, user_pwd, user_nickname, user_images, user_type, user_title, user_flag) VALUE ("zdh", "123321", "赵代红", "/", 100, "副教授", 1);
INSERT INTO t_user(user_name, user_pwd, user_nickname, user_images, user_type, user_title, user_flag) VALUE ("zdh1", "123321", "赵代红1", "/", 100, "教授", 1);
INSERT INTO t_user(user_name, user_pwd, user_nickname, user_images, user_type, user_title, user_flag) VALUE ("zdh2", "123321", "赵代红2", "/", 101, "领导", 1);

DROP TABLE IF EXISTS t_lesson;
CREATE TABLE t_lesson (
    id INT(11) NOT NULL AUTO_INCREMENT,
    lesson_name VARCHAR(255) NOT NULL,
    lesson_describe TEXT DEFAULT NULL,
    lesson_image VARCHAR(255) DEFAULT NULL,
    lesson_class_hour INT DEFAULT 0 COMMENT "课时",
    lesson_flag INT DEFAULT 1,
    create_time TIMESTAMP NOT NULL default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    PRIMARY KEY (id),
    UNIQUE KEY UK_NAME (lesson_name)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO t_lesson (lesson_name, lesson_describe, lesson_image, lesson_class_hour) VALUE ("Java从入门到放弃", "赶紧放弃吧", "/", 40);
INSERT INTO t_lesson (lesson_name, lesson_describe, lesson_image, lesson_class_hour) VALUE ("SQL从入门到删库跑路", "rm -rf", "/", 40);

DROP TABLE IF EXISTS t_select_lesson;
CREATE TABLE t_select_lesson (
    id INT(11) NOT NULL AUTO_INCREMENT,
    user_id INT(11) NOT NULL,
    lesson_id INT(11) NOT NULL,
    lesson_hour int DEFAULT 0 COMMENT "已修课时",
    select_lesson_flag INT DEFAULT 1,
    create_time TIMESTAMP NOT NULL default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    PRIMARY KEY (id),
    CONSTRAINT fk_uid FOREIGN KEY (user_id) REFERENCES t_user (id),
    CONSTRAINT fk_lid FOREIGN KEY (lesson_id) REFERENCES t_lesson(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO t_select_lesson (user_id, lesson_id, lesson_hour) VALUE (1,1,29);
INSERT INTO t_select_lesson (user_id, lesson_id, lesson_hour) VALUE (1,2,20);
INSERT INTO t_select_lesson (user_id, lesson_id, lesson_hour) VALUE (2,1,13);

DROP TABLE IF EXISTS t_bbs;
CREATE TABLE t_bbs (
    id INT(11) NOT NULL AUTO_INCREMENT,
    bbs_title VARCHAR(255) NOT NULL,
    bbs_content TEXT NOT NULL,
    bbs_author VARCHAR(255) NOT NULL,
    bbs_flag INT DEFAULT 1,
    create_time TIMESTAMP NOT NULL default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS t_news;
CREATE TABLE t_news (
    id INT(11) NOT NULL AUTO_INCREMENT,
    news_title VARCHAR(255) NOT NULL,
    news_content TEXT NOT NULL,
    news_author VARCHAR(255) NOT NULL,
    news_flag INT DEFAULT 1,
    create_time TIMESTAMP NOT NULL default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS t_video;
CREATE TABLE t_video(
    id INT(11) NOT NULL AUTO_INCREMENT,
    video_name VARCHAR(255) NOT NULL,
    video_href VARCHAR(255) NOT NULL,
    lessson_id INT(11) NOT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;