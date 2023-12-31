-- create student table
create table student (
                         id integer not null,
                         first_name varchar(100) not null,
                         last_name varchar(100) not null,
                         email varchar(255),
                         age int,
                         primary key (id)
);

-- create a sequence for student ide
create sequence student_sequence as integer increment 1;

-- create book table
create table book (
                      id integer not null,
                      name varchar(100) not null,
                      created_at timestamp,
                      student_id integer,
                      primary key (id)
);

alter table book add constraint FK_Book_RefStudent foreign key (student_id)
    references student (id) on delete restrict on update restrict;

create sequence book_sequence as integer increment 1;


-- create a course table
create table course (
                        id integer not null,
                        name varchar(100) not null,
                        department varchar(100) not null,
                        primary key (id)
);
create sequence course_sequence as integer increment 1;


-- create enrollment table
create table enrollment (
                            id bigint not null,
                            grade integer  not null,
                            created_at timestamp not null,
                            student_id integer,
                            course_id integer,
                            primary key (id)
);
create sequence enrollment_sequence as integer increment 1;

alter table enrollment add constraint FK_Enrollment_Ref_Student foreign key (student_id)
    references student (id) on delete restrict on update restrict;

alter table enrollment add constraint  FK_Enrollment_Ref_Course foreign key (course_id)
    references course (id) on delete restrict on update restrict;