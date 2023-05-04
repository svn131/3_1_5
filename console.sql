  insert into 314db.users ( first_name, last_name, password, age, username)
        values ('user', 'user', '$2a$12$ENAAz26.lGK7IpHGRhOq5OfXw4geKU5ScLBChm1o3SR4PAVnu82Hy', 10, 'user@mail.ru');

insert into 314db.roles (role_name) value ('ROLE_USER');
insert into 314db.roles (role_name) value ('ROLE_ADMIN');

insert into 314db.users_roles (user_id, role_id) VALUES (1, 1);
insert into 314db.users_roles (user_id, role_id) VALUES (2, 1);
insert into 314db.users_roles (user_id, role_id) VALUES (2, 2);

insert into 314db.users (first_name, last_name, password, age, username)
values ('admin', 'admin', '$2a$12$eoIh3U2njGPs1QS1bpX3nuaYxensxXpe9gR7kk/EWovtAUhxMEiaa', 20, 'admin@mail.ru');

