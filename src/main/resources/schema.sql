
--Author

create table Author (
 id int auto_increment primary key,
 first_Name varchar(100) not null,
 last_name varchar(100) not null,
 email varchar(255) not null,
 userName varchar(100) not null
);

-- Post

 create table Post (

   id int auto_increment primary key,
   version int ,
   title varchar(255) not null,
   content text not null,
   published_on timestamp not null,
   updated_on timestamp,
   author int ,
   foreign key (author) references Author(id)

 );

 -- Comment

 create table Comment (

  post int not null,
  name varchar(255) not null,
  comment text not null,
  published_on timestamp not null,
  updated_on timestamp,
  foreign key (post) references Post(id)
 );