insert into roles values (1, 'user', 'The default role given to all users.');
insert into roles values (2, 'admin', 'The administrator role only given to site admins');
insert into roles_permissions values (2, 'user:*');
insert into users(id,username,email,password) values (1, 'admin', 'sample@shiro.apache.org', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');
insert into users(id,username,email,password) values (2, 'user', 'sample@shiro.apache.org', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb');
insert into users_roles values (1, 2);