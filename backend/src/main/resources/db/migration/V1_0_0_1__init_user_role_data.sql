insert into twat_user (id, username, password, email, fullname)
values (1, 'test', 'test', 'test@vuphan.net', 'test user');

insert into twat_user (id, username, password, email, fullname)
values (2, 'adminuser', 'adminuser', 'adminuser@vuphan.net', 'admin user');

insert into twat_role (id, name)
values (1, 'admin');

insert into twat_user_role (id, user_id, role_id)
values (1, 2, 1);